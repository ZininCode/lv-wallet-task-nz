package se.vegas.tasknz.dto;

import lombok.*;

import java.math.BigDecimal;

/**
 * Date: 10.11.2022
 *
 * @author Nikolay Zinin
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
public class BalanceDto {
    private Long playerId;
    private BigDecimal balance;
}
