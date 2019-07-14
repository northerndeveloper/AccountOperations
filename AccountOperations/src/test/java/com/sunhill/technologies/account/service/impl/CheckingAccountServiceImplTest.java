package com.sunhill.technologies.account.service.impl;

import com.sunhill.technologies.account.model.CheckingAccount;
import com.sunhill.technologies.account.service.CheckingAccountService;
import org.junit.Test;
import org.mockito.stubbing.Answer;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class CheckingAccountServiceImplTest {

    private CheckingAccount checkingAccount = new CheckingAccount();

    @Test
    public void balanceOverDraft() {

        CheckingAccountService checkingAccountService = mock(CheckingAccountService.class);
        checkingAccountService.balanceOverDraft(checkingAccount, new BigDecimal(750));

        verify(checkingAccountService, times(1)).balanceOverDraft(checkingAccount, new  BigDecimal(750));

        doAnswer((Answer) invocation -> {
            Object arg0 = invocation.getArgument(0);
            Object arg1 = invocation.getArgument(1);

            assertEquals(checkingAccount, arg0);
            assertEquals(new BigDecimal(750), arg1);
            return null;
        }).when(checkingAccountService).balanceOverDraft(any(CheckingAccount.class), any(BigDecimal.class));
        checkingAccountService.balanceOverDraft(checkingAccount, new BigDecimal(750));
    }

    @Test
    public void transferAccount() {

        CheckingAccountService checkingAccountService = mock(CheckingAccountService.class);
        checkingAccountService.transferAccount(checkingAccount, checkingAccount, new BigDecimal(1750));

        verify(checkingAccountService, times(1)).transferAccount(checkingAccount, checkingAccount, new  BigDecimal(1750));

        doAnswer((Answer) invocation -> {
            Object arg0 = invocation.getArgument(0);
            Object arg1 = invocation.getArgument(1);
            Object arg2 = invocation.getArgument(2);

            assertEquals(checkingAccount, arg0);
            assertEquals(checkingAccount, arg1);
            assertEquals(new BigDecimal(1750), arg2);
            return null;
        }).when(checkingAccountService).transferAccount(any(CheckingAccount.class), any(CheckingAccount.class),any(BigDecimal.class));
        checkingAccountService.transferAccount(checkingAccount, checkingAccount, new BigDecimal(1750));
    }
}