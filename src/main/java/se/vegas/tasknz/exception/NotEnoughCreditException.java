package se.vegas.tasknz.exception;

import lombok.Getter;

/**
 * Date: 10.11.2022
 *
 * @author Nikolay Zinin
 */
@Getter
public class NotEnoughCreditException extends WalletException {
    public NotEnoughCreditException(Long walletId, String descriptionMessage) {
        super(walletId, descriptionMessage);
    }
}

