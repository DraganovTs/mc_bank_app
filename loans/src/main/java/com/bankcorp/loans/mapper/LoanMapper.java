package com.bankcorp.loans.mapper;

import com.bankcorp.loans.domain.dto.LoanDTO;
import com.bankcorp.loans.domain.entity.Loan;

public class LoanMapper {

    public static LoanDTO mapToLoanDTO(Loan loan, LoanDTO loanDTO) {
        loanDTO.setLoanNumber(loan.getLoanNumber());
        loanDTO.setLoanType(loan.getLoanType());
        loanDTO.setTotalLoan(loan.getTotalLoan());
        loanDTO.setAmountPaid(loan.getAmountPaid());
        loanDTO.setMobileNumber(loan.getMobileNumber());
        loanDTO.setOutstandingAmount(loanDTO.getOutstandingAmount());
        return loanDTO;
    }

    public static Loan mapToLoan(LoanDTO loanDTO, Loan loan) {
        loan.setLoanNumber(loanDTO.getLoanNumber());
        loan.setLoanType(loanDTO.getLoanType());
        loan.setMobileNumber(loanDTO.getMobileNumber());
        loan.setTotalLoan(loanDTO.getTotalLoan());
        loan.setAmountPaid(loanDTO.getAmountPaid());
        loan.setOutstandingAmount(loanDTO.getOutstandingAmount());
        return loan;
    }
}
