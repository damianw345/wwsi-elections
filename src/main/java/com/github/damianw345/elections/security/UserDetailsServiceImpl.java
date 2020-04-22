package com.github.damianw345.elections.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;

import static com.github.damianw345.elections.util.Constants.SUCCESSFUL_LOGIN;

@Component
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) {
        try {
            return new org.springframework.security.core.userdetails.User(
                    username,
                    SUCCESSFUL_LOGIN,
                    Collections.emptyList()
            );
        } catch (Exception ex) {
            throw new UsernameNotFoundException("User not found", ex);
        }
    }

}
