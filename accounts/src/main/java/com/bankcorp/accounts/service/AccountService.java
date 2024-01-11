package com.bankcorp.accounts.service;

import com.bankcorp.accounts.domain.dto.CustomerDTO;

public interface AccountService {
    /**
     *
     * @param customerDTO - Customer DTO Object
     */
    void createAccount(CustomerDTO customerDTO);

    /**
     *
     * @param mobileNumber - Input mobile number
     * @return Account details based on given mobileNumber
     */
    CustomerDTO fetchAccount(String mobileNumber);
}
