package com.muhammed.bankapplication.credit.dao;

import com.muhammed.bankapplication.credit.entity.Credit;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

@Data
public interface CreditDao  extends JpaRepository<Credit, Long> {


}
