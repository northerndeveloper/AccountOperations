package com.sunhill.technologies.account.controller;

import com.sunhill.technologies.account.model.CheckingAccount;

import java.math.BigDecimal;

public interface CheckingAccountController {

    void balanceOverDraft(CheckingAccount account, BigDecimal demandedOverDraftAmount);

    void transferAccount(CheckingAccount accountTransferFrom, CheckingAccount accountTransferTo, BigDecimal demandedTransferAmount);
}
