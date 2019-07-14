package com.sunhill.technologies.account.service.impl;

import com.sunhill.technologies.account.model.Account;
import com.sunhill.technologies.account.model.SavingAccount;
import com.sunhill.technologies.account.service.SavingAccountService;
import org.junit.Test;
import org.mockito.stubbing.Answer;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class SavingAccountServiceImplTest {

    private Account account = new SavingAccount();

    @Test
    public void giveInterestPayment() {

        SavingAccountService savingAccountService = mock(SavingAccountService.class);
        savingAccountService.giveInterestPayment(account, 1000);

        verify(savingAccountService, times(1)).giveInterestPayment(account, 1000);

        doAnswer((Answer) invocation -> {
            Object arg0 = invocation.getArgument(0);
            Object arg1 = invocation.getArgument(1);

            assertEquals(account, arg0);
            assertEquals(1000, arg1);
            return null;
        }).when(savingAccountService).giveInterestPayment(any(Account.class), any(Integer.class));
        savingAccountService.giveInterestPayment(account, 1000);

    }

    @Test
    public void calculateInterestOfAmount() {

        SavingAccountService savingAccountService = mock(SavingAccountService.class);
        savingAccountService.calculateInterestOfAmount(new BigDecimal(500), 2);

        verify(savingAccountService, times(1)).calculateInterestOfAmount(new BigDecimal(500), 2);

        doAnswer((Answer) invocation -> {
            Object arg0 = invocation.getArgument(0);
            Object arg1 = invocation.getArgument(1);

            assertEquals(new BigDecimal(500), arg0);
            assertEquals(2, arg1);
            return null;
        }).when(savingAccountService).calculateInterestOfAmount(any(BigDecimal.class), any(Integer.class));
        savingAccountService.calculateInterestOfAmount(new BigDecimal(500), 2);

    }

    @Test
    public void calculateInterestRateOfTheAccount() {

        SavingAccountService savingAccountService = mock(SavingAccountService.class);
        savingAccountService.calculateInterestRateOfTheAccount(new BigDecimal(1000));

        verify(savingAccountService, times(1)).calculateInterestRateOfTheAccount(new BigDecimal(1000));

        doAnswer((Answer) invocation -> {
            Object arg0 = invocation.getArgument(0);

            assertEquals(new BigDecimal(1000), arg0);
            return null;
        }).when(savingAccountService).calculateInterestRateOfTheAccount(any(BigDecimal.class));
        savingAccountService.calculateInterestRateOfTheAccount(new BigDecimal(1000));

    }
}