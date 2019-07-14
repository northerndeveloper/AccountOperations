package com.sunhill.technologies.account.service.impl;

import com.sunhill.technologies.account.constants.AccountConstants;
import com.sunhill.technologies.account.model.Account;
import com.sunhill.technologies.account.service.AccountService;
import com.sunhill.technologies.account.service.exception.AccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.math.BigDecimal;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    private static final Logger LOG = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Transient
    public void deposit(Account account, BigDecimal amountToDeposit) {


        if (account == null || account.getAccountId() == null) {
            LOG.error("Account can not be empty");
            throw new AccountException(AccountConstants.ACCOUNT_IS_NULL);
        }

        if (amountToDeposit == null || amountToDeposit.compareTo(BigDecimal.ZERO) == 0) {
            LOG.error("Deposit value not be empty");
            throw new AccountException(AccountConstants.DEPOSIT_VALUE_IS_EMPTY);
        }

        if (amountToDeposit.compareTo(new BigDecimal(0)) < 0) {
            LOG.error("Amount to Deposit should be smaller than 0. Desired amount " + amountToDeposit);
            throw new AccountException(AccountConstants.INVALID_AMOUNT_TO_DEPOSIT);
        }

        account.setBalance(account.getBalance().add(amountToDeposit));
        LOG.info("Deposit of account is completed successfully. Account ID  " + account.getAccountId() + ". Deposited amount =  " + amountToDeposit +
                " . New Balance of the account after deposit = " + account.getBalance());

    }

    @Transient
    public void withdraw(Account account, BigDecimal amountToWithdraw) {

        if (account == null || account.getAccountId() == null) {
            LOG.error("Account can not be empty");
            throw new AccountException(AccountConstants.ACCOUNT_IS_NULL);
        }

        if (amountToWithdraw == null || amountToWithdraw.compareTo(BigDecimal.ZERO) == 0) {
            LOG.error("Withdraw value not be empty");
            throw new AccountException(AccountConstants.WITHDRAW_VALUE_IS_EMPTY);
        }

        if (amountToWithdraw.compareTo(new BigDecimal(0)) < 0) {
            LOG.error("Amount to Withdraw should be smaller than 0. Desired amount " + amountToWithdraw);
            throw new AccountException(AccountConstants.INVALID_AMOUNT_TO_WITHDRAW);
        }

        if (amountToWithdraw.compareTo(account.getBalance()) > 0) {
            LOG.error("Your current balance is not enough for the desired withdraw of amount. Your balance " + account.getBalance());
            throw new AccountException(AccountConstants.ACCOUNT_MONEY_IS_NOT_ENOUGH);
        }

        account.setBalance(account.getBalance().subtract(amountToWithdraw));
        LOG.info("Withdraw of account is completed successfully. Account ID  " + account.getAccountId() + ". Withdrawed amount =  " + amountToWithdraw +
                " . New Balance of the account after withdraw = " + account.getBalance());
    }
}
