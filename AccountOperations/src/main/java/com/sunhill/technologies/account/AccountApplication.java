package com.sunhill.technologies.account;

import com.sunhill.technologies.account.controller.AccountController;
import com.sunhill.technologies.account.controller.CheckingAccountController;
import com.sunhill.technologies.account.controller.SavingAccountController;
import com.sunhill.technologies.account.model.Account;
import com.sunhill.technologies.account.model.CheckingAccount;
import com.sunhill.technologies.account.model.SavingAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication(scanBasePackages = "com.sunhill.technologies")
public class AccountApplication implements CommandLineRunner {

    @Autowired
    private AccountController accountController;

    @Autowired
    private CheckingAccountController checkingAccountController;

    @Autowired
    private SavingAccountController savingAccountController;

    public static void main(String[] args) {

        SpringApplication.run(AccountApplication.class, args);
    }


    @Override
    public void run(String... args) {

        Account account = new Account(new Long(1001), "Alper Kopuz", new BigDecimal(1500));
        accountController.deposit(account, new BigDecimal(100));

        accountController.withdraw(account, new BigDecimal(50));


        CheckingAccount checkingAccount = CheckingAccount.builder()
                .accountID(new Long(1002))
                .owner("Thomas Anderson")
                .balance(new BigDecimal(2500))
                .overDraftLimit(new BigDecimal(3000))
                .build();

        checkingAccountController.balanceOverDraft(checkingAccount, new BigDecimal(2750));

        CheckingAccount checkingAccountTransferFrom = CheckingAccount.builder()
                .accountID(new Long(1003))
                .owner("John Michael")
                .balance(new BigDecimal(4200))
                .overDraftLimit(new BigDecimal(5000))
                .build();

        checkingAccountController.transferAccount(checkingAccountTransferFrom, checkingAccount, new BigDecimal(1000));

        SavingAccount savingAccount = SavingAccount.builder()
                .accountID(new Long(1004))
                .owner("George McRoad")
                .balance(new BigDecimal(5000))
                .build();

        savingAccountController.giveInterestPayment(savingAccount, 6);

    }


}
