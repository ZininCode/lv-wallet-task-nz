package se.vegas.tasknz.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

/**
 * Date: 10.11.2022
 *
 * @author Nikolay Zinin
 */
@Getter
@AllArgsConstructor
public class WalletException extends Exception {
    private final Long walletId;
    private final String descriptionMessage;
}
