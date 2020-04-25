package com.github.damianw345.elections.security;

import com.github.damianw345.elections.repository.ElectionsRepository;
import com.github.damianw345.elections.util.ShaUtil;
import com.github.damianw345.elections.util.TokenToUserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

import static com.github.damianw345.elections.util.Constants.SUCCESSFUL_LOGIN;

@Component
@Slf4j
@RequiredArgsConstructor
public class BackendAuthenticatorFilter extends OncePerRequestFilter {

    private final ElectionsRepository electionsRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        try {
            Optional.ofNullable(request.getHeader("Authorization"))
                    .map(TokenToUserDto::buildUserDto)
                    .ifPresent(userDto -> {
                        var login = userDto.getLogin();
                        var pwd = userDto.getHashedPassword();

                        if (electionsRepository.login(login, pwd).equalsIgnoreCase(SUCCESSFUL_LOGIN)) {
                            SecurityContextHolder
                                    .getContext()
                                    .setAuthentication(new UsernamePasswordAuthenticationToken(login, SUCCESSFUL_LOGIN));
                        }
                    });
        } catch (Exception e) {
            logger.warn("Authentication failed, cause:", e);
            response.addHeader("WWW-Authenticate", "Basic realm=" + "Elections");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        } finally {
            filterChain.doFilter(request, response);
        }
    }
}
