package com.muhammed.bankapplication.credit.entity;

import com.muhammed.bankapplication.general.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Entity
@Getter
@Setter
@Table(name="CREDIT")
public class Credit extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Credit")
    @SequenceGenerator(name = "Credit", sequenceName = "CREDIT_ID_SEQ")
    @Column(name = "ID")
    private Long id;

    @Column(name="ID_CUSTOMER",nullable = false)
    private Long customerId;

    @Column(name="INSTALLMENT_COUNT",nullable = false)
    private Long installmentCount;

    @Column(name="CREDIT_AMOUNT",precision =19,scale = 2,nullable = false)
    private BigDecimal creditAmount;

    @Column(name="MONTHLY_INSTALLMENT_AMOUNT",precision = 19,scale = 2,nullable = false)
    private BigDecimal monthlyInstallmentAmount;
}
