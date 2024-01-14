package com.bankcorp.accounts.domain.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(
        name = "Account",
        description = "Schema to hold Account information"
)
public class AccountDTO {
    @Schema(
            description = "Account number of bank account",example = "156478953"
    )
    @NotNull(message = "AccountNumber can not be null or empty!")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Account number must be 10 digits!")
    private Long accountNumber;
    @Schema(
            description = "Account type of bank account",example = "Savings"
    )
    @NotNull(message = "Account Type can not be null or empty!")
    private String accountType;
    @Schema(
            description = "Bank branch address",example = "123 New York"
    )
    @NotNull(message = "Branch Address can not be null or empty!")
    private String branchAddress;
}
