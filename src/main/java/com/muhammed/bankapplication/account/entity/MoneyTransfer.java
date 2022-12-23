package com.muhammed.bankapplication.account.entity;

import com.muhammed.bankapplication.account.enums.MoneyTransferType;
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
public class MoneyTransfer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MoneyTransfer")
    @SequenceGenerator(name = "MoneyTransfer", sequenceName = "MONEY_TRANSFER_ID_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "ID_ACCOUNT_FROM", nullable = false)
    private Long accountIdFrom;

    @Column(name = "ID_ACCOUNT_TO", nullable = false)
    private Long accountIdTo;

    @Column(name = "AMOUNT", precision = 19, scale = 2, nullable = false)
    private BigDecimal amount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TRANSACTION_DATE", nullable = false)
    private LocalDateTime transactionDate;

    @Column(name = "DESCRIPTION", nullable = false, length = 50)
    private String description;

    @Column(name = "MONEY_TRANSFER_TYPE", length = 30, nullable = false)
    @Enumerated(EnumType.STRING)
    private MoneyTransferType moneyTransferType;
}
