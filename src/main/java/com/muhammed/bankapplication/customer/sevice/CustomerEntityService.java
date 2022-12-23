package com.muhammed.bankapplication.customer.sevice;

import com.muhammed.bankapplication.customer.dao.CustomerDao;
import com.muhammed.bankapplication.customer.entity.Customer;
import com.muhammed.bankapplication.general.service.BaseEntityService;
import org.springframework.stereotype.Service;

@Service
public class CustomerEntityService extends BaseEntityService<Customer, CustomerDao> {

    public Customer findByIdentityNo(Long identityNo){
        return getDao().findByIdentityNo(identityNo);
    }
    public CustomerEntityService(CustomerDao dao) {
        super(dao);
    }

}
