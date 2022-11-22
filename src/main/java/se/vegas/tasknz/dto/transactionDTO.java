package se.vegas.tasknz.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Date: 10.11.2022
 *
 * @author Nikolay Zinin
 */
@Getter
@Setter
@Builder
public class transactionDTO {
    private String transactionId;
    private String playerId;
    private BigDecimal amount;
}
