package com.bankcorp.accounts.feign;

import com.bankcorp.accounts.domain.dto.CardDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "cards", url = "http://cards:9000", fallback = CardsFallback.class)
public interface CardsFeignClient {

    @GetMapping(value = "/api/fetch", consumes = "application/json")
    ResponseEntity<CardDTO> fetchCardDetails(@RequestHeader("bankcorp-correlation-id") String correlationId,
                                             @RequestParam String mobileNumber);

}
