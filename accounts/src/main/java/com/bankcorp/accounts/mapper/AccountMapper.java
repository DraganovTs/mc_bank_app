package com.bankcorp.accounts.mapper;

import com.bankcorp.accounts.domain.dto.AccountDTO;
import com.bankcorp.accounts.domain.entity.Account;

public class AccountMapper {

    public static AccountDTO mapToAccountDTO( Account account) {
        return AccountDTO.builder()
                .accountNumber(account.getAccountNumber())
                .accountType(account.getAccountType())
                .branchAddress(account.getBranchAddress())
                .build();
    }

    public static Account mapToAccount(AccountDTO accountDTO) {
        return Account.builder()
                .accountNumber(accountDTO.getAccountNumber())
                .accountType(accountDTO.getAccountType())
                .branchAddress(accountDTO.getBranchAddress())
                .build();
    }
}
