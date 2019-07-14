package com.sunhill.technologies.account.controller;

import com.sunhill.technologies.account.model.Account;

import java.math.BigDecimal;

public interface AccountController {
    void deposit(Account account, BigDecimal amountToDeposit);

    void withdraw(Account account, BigDecimal amountToWithdraw);
}
