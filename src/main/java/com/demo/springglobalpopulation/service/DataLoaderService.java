package com.demo.springglobalpopulation.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import com.demo.springglobalpopulation.domain.City;
import com.demo.springglobalpopulation.domain.Country;
import com.demo.springglobalpopulation.domain.Region;
import com.demo.springglobalpopulation.repo.CityRepo;
import com.demo.springglobalpopulation.repo.CountryRepo;
import com.demo.springglobalpopulation.repo.RegionRepo;
import com.demo.springglobalpopulation.util.UtilityFunctions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * DataLoaderService this class load the data for cities ,country and regions
 * from the file system to H2 embeded database
 */
@Service
public class DataLoaderService {
    @Autowired
    private CityRepo cityRepo;
    @Autowired
    private CountryRepo countryRepo;

    @Autowired
    private RegionRepo regionRepo;

    public void loadRegionData() {

        if (regionRepo.count() == 0) {

            List<String> lines;
            try {
                lines = Files.readAllLines(Paths.get("data/countries of the world.csv"));

                for (String string : lines) {
                    String[] data = string.split(",");
                    Region region = new Region();
                    region.setId(UtilityFunctions.getRandomString());
                    region.setCountry(data[0].replaceAll("\"", "").trim());
                    region.setRegion(data[1].replaceAll("\"", "").trim());
                    regionRepo.save(region);

                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }

    public void loadCityData() {

        if (cityRepo.count() == 0) {

            List<String> lines;
            try {
                lines = Files.readAllLines(Paths.get("data/worldcities.csv"));

                for (String string : lines) {
                    String[] data = string.split(",");

                    City city = new City();
                    city.setId(UtilityFunctions.getRandomString());
                    city.setCountry(data[4]);
                    city.setName(data[1]);
                    if (data[data.length - 3].equals("primary"))
                        city.setCapital(true);
                    if (!data[data.length - 2].equals(""))
                        city.setPopulation(Long.valueOf(data[data.length - 2]));
                    Optional<Region> region = regionRepo.findByCountry(city.getCountry());

                    if (region.isPresent())
                        city.setRegion(region.get().getRegion());
                    else
                        city.setRegion(city.getCountry());

                    Optional<Country> country = countryRepo.findByName(city.getCountry());
                    if (country.isPresent())
                        city.setContinent(country.get().getContinent());

                    cityRepo.save(city);

                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }

    public void loadCountryData() {

        if (countryRepo.count() == 0) {

            List<String> lines;
            try {
                lines = Files.readAllLines(Paths.get("data/CountryInformation.csv"));

                for (String string : lines) {
                    String[] data = string.split(",");
                    Country country = new Country();
                    country.setId(UtilityFunctions.getRandomString());
                    country.setName(data[4]);
                    country.setCode(data[0]);
                    country.setCapital(data[5]);
                    country.setContinent(data[8]);
                    country.setRegion(data[8]);
                    country.setPopulation(Long.valueOf(data[7]));

                    Optional<Region> region = regionRepo.findByCountry(country.getName());

                    if (region.isPresent())
                        country.setRegion(region.get().getRegion());

                    countryRepo.save(country);

                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }

}