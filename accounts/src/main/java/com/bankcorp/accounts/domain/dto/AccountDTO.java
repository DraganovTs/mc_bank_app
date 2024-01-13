package com.bankcorp.accounts.domain.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {

    @NotEmpty(message = "AccountNumber can not be null or empty!")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Account number must be 10 digits!")
    private Long accountNumber;

    @NotEmpty(message = "Account Type can not be null or empty!")
    private String accountType;

    @NotEmpty(message = "Branch Address can not be null or empty!")
    private String branchAddress;
}
