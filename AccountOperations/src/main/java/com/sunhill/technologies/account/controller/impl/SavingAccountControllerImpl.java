package com.sunhill.technologies.account.controller.impl;

import com.sunhill.technologies.account.controller.SavingAccountController;
import com.sunhill.technologies.account.model.Account;
import com.sunhill.technologies.account.service.SavingAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller("savingAccountController")
public class SavingAccountControllerImpl implements SavingAccountController {

    private static final Logger LOG = LoggerFactory.getLogger(SavingAccountControllerImpl.class);

    @Autowired
    private SavingAccountService savingAccountService;

    @Override
    public void giveInterestPayment(Account account, int desiredMountsForInteret) {
        LOG.info("Give Interest Payment operation started");
        savingAccountService.giveInterestPayment(account, desiredMountsForInteret);
        LOG.info("Give Interest Payment operation completed");
    }


}