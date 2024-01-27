package com.bankcorp.accounts.feign;

import com.bankcorp.accounts.domain.dto.CardDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CardsFallback implements CardsFeignClient{
    @Override
    public ResponseEntity<CardDTO> fetchCardDetails(String correlationId, String mobileNumber) {
        return null;
    }
}
