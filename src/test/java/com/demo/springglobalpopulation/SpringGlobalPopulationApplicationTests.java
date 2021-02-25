package com.demo.springglobalpopulation;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.demo.springglobalpopulation.service.DBService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringGlobalPopulationApplicationTests {
	@Autowired
	private DBService dbService;

	@Test
	void contextLoads() {
	}

	@Test
	void getWorldPopulation() {
		assertTrue(dbService.getWorldPopulation() > 0);
	}

	@Test

	void mostPopulatedCountry() {

		assertTrue(dbService.getAllCountries().get(0).getName().equals("China"));
	}

	void getCountriesByContinent() {
		assertTrue(dbService.getAllByContinent("AF").size() > 0);
	}

}
