package com.sunhill.technologies.account.controller;

import com.sunhill.technologies.account.model.Account;

public interface SavingAccountController {

    void giveInterestPayment(Account account, int desiredMountsForInteret);
}
