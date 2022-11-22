package se.vegas.tasknz.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import se.vegas.tasknz.dto.PlayerDto;
import se.vegas.tasknz.dto.transactionDTO;
import se.vegas.tasknz.dto.TransactionHistoryDto;
import se.vegas.tasknz.exception.NotEnoughCreditException;
import se.vegas.tasknz.exception.TransactionIdRedundantException;
import se.vegas.tasknz.exception.WalletNotFoundException;
import se.vegas.tasknz.service.TransactionService;
import se.vegas.tasknz.service.WalletService;

import java.util.List;

/**
 * Date: 10.11.2022
 *
 * @author Nikolay Zinin
 */
@RestController
@RequestMapping("/api/transaction")
@AllArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;
    private final WalletService walletService;

    @PostMapping(path = "/credit", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addCreditToPlayerBalance(@RequestBody transactionDTO transactionDTO)
            throws WalletNotFoundException, TransactionIdRedundantException {
        transactionService.credit(transactionDTO);
    }

    @PostMapping(path = "/debit", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void withdrawalFromPlayerBalance(@RequestBody transactionDTO transactionDTO)
            throws WalletNotFoundException, NotEnoughCreditException, TransactionIdRedundantException {
        transactionService.debit(transactionDTO);
    }

    @PostMapping ("/history")
    public List<TransactionHistoryDto> getPlayerTransactionHistory(@RequestBody PlayerDto player)
            throws WalletNotFoundException {
        return walletService.getAllTransactionsByPlayerId(player.getPlayerId());
    }
}
