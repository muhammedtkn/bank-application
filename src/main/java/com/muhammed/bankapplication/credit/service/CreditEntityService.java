package com.muhammed.bankapplication.credit.service;

import com.muhammed.bankapplication.credit.dao.CreditDao;
import com.muhammed.bankapplication.credit.entity.Credit;
import com.muhammed.bankapplication.general.service.BaseEntityService;
import org.springframework.stereotype.Service;

@Service
public class CreditEntityService extends BaseEntityService<Credit, CreditDao> {

    public CreditEntityService(CreditDao dao) {
        super(dao);
    }
}
