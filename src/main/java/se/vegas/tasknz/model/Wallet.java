package se.vegas.tasknz.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
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
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column
    private Long playerId;
    @Column
    private BigDecimal balance;
    @OneToMany(mappedBy = "wallet")
    private List<WalletTransaction> walletTransactions;
}
