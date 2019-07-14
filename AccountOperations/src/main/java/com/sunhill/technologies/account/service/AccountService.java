package com.sunhill.technologies.account.service;

import com.sunhill.technologies.account.model.Account;

import java.math.BigDecimal;

public interface AccountService {

    void deposit(Account account, BigDecimal amountToDeposit);

    void withdraw(Account account, BigDecimal amountToWithdraw);
}
