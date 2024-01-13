package com.bankcorp.loans.service;

import com.bankcorp.loans.domain.dto.LoanDTO;

public interface LoanService {

    /**
     *
     * @param mobileNumber - Mobile number of the customer
     */
    void createLoan(String mobileNumber);

    /**
     *
     * @param mobileNumber - Mobile number of the customer
     * @return - Details of loan for a customer
     */
    LoanDTO fetchLoan(String mobileNumber);

    /**
     *
     * @param loanDTO - LoanDTO object
     * @return boolean indicating if the update of loan is successful or not
     */
    boolean updateLoan(LoanDTO loanDTO);

    /**
     *
     * @param mobileNumber - Input MobileNumber
     * @return boolean indicating if the delete of loan details is successful or not
     */
    boolean deleteLoan(String mobileNumber);
}
