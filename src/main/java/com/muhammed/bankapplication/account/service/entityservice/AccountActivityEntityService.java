package com.muhammed.bankapplication.account.service.entityservice;

import com.muhammed.bankapplication.account.dao.AccountActivityDao;
import com.muhammed.bankapplication.account.entity.AccountActivity;
import com.muhammed.bankapplication.general.service.BaseEntityService;
import org.springframework.stereotype.Service;

@Service
public class AccountActivityEntityService extends BaseEntityService<AccountActivity, AccountActivityDao> {
    public AccountActivityEntityService(AccountActivityDao dao) {
        super(dao);
    }
}
