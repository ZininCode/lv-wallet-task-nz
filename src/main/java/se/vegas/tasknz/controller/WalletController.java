package se.vegas.tasknz.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import se.vegas.tasknz.dto.BalanceDto;
import se.vegas.tasknz.dto.PlayerDto;
import se.vegas.tasknz.exception.PlayerIdRedundantException;
import se.vegas.tasknz.exception.WalletNotFoundException;
import se.vegas.tasknz.service.WalletService;

/**
 * Date: 10.11.2022
 *
 * @author Nikolay Zinin
 */
@RestController
@RequestMapping("/api/wallet")
@AllArgsConstructor
public class WalletController {
    private final WalletService walletService;

    @PostMapping (path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createWallet(@RequestBody PlayerDto playerDto) throws PlayerIdRedundantException {
        walletService.createWallet(playerDto.getPlayerId());
    }

    @GetMapping(path = "/balance")
    public BalanceDto getPlayerCurrentBalance(@RequestParam String playerId) throws WalletNotFoundException {
        return walletService.getPlayerBalance(playerId);
    }
}
