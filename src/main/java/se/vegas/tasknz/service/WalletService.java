package se.vegas.tasknz.service;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import se.vegas.tasknz.dto.BalanceDto;
import se.vegas.tasknz.dto.TransactionHistoryDto;
import se.vegas.tasknz.exception.WalletNotFoundException;
import se.vegas.tasknz.model.Wallet;
import se.vegas.tasknz.repository.WalletRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Date: 10.11.2022
 *
 * @author Nikolay Zinin
 */
@Slf4j
@Service
@AllArgsConstructor
public class WalletService {

    private final MappingService mappingService;
    private final WalletRepository walletRepository;

    public Wallet getWalletByPlayerId(Long playerId) throws WalletNotFoundException {
        return walletRepository.findByPlayerId(playerId).orElseThrow(() -> {
            log.error(String.format("Player with id %s not found", playerId));
            return new WalletNotFoundException(playerId, "Player not found");
        });
    }

    public BalanceDto getPlayerBalance(Long playerId) throws WalletNotFoundException {
        Wallet wallet = getWalletByPlayerId(playerId);
        return mappingService.mapWalletToBalanceDto(wallet);
    }

    public List<TransactionHistoryDto> getAllTransactionsByPlayerId(long playerId) throws WalletNotFoundException {
        Wallet wallet = getWalletByPlayerId(playerId);
        return wallet.getWalletTransactions().stream()
                .map(new MappingService()::transactionToDto)
                .collect(Collectors.toList());
    }
}
