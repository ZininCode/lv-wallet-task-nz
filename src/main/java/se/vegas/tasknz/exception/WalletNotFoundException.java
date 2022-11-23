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
public class WalletNotFoundException extends WalletException{
    public WalletNotFoundException(String descriptionMessage) {
     super(descriptionMessage);
    }
}

