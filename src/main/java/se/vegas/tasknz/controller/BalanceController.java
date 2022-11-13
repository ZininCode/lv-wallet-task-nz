package se.vegas.tasknz.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import se.vegas.tasknz.dto.BalanceDto;
import se.vegas.tasknz.exception.WalletNotFoundException;
import se.vegas.tasknz.service.WalletService;

/**
 * Date: 10.11.2022
 *
 * @author Nikolay Zinin
 */
@RestController
@RequestMapping("/api/balance")
@AllArgsConstructor
public class BalanceController {
    private final WalletService walletService;

    @GetMapping
    public BalanceDto getPlayerCurrentBalance(@RequestParam long playerId) throws WalletNotFoundException {
        return walletService.getPlayerBalance(playerId);
    }
}
