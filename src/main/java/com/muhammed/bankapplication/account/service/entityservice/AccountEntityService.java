package com.muhammed.bankapplication.account.service.entityservice;

import com.muhammed.bankapplication.account.dao.AccountDao;
import com.muhammed.bankapplication.account.entity.Account;
import com.muhammed.bankapplication.general.service.BaseEntityService;
import org.springframework.stereotype.Service;
@Service
public class AccountEntityService extends BaseEntityService<Account, AccountDao> {
    public AccountEntityService(AccountDao dao) {
        super(dao);
    }


}
