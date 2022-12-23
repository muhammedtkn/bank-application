package com.muhammed.bankapplication.account.entity;

import com.muhammed.bankapplication.account.enums.AccountActivityType;
import com.muhammed.bankapplication.general.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name="ACCOUNT_ACTIVITY")
public class AccountActivity  extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AccountActivity")
    @SequenceGenerator(name = "AccountActivity",sequenceName = "ACCOUNT_ACTIVITY_ID_SEQ",allocationSize = 1)
    @Column(name = "id" )
    private Long id;

    @Column(name="AMOUNT",precision = 19,scale = 2)
    private BigDecimal amount;

    @Column(name="TRANSACTION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDate transactionDate;

    @Column(name="ACCOUNT_ACTIVITY_TYPE",length = 30)
    @Enumerated(EnumType.STRING)
    private AccountActivityType accountActivityType;


    @Column(name="CURRENT_BALANCE",precision = 19,scale = 2)
    private BigDecimal currentBalance;


    @Column(name = "ID_ACCOUNT")
    private Long accountId;
}
