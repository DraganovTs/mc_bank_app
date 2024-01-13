package com.bankcorp.accounts.domain.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("auditAwareImp")
public class AuditAwareImp implements AuditorAware<String> {

    /**
     * Returns the current auditor of the application
     * @return the current auditor
     */
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("ACCOUNT_MC");
    }
}
