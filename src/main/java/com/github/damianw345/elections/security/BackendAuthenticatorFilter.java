package com.github.damianw345.elections.security;

import com.github.damianw345.elections.dto.UserDto;
import com.github.damianw345.elections.repository.ElectionsRepository;
import com.github.damianw345.elections.util.ShaUtil;
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
import java.util.Base64;
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
                    .map(base64token -> new String(Base64.getDecoder().decode(base64token)))
                    .map(token -> token.split(":"))
                    .map(credentials -> new UserDto(credentials[0], credentials[1]))
                    .ifPresent(userDto -> {
                        var login = userDto.getLogin();
                        var pwd = userDto.getPassword();

                        if (electionsRepository.login(login, ShaUtil.hash(pwd)).equalsIgnoreCase(SUCCESSFUL_LOGIN)) {
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
