package com.bankcorp.accounts.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {

    private Long accountNumber;

    private String accountType;

    private String branchAddress;
}
