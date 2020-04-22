package com.github.damianw345.elections;

import com.github.damianw345.elections.repository.ElectionsRepository;
import com.github.damianw345.elections.util.ShaUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
public class ElectionsApplication implements CommandLineRunner {

	private final ElectionsRepository electionsRepository;

	public static void main(String[] args) {
		SpringApplication.run(ElectionsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("results: {}", electionsRepository.findCandidates(0, 0, 0));
		log.info("results: {}", electionsRepository.findCommittees(0, 0));
		log.info("results: {}", electionsRepository.findAuthenticationMethods());
		log.info("results: {}", electionsRepository.findElectionAreas(1));
		log.info("results: {}", electionsRepository.findElectionAreaServers(1));
		log.info("results: {}", electionsRepository.findElectionAreasWithDetails());
		log.info("results: {}", electionsRepository.findElectionTerms());
//		log.info("results: {}", electionsRepository.register("test1@wp.pl", "ee26b0dd4af7e749aa1a8ee3c10ae9923f618980772e473f8819a5d4940e0db27ac185f8a0e1d5f84f88bc887fd67b143732c304cc5fa9ad8e6f57f50028a8ff"));
//		log.info("results: {}", electionsRepository.login("test1@wp.pl", "ee26b0dd4af7e749aa1a8ee3c10ae9923f618980772e473f8819a5d4940e0db27ac185f8a0e1d5f84f88bc887fd67b143732c304cc5fa9ad8e6f57f50028a8ff"));
		log.info("results: {}", electionsRepository.login("test1@wp.pl", ShaUtil.hash("test")));
	}

}
