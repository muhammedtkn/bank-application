package com.muhammed.bankapplication.credit.entity;

import com.muhammed.bankapplication.general.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name="CREDIT_PAYMENT")
public class CreditPayment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CreditPayment")
    @SequenceGenerator(name = "CreditPayment", sequenceName = "CREDIT_PAYMENT_ID_SEQ")
    @Column(name = "ID")
    private Long id;

    @Column(name = "ID_CREDIT",nullable = false)
    private Long creditId;

    @Column(name = "ID_CREDIT_INSTALLMENT")
    private Long installmentId;

    @Column(name = "AMOUNT", precision = 19, scale = 2, nullable = false)
    private BigDecimal amount;

    @Column(name = "DATE",nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate date;
}