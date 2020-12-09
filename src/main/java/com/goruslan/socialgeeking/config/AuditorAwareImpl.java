package com.goruslan.socialgeeking.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;


import java.util.Optional;


public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        if(SecurityContextHolder.getContext().getAuthentication() == null) {
            return Optional.empty();
        }
        return Optional.of(
                ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
    }
}
