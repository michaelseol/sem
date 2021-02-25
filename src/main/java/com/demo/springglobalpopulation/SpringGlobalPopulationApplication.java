package com.demo.springglobalpopulation;

import com.demo.springglobalpopulation.repo.CityRepo;
import com.demo.springglobalpopulation.repo.CountryRepo;
import com.demo.springglobalpopulation.repo.RegionRepo;
import com.demo.springglobalpopulation.service.DataLoaderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringGlobalPopulationApplication implements ApplicationRunner {
	@Autowired
	private DataLoaderService dataLoaderService;

	@Autowired
	private CityRepo cityRepo;
	@Autowired
	private CountryRepo countryRepo;

	public static void main(String[] args) {
		SpringApplication.run(SpringGlobalPopulationApplication.class, args);

	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		dataLoaderService.loadRegionData();
		dataLoaderService.loadCountryData();
		dataLoaderService.loadCityData();

		System.out.println(cityRepo.count());

		System.out.println(countryRepo.count());

	}

}
