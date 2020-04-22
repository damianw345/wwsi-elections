package com.github.damianw345.elections;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
public class ElectionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElectionsApplication.class, args);
	}
}
