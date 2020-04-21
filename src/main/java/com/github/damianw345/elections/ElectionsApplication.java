package com.github.damianw345.elections;

import com.github.damianw345.elections.repository.ElectionsRepository;
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
	}

}
