package com.muhammed.bankapplication.customer.entity;

import com.muhammed.bankapplication.general.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="CUSTOMER")
@Getter
@Setter
public class Customer extends BaseEntity {
    @Id
    @GeneratedValue(generator = "Customer",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="Customer",sequenceName = "CUSTOMER_ID_SEQ")
    private Long id;

    @Column(name="NAME",nullable = false,length = 30)
    private  String name;

    @Column(name="SURNAME",nullable = false,length = 30)
    private  String surname;

    @Column(name="IDENTIY_NO",nullable = false)
    private  Long identiyNo;

    @Column(name="PASSWORD",nullable = false,length = 30)
    private  String password;


}
