package com.sunhill.technologies.account.service;

import com.sunhill.technologies.account.model.CheckingAccount;

import java.beans.Transient;
import java.math.BigDecimal;

public interface CheckingAccountService {

    @Transient
    void balanceOverDraft(CheckingAccount account, BigDecimal demandedOverDraftAmount);

    @Transient
    void transferAccount(CheckingAccount accountTransferFrom, CheckingAccount accountTransferTo, BigDecimal demandedTransferAmount);
}
