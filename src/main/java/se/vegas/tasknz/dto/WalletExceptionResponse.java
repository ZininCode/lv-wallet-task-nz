package se.vegas.tasknz.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

/**
 * Date: 10.11.2022
 *
 * @author Nikolay Zinin
 */
@Getter
@Setter
@Builder
public class WalletExceptionResponse {
    private int statusCode;
    private Date timestamp;
    private String path;
    private String descriptionMessage;
}
