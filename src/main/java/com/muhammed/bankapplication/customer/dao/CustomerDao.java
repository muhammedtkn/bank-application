package com.muhammed.bankapplication.customer.dao;

import com.muhammed.bankapplication.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer, Long> {
}
