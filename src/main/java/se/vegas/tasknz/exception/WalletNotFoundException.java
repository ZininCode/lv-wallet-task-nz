package se.vegas.tasknz.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * Date: 10.11.2022
 *
 * @author Nikolay Zinin
 */
@Getter
@Setter
public class WalletNotFoundException extends PlayerException{
    public WalletNotFoundException(String playerId, String descriptionMessage) {
     super(playerId, descriptionMessage);
    }
}

