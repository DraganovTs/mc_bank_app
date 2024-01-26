package com.bankcorp.accounts.service.impl;

import com.bankcorp.accounts.domain.dto.AccountDTO;
import com.bankcorp.accounts.domain.dto.CardDTO;
import com.bankcorp.accounts.domain.dto.CustomerDetailsDTO;
import com.bankcorp.accounts.domain.dto.LoanDTO;
import com.bankcorp.accounts.domain.entity.Account;
import com.bankcorp.accounts.domain.entity.Customer;
import com.bankcorp.accounts.exception.ResourceNotFoundException;
import com.bankcorp.accounts.feign.CardsFeignClient;
import com.bankcorp.accounts.feign.LoansFeignClient;
import com.bankcorp.accounts.mapper.AccountMapper;
import com.bankcorp.accounts.mapper.CustomerMapper;
import com.bankcorp.accounts.repository.AccountRepository;
import com.bankcorp.accounts.repository.CustomerRepository;
import com.bankcorp.accounts.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;
    private final CardsFeignClient cardsFeignClient;
    private final LoansFeignClient loansFeignClient;

    /**
     * @param mobileNumber - input mobile number
     * @return Customer details based on a given mobileNumber
     */
    @Override
    public CustomerDetailsDTO fetchCustomerDetails(String mobileNumber,String correlationId) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        Account accounts = accountRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString())
        );

        CustomerDetailsDTO customerDetailsDTO = CustomerMapper.mapToCustomerDetailsDTO(customer,
                new CustomerDetailsDTO());
        customerDetailsDTO.setAccountDTO(AccountMapper.mapToAccountDTO(accounts, new AccountDTO()));

        ResponseEntity<LoanDTO> loanDTOResponseEntity = loansFeignClient.fetchLoanDetails(correlationId,mobileNumber);
        customerDetailsDTO.setLoanDTO(loanDTOResponseEntity.getBody());

        ResponseEntity<CardDTO> cardDTOResponseEntity = cardsFeignClient.fetchCardDetails(correlationId,mobileNumber);
        customerDetailsDTO.setCardDTO(cardDTOResponseEntity.getBody());


        return customerDetailsDTO;
    }
}
