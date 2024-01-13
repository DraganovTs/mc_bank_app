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

    /**
     *
     * @param customerDTO - Customer DTO object
     * @return boolean indicating if the update of Account details is successful or not
     */
    boolean updateAccount(CustomerDTO customerDTO);

    /**
     *
     * @param mobileNumber - Input mobile number
     * @return boolean indicating if delete of Account details is successful or not
     */
    boolean deleteAccount(String mobileNumber);
}
