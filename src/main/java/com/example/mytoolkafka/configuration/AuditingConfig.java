package com.example.mytoolkafka.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@EnableJpaAuditing
public class AuditingConfig {

    /**
     * @author datpv
     * @date 2021-05-18 21:28:40
     * @return
     */
    @Bean
    public AuditorAware<String> createAuditorProvider() {
        return new SecurityAuditor();
    }

    /**
     * @author datpv
     * @date 2021-05-18 21:34:37
     * @return
     */
    @Bean
    public AuditingEntityListener createAuditingListener() {
        return new AuditingEntityListener();
    }

    /**
     * @author datpv
     * @date 2021-05-18 21:28:33
     * @param null
     * @return
     */
    public static class SecurityAuditor implements AuditorAware<String> {
        @Override
        public Optional<String> getCurrentAuditor() {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication == null || !authentication.isAuthenticated()) {
                return Optional.empty();
            }

            return Optional.ofNullable(String.valueOf(authentication.getPrincipal()));
        }
    }
}
