package se.vegas.tasknz.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Date: 10.11.2022
 *
 * @author Nikolay Zinin
 */
@Getter
public class PlayerIdRedundantException extends WalletException {

    public PlayerIdRedundantException(Long walletId, String descriptionMessage) {
       super(walletId, descriptionMessage);
    }
}

