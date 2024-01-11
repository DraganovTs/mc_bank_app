package com.bankcorp.accounts.mapper;

import com.bankcorp.accounts.domain.dto.CustomerDTO;
import com.bankcorp.accounts.domain.entity.Customer;

public class CustomerMapper {

    public static CustomerDTO mapToCustomerDTO(Customer customer) {
        return CustomerDTO.builder()
                .name(customer.getName())
                .email(customer.getEmail())
                .mobileNumber(customer.getMobileNumber())
                .build();
    }

    public static Customer mapToCustomer(CustomerDTO customerDTO) {
        return Customer.builder()
                .name(customerDTO.getName())
                .email(customerDTO.getEmail())
                .mobileNumber(customerDTO.getMobileNumber())
                .build();
    }
}
