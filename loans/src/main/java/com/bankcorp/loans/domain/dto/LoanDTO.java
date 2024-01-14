package com.bankcorp.loans.domain.dto;

import lombok.Data;

@Data
public class LoanDTO {
    private String mobileNumber;
    private String loanNumber;
    private String loanType;
    private int totalLoan;
    private int amountPaid;
    private int outstandingAmount;
}