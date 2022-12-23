package com.muhammed.bankapplication.account.entity;

import com.muhammed.bankapplication.account.enums.AccountType;
import com.muhammed.bankapplication.account.enums.CurrencyType;
import com.muhammed.bankapplication.general.entity.BaseEntity;
import com.muhammed.bankapplication.general.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name="ACCOUNT")
public class Account extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Account")
    @SequenceGenerator(name = "Account", sequenceName = "ACCOUNT_ID_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "ID_CUSTOMER", nullable = false)
    private Long customerId;

    @Column(name = "IBAN_NO", length = 30, nullable = false)
    private String ibanNo;

    @Column(name = "CURRENT_BALANCE", precision = 19, scale = 2, nullable = false)
    private BigDecimal currentBalance;

    @Column(name = "CURRENCY_TYPE", length = 30, nullable = false)
    @Enumerated(EnumType.STRING)
    private CurrencyType currencyType;

    @Column(name = "ACCOUNT_TYPE", length = 30, nullable = false)
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Column(name = "STATUS", length = 30, nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name="CANCEL_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime cancelDate;
}
