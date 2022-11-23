package se.vegas.tasknz.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Date: 10.11.2022
 *
 * @author Nikolay Zinin
 */
@Getter
@AllArgsConstructor
public class PlayerException extends Exception {
    private final String playerId;
    private final String descriptionMessage;
}
