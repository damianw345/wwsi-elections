package com.github.damianw345.elections.service.impl;

import com.github.damianw345.elections.dto.UserDto;
import com.github.damianw345.elections.exception.AppRuntimeException;
import com.github.damianw345.elections.exception.code.AppExceptionCode;
import com.github.damianw345.elections.repository.ElectionsRepository;
import com.github.damianw345.elections.service.RegistrationService;
import com.github.damianw345.elections.util.ShaUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final ElectionsRepository electionsRepository;

    @Override
    public void register(UserDto userDto) {
        log.info("Trying to register user: {}", userDto.getLogin());
        String result = electionsRepository.register(userDto.getLogin(), ShaUtil.hash(userDto.getPassword()));
        if (!result.contains("utworzone")) {
            throw new AppRuntimeException(AppExceptionCode.E001);
        }
    }
}

// DBas return those strings from electionsRepository.register ...
// Konto testowy@testowy.pl zostało utworzone
// Konto: testowy@testowy.pl Istnieje. Jeśli nie pamietasz hasła kod do RESETU hasła może zostać wysłany na mail:testowy@testowy.pl
