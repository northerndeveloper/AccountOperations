package com.sunhill.technologies.account.service.impl;

import com.sunhill.technologies.account.constants.AccountConstants;
import com.sunhill.technologies.account.model.Account;
import com.sunhill.technologies.account.service.SavingAccountService;
import com.sunhill.technologies.account.service.exception.AccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.math.BigDecimal;


@Service("savingAccountService")
public class SavingAccountServiceImpl implements SavingAccountService {

    private static final Logger LOG = LoggerFactory.getLogger(SavingAccountServiceImpl.class);

    @Transient
    @Override
    public void giveInterestPayment(Account account, int desiredMountsForInteret) {

        if (account == null || account.getAccountId() == null) {
            LOG.error("Account can not be empty");
            throw new AccountException(AccountConstants.ACCOUNT_IS_NULL);
        }

        if (desiredMountsForInteret == 0 || desiredMountsForInteret < 0) {
            LOG.error("Withdraw value not be empty");
            throw new AccountException(AccountConstants.DESIRED_AMOUNT_FOR_INTEREST_MONTH);
        }

        BigDecimal calculatedInterestAmount = calculateInterestOfAmount(account.getBalance(), desiredMountsForInteret);
        calculatedInterestAmount = calculatedInterestAmount.setScale(3, BigDecimal.ROUND_HALF_EVEN);
        LOG.info("Calculated Interest amount is = " + calculatedInterestAmount);

        account.setBalance(account.getBalance().add(calculatedInterestAmount));
        LOG.info("New balance of the account is = " + account.getBalance());
    }

    @Override
    public BigDecimal calculateInterestOfAmount(BigDecimal balance, int desiredMountsForInterest) {

        double interestRate = calculateInterestRateOfTheAccount(balance);

        double amountAfterInterest = (12 * desiredMountsForInterest * interestRate) / 100;
        LOG.info("Amount after Interest is = " + amountAfterInterest);

        return new BigDecimal(amountAfterInterest);
    }

    @Override
    public double calculateInterestRateOfTheAccount(BigDecimal balance) {

        if (balance.compareTo(new BigDecimal(1000)) < 0) {
            return 1.2;
        } else if (balance.compareTo(new BigDecimal(5000)) < 0) {
            return 2.4;
        } else if (balance.compareTo(new BigDecimal(7500)) < 0) {
            return 3.6;
        } else if (balance.compareTo(new BigDecimal(10000)) < 0) {
            return 4.8;
        } else {
            return 8;
        }
    }
}
