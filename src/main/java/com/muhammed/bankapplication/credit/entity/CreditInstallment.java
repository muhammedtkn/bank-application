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
@Table(name="CREDIT_INSTALLMENT")
public class CreditInstallment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CreditInstallment")
    @SequenceGenerator(name = "CreditInstallment", sequenceName = "CREDIT_INSTALLMENT_ID_SEQ")
    @Column(name = "ID")
    private Long id;

    @Column(name="ID_CREDIT",nullable = false)
    private Long creditId;

    @Column(name="ORDER_NO",length = 50,nullable = false)
    private String orderNo;

    @Column(name="MONTHLY_INSTALLMENT_AMOUNT",precision = 19,scale = 2,nullable = false)
    private BigDecimal monthlyInstallmentAmount;

    @Column(name="INTEREST_TO_BE_PAID",precision = 19,scale = 2,nullable = false)
    private  BigDecimal interestToBePaid;

    @Column(name="PRINCIPAL_TO_BE_PAID",precision = 19,scale = 2,nullable = false)
    private BigDecimal principalToBePaid;

    @Column(name="REMAINING_PRINCIPAL",precision = 19,scale = 2,nullable = false)
    private  BigDecimal remainingPrincipal;

    @Column(name="DUE_DATE",nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate dueDate;
}