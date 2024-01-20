package com.bankcorp.loans.domain.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@ConfigurationProperties(prefix = "accounts")
public class AccountContactInfoDTO {
    private String message;
    private Map<String,String> contactDetails;
    private List<String> onCallSupport;
}