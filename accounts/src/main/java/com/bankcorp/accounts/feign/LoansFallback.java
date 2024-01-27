package com.bankcorp.accounts.feign;

import com.bankcorp.accounts.domain.dto.LoanDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class LoansFallback implements LoansFeignClient{
    @Override
    public ResponseEntity<LoanDTO> fetchLoanDetails(String correlationId, String mobileNumber) {
        return null;
    }
}
