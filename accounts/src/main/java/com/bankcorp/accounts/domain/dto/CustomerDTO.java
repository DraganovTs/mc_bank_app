package com.bankcorp.accounts.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    private String name;

    private String email;

    private String mobileNumber;

    private AccountDTO accountDTO;
}
