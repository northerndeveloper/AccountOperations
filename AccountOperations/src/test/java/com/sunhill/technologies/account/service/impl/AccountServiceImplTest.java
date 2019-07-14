package com.sunhill.technologies.account.service.impl;

import com.sunhill.technologies.account.model.Account;
import com.sunhill.technologies.account.service.AccountService;
import org.junit.Test;
import org.mockito.stubbing.Answer;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class AccountServiceImplTest {


    private Account account = new Account();

    @Test
    public void deposit() {

        AccountService accountService = mock(AccountService.class);
        accountService.deposit(account, new BigDecimal(750));

        verify(accountService, times(1)).deposit(account, new  BigDecimal(750));

        doAnswer((Answer) invocation -> {
            Object arg0 = invocation.getArgument(0);
            Object arg1 = invocation.getArgument(1);

            assertEquals(account, arg0);
            assertEquals(new BigDecimal(750), arg1);
            return null;
        }).when(accountService).deposit(any(Account.class), any(BigDecimal.class));
        accountService.deposit(account, new BigDecimal(750));
    }

    @Test
    public void transferAccount() {

        AccountService accountService = mock(AccountService.class);
        accountService.withdraw(account, new BigDecimal(6400));

        verify(accountService, times(1)).withdraw(account, new  BigDecimal(6400));

        doAnswer((Answer) invocation -> {
            Object arg0 = invocation.getArgument(0);
            Object arg1 = invocation.getArgument(1);

            assertEquals(account, arg0);
            assertEquals(new BigDecimal(6400), arg1);
            return null;
        }).when(accountService).withdraw(any(Account.class), any(BigDecimal.class));
        accountService.withdraw(account, new BigDecimal(6400));
    }

}