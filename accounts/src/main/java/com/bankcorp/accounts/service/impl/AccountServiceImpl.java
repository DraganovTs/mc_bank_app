package com.bankcorp.accounts.service.impl;

import com.bankcorp.accounts.constants.AccountConstants;
import com.bankcorp.accounts.domain.dto.CustomerDTO;
import com.bankcorp.accounts.domain.entity.Account;
import com.bankcorp.accounts.domain.entity.Customer;
import com.bankcorp.accounts.exception.CustomerAlreadyExistException;
import com.bankcorp.accounts.exception.ResourceNotFoundException;
import com.bankcorp.accounts.mapper.AccountMapper;
import com.bankcorp.accounts.mapper.CustomerMapper;
import com.bankcorp.accounts.repository.AccountRepository;
import com.bankcorp.accounts.repository.CustomerRepository;
import com.bankcorp.accounts.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    /**
     * @param customerDTO - Customer DTO Object
     */
    @Override
    public void createAccount(CustomerDTO customerDTO) {
        Customer customer = CustomerMapper.mapToCustomer(customerDTO);
        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customerDTO.getMobileNumber());
        if (optionalCustomer.isPresent()) {
            throw new CustomerAlreadyExistException("Customer already registered whit that mobile number");
        }
        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy("Anonymous");
        Customer saveCustomer = customerRepository.save(customer);
        accountRepository.save(createNewAccount(saveCustomer));
    }

    private Account createNewAccount(Customer customer) {
        long randomAccountNumber = 1000000000L + new Random().nextInt(900000000);

        Account createdAccount = Account.builder()
                .customerId(customer.getCustomerId())
                .accountNumber(randomAccountNumber)
                .accountType(AccountConstants.SAVINGS)
                .branchAddress(AccountConstants.ADDRESS)
                .build();
        createdAccount.setCreatedAt(LocalDateTime.now());
        createdAccount.setCreatedBy("Anonymous");
        return createdAccount;
    }

    /**
     *
     * @param mobileNumber - Input mobile number
     * @return Account details based on given mobileNumber
     */
    @Override
    public CustomerDTO fetchAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        Account account = accountRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString())
        );
        CustomerDTO customerDTO = CustomerMapper.mapToCustomerDTO(customer);
        customerDTO.setAccountDTO(AccountMapper.mapToAccountDTO(account));
        return customerDTO;
    }

    /**
     * @param customerDTO - Customer DTO object
     * @return boolean indicating if the update od Account details is successful or not
     */
    @Override
    public boolean updateAccount(CustomerDTO customerDTO) {
        return false;
    }
}
