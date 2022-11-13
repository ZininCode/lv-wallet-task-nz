package se.vegas.tasknz.exception;

import lombok.Getter;

import java.util.UUID;

/**
 * Date: 10.11.2022
 *
 * @author Nikolay Zinin
 */
@Getter
public class WalletNotFoundException extends WalletException {
    public WalletNotFoundException(Long walletId, String descriptionMessage) {
        super(walletId, descriptionMessage);
    }
}

