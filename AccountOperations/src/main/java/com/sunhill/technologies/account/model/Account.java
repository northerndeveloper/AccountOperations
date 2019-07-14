package com.sunhill.technologies.account.model;

import lombok.*;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(of={"accountId"})
@ToString(of="accountId")
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    public Long accountId;

    public String owner;

    public BigDecimal balance;

}
