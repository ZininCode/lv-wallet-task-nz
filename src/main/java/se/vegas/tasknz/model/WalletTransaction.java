package se.vegas.tasknz.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * Date: 10.11.2022
 *
 * @author Nikolay Zinin
 */
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WalletTransaction {
    @Id
    @Column
    private String id;
    @Enumerated
    @Column
    private TransactionType transactionType;
    @Column
    private BigDecimal amount;
    @ManyToOne
    @JoinColumn(name = "wallet_id", nullable = false)
    private Wallet wallet;
    @Column
    private Instant transactionTime;
}

