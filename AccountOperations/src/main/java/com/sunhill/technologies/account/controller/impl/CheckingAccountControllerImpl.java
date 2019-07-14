package com.sunhill.technologies.account.controller.impl;

import com.sunhill.technologies.account.controller.CheckingAccountController;
import com.sunhill.technologies.account.model.CheckingAccount;
import com.sunhill.technologies.account.service.CheckingAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;

@Controller("checkingAccountController")
public class CheckingAccountControllerImpl implements CheckingAccountController {

    private static final Logger LOG = LoggerFactory.getLogger(CheckingAccountControllerImpl.class);

    @Autowired
    private CheckingAccountService checkingAccountService;

    @Override
    public void balanceOverDraft(CheckingAccount account, BigDecimal demandedOverDraftAmount) {
        LOG.info("Balance Over Draft Method operation started");
        checkingAccountService.balanceOverDraft(account, demandedOverDraftAmount);
        LOG.info("Balance Over Draft Method operation completed");

    }

    @Override
    public void transferAccount(CheckingAccount accountTransferFrom, CheckingAccount accountTransferTo, BigDecimal demandedTransferAmount) {
        LOG.info("Transfer Account Method operation started");
        checkingAccountService.transferAccount(accountTransferFrom, accountTransferTo, demandedTransferAmount);
        LOG.info("Transfer Account Method operation completed");
    }

}
