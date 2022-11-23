package se.vegas.tasknz.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import se.vegas.tasknz.dto.transactionDTO;
import se.vegas.tasknz.exception.NotEnoughCreditException;
import se.vegas.tasknz.exception.TransactionIdRedundantException;
import se.vegas.tasknz.exception.WalletNotFoundException;
import se.vegas.tasknz.model.TransactionType;
import se.vegas.tasknz.model.Wallet;
import se.vegas.tasknz.model.WalletTransaction;
import se.vegas.tasknz.repository.TransactionRepository;
import se.vegas.tasknz.repository.WalletRepository;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Optional;

/**
 * Date: 10.11.2022
 *
 * @author Nikolay Zinin
 */
@Service
@AllArgsConstructor
@Slf4j
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final WalletRepository walletRepository;
    private final WalletService walletService;

    public void credit(transactionDTO transactionDTO) throws WalletNotFoundException, TransactionIdRedundantException {
        checkTransactionId(transactionDTO);
        Wallet wallet = walletService.getWalletByPlayerId(transactionDTO.getPlayerId());
        BigDecimal newBalance = wallet.getBalance().add(transactionDTO.getAmount());
        makeTransaction(transactionDTO, wallet, newBalance, TransactionType.CREDIT);
    }

    public void debit(transactionDTO transactionDTO) throws WalletNotFoundException, NotEnoughCreditException, TransactionIdRedundantException {
        checkTransactionId(transactionDTO);
        Wallet wallet = walletService.getWalletByPlayerId(transactionDTO.getPlayerId());
        BigDecimal newBalance = wallet.getBalance().subtract(transactionDTO.getAmount());
        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
            log.error("Not enough money on balance");
            throw new NotEnoughCreditException("Not enough money on balance");
        }
        makeTransaction(transactionDTO, wallet, newBalance, TransactionType.DEBIT);
    }

    private void checkTransactionId(transactionDTO transactionDTO) throws TransactionIdRedundantException {
        Optional<WalletTransaction> transaction = transactionRepository.findById(transactionDTO.getTransactionId());
        if (transaction.isPresent()) {
            log.error(String.format("Transaction with id %s already exists", transactionDTO.getTransactionId()));
            throw new TransactionIdRedundantException("Transaction with id " +  transactionDTO.getTransactionId() +" already exists");
        }
    }

    private void makeTransaction(transactionDTO transactionDTO, Wallet wallet, BigDecimal newBalance, TransactionType transactionType) {
        WalletTransaction transaction = new MappingService().mapPaymentDtoToEntity(transactionDTO);
        wallet.setBalance(newBalance);
        transaction.setWallet(wallet);
        transaction.setTransactionType(transactionType);
        transaction.setTransactionTime(Instant.now());
        walletRepository.save(wallet);
        transactionRepository.save(transaction);
    }
}
