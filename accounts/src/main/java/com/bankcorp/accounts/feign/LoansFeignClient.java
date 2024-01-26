package com.bankcorp.accounts.feign;

import com.bankcorp.accounts.domain.dto.LoanDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("loans")
public interface LoansFeignClient {

    @GetMapping(value = "/api/fetch",consumes = "application/json")
    public ResponseEntity<LoanDTO> fetchLoanDetails(@RequestHeader("bankcorp-correlation-id") String correlationId,
                                                    @RequestParam String mobileNumber);

}
