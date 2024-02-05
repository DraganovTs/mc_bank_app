package com.bankcorp.message.functions;

import com.bankcorp.message.dto.AccountsMessageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;


@Configuration
public class MessageFunctions {

    private static final Logger log = LoggerFactory.getLogger(MessageFunctions.class);

    @Bean
    public Function<AccountsMessageDTO,AccountsMessageDTO> email() {
        return accountsMessageDTO -> {
            log.info("Sending email with the details : " +  accountsMessageDTO.toString());
            return accountsMessageDTO;
        };
    }

    @Bean
    public Function<AccountsMessageDTO,Long> sms() {
        return accountsMessageDTO -> {
            log.info("Sending sms with the details : " +  accountsMessageDTO.toString());
            return accountsMessageDTO.accountNumber();
        };
    }
}
