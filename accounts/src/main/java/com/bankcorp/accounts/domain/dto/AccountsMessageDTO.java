package com.bankcorp.accounts.domain.dto;

public record AccountsMessageDTO(Long accountNumber, String name, String email,
                                 String mobileNumber) {
}
