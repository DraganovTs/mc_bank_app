package com.bankcorp.accounts.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CustomerDTO {

    private String name;

    private String email;

    private String mobileNumber;

    private AccountDTO accountDTO;
}
