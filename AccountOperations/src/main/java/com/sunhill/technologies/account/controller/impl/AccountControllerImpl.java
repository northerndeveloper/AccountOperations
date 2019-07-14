package com.sunhill.technologies.account.controller.impl;

import com.sunhill.technologies.account.controller.AccountController;
import com.sunhill.technologies.account.model.Account;
import com.sunhill.technologies.account.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class AccountControllerImpl implements AccountController {

    private static final Logger LOG = LoggerFactory.getLogger(AccountControllerImpl.class);

    @Autowired
    private AccountService accountService;

    @Override
    public void deposit(Account account, BigDecimal amountToDeposit) {
        LOG.info("Deposit operation started");
        accountService.deposit(account, amountToDeposit);
        LOG.info("Deposit operation completed");
    }

    @Override
    public void withdraw(Account account, BigDecimal amountToWithdraw) {
        LOG.info("Withdraw operation started");
        accountService.withdraw(account, amountToWithdraw);
        LOG.info("Withdraw operation completed");
    }


}
