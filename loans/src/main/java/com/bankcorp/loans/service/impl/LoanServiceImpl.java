package com.bankcorp.loans.service.impl;


import com.bankcorp.loans.constants.LoanConstants;
import com.bankcorp.loans.domain.dto.LoanDTO;
import com.bankcorp.loans.domain.entity.Loan;
import com.bankcorp.loans.exception.LoanAlreadyExistException;
import com.bankcorp.loans.exception.ResourceNotFoundException;
import com.bankcorp.loans.mapper.LoanMapper;
import com.bankcorp.loans.repository.LoanRepository;
import com.bankcorp.loans.service.LoanService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;


    /**
     * @param mobileNumber - Mobile number of the customer
     */
    @Override
    public void createLoan(String mobileNumber) {
        Optional<Loan> optionalLoan = loanRepository.findByMobileNumber(mobileNumber);
        if (optionalLoan.isPresent()) {
            throw new LoanAlreadyExistException("Loan already registered with given mobileNumber " + mobileNumber);
        }
        loanRepository.save(createNewLoan(mobileNumber));
    }

    /**
     * @param mobileNumber - Mobile Number of the Customer
     * @return the new loan details
     */
    private Loan createNewLoan(String mobileNumber) {
        Loan newLoan = new Loan();
        long randomLoanNumber = 100000000000L + new Random().nextInt(900000000);

        newLoan.setLoanNumber(Long.toString(randomLoanNumber));
        newLoan.setMobileNumber(mobileNumber);
        newLoan.setLoanType(LoanConstants.HOME_LOAN);
        newLoan.setTotalLoan(LoanConstants.NEW_LOAN_LIMIT);
        newLoan.setAmountPaid(0);
        newLoan.setOutstandingAmount(LoanConstants.NEW_LOAN_LIMIT);
        return newLoan;
    }

    /**
     * @param mobileNumber - Mobile number of the customer
     * @return - Details of loan for a customer
     */
    @Override
    public LoanDTO fetchLoan(String mobileNumber) {
        Loan loan = loanRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber)
        );
        return LoanMapper.mapToLoanDTO(loan, new LoanDTO());
    }

    /**
     * @param loanDTO - LoanDTO object
     * @return boolean indicating if the update of loan is successful or not
     */
    @Override
    public boolean updateLoan(LoanDTO loanDTO) {
        Loan loan = loanRepository.findByLoanNumber(loanDTO.getLoanNumber()).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "LoanNumber", loanDTO.getLoanNumber())
        );
        LoanMapper.mapToLoan(loanDTO, loan);
        loanRepository.save(loan);
        return true;
    }

    /**
     * @param mobileNumber - Input MobileNumber
     * @return boolean indicating if delete of loan details is successful or not
     */
    @Override
    public boolean deleteLoan(String mobileNumber) {
        Loan loan = loanRepository.findByLoanNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "MobileNumber", mobileNumber)
        );
        loanRepository.deleteById(loan.getLoanId());
        return true;
    }
}
