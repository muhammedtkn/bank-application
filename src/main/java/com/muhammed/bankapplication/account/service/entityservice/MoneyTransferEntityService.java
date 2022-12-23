package com.muhammed.bankapplication.account.service.entityservice;

import com.muhammed.bankapplication.account.dao.MoneyTransferDao;
import com.muhammed.bankapplication.account.entity.MoneyTransfer;
import com.muhammed.bankapplication.general.service.BaseEntityService;
import org.springframework.stereotype.Service;

@Service
public class MoneyTransferEntityService extends BaseEntityService<MoneyTransfer, MoneyTransferDao> {

    public MoneyTransferEntityService(MoneyTransferDao dao) {
        super(dao);
    }
}
