package se.vegas.tasknz.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Date: 10.11.2022
 *
 * @author Nikolay Zinin
 */
@Getter
@Setter
@Builder
public class PlayerExceptionResponse {
    private int statusCode;
    private Date timestamp;
    private String playerId;
    private String path;
    private String descriptionMessage;
}
