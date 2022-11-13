package se.vegas.tasknz.exception;

import lombok.Getter;

/**
 * Date: 10.11.2022
 *
 * @author Nikolay Zinin
 */
@Getter
public class TransactionIdRedundantException extends WalletException {
    public TransactionIdRedundantException(Long walletId, String descriptionMessage) {
        super(walletId, descriptionMessage);
    }
}

