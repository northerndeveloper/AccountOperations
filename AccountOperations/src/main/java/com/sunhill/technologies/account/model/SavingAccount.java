package com.sunhill.technologies.account.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class SavingAccount extends Account {

    @Builder
    public SavingAccount(Long accountID, String owner, BigDecimal balance) {
        super(accountID, owner, balance);
    }
}
