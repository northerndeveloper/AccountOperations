package com.sunhill.technologies.account.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckingAccount extends Account {

    public BigDecimal overDraftLimit;

    @Builder
    public CheckingAccount(Long accountID, String owner, BigDecimal balance, BigDecimal overDraftLimit) {
        super(accountID, owner, balance);
        this.overDraftLimit = overDraftLimit;
    }

}


