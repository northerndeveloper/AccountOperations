package com.sunhill.technologies.account.service;

import com.sunhill.technologies.account.model.Account;

import java.beans.Transient;
import java.math.BigDecimal;

public interface SavingAccountService {

    @Transient
    void giveInterestPayment(Account account, int desiredMountsForInteret);

    BigDecimal calculateInterestOfAmount(BigDecimal balance, int desiredMountsForInterest);

    double calculateInterestRateOfTheAccount(BigDecimal balance);
}
