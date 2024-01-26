package com.bankcorp.accounts.service;

import com.bankcorp.accounts.domain.dto.CustomerDetailsDTO;

public interface CustomerService {
    /**
     *
     * @param mobileNumber - input mobile number
     * @return Customer details based on a given mobileNumber
     */
    CustomerDetailsDTO fetchCustomerDetails(String mobileNumber,String correlationId);
}
