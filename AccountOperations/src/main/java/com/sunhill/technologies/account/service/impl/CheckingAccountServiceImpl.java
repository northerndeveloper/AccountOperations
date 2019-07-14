package com.sunhill.technologies.account.service.impl;

import com.sunhill.technologies.account.constants.AccountConstants;
import com.sunhill.technologies.account.model.CheckingAccount;
import com.sunhill.technologies.account.service.CheckingAccountService;
import com.sunhill.technologies.account.service.exception.AccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.math.BigDecimal;

@Service("checkingAccountService")
public class CheckingAccountServiceImpl implements CheckingAccountService {

    private static final Logger LOG = LoggerFactory.getLogger(CheckingAccountServiceImpl.class);

    @Override
    @Transient
    public void balanceOverDraft(CheckingAccount account, BigDecimal demandedOverDraftAmount) {

        if (demandedOverDraftAmount.compareTo(account.getOverDraftLimit()) > 0) {
            LOG.error("Your Overdraft Limit Exceeds Your Demanded Value");
            throw new AccountException(AccountConstants.OVERDRAFT_LIMIT_EXCEEDS_YOUR_DEMAND_VALUE);
        }

        account.setBalance(account.getBalance().subtract(demandedOverDraftAmount));

        LOG.info("After OverDraft Your Total Balance is " + account.getBalance());

        account.setOverDraftLimit(account.getOverDraftLimit().divide(new BigDecimal(2)));

        LOG.info("After Overdraft Your Total Overdraft Limit is " + account.getOverDraftLimit());

    }

    @Override
    @Transient
    public void transferAccount(CheckingAccount accountTransferFrom, CheckingAccount accountTransferTo, BigDecimal demandedTransferAmount) {

        if (demandedTransferAmount.compareTo(accountTransferFrom.getBalance()) > 0) {
            LOG.error("You do not have enough balance to make transfer");
            throw new AccountException(AccountConstants.BALANCE_NOT_ENOUGH_FOR_TRANSFER);
        }

        accountTransferFrom.setBalance(accountTransferFrom.getBalance().subtract(demandedTransferAmount));
        accountTransferTo.setBalance(accountTransferTo.getBalance().add(demandedTransferAmount));

        LOG.info("Amount Transfers are completd.New Balance at the transferred account is " + accountTransferTo.getBalance() +
                ".New Balance at the accout where transaction was made from is " + accountTransferFrom.getBalance());
    }
}
