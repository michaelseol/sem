package com.demo.springglobalpopulation.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.demo.springglobalpopulation.domain.City;
import com.demo.springglobalpopulation.domain.Country;
import com.demo.springglobalpopulation.domain.People;
import com.demo.springglobalpopulation.repo.CityRepo;
import com.demo.springglobalpopulation.repo.CountryRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * DBService this class is use to generate the required metrics by the api
 */

@Service
public class DBService {

    @Autowired
    private CityRepo cityRepo;
    @Autowired
    private CountryRepo countryRepo;

    public Map<String, Long> getRegionPopulation() {
        Map<String, Long> pop = countryRepo.findAll().stream()
                .collect(Collectors.groupingBy(Country::getRegion, Collectors.summingLong(Country::getPopulation)));

        return pop;
    }

    public Map<String, Long> getContinentPopulation() {

        Map<String, Long> pop = countryRepo.findAll().stream()

                .collect(Collectors.groupingBy(Country::getContinent, Collectors.summingLong(Country::getPopulation)));

        return pop;
    }

    public long getWorldPopulation() {
        return countryRepo.findAll().stream().map(Country::getPopulation).reduce(0l, (a, b) -> a + b);
    }

    public List<City> getCapitalCityByRegion(String region) {
        return getCityByRegion(region).stream().filter(City::isCapital).collect(Collectors.toList());

    }

    public List<City> topCitiesByRegion(String region, int limit) {
        return getCityByRegion(region).stream().limit(limit).collect(Collectors.toList());
    }

    public List<City> getCityByRegion(String region) {
        return cityRepo.findAllByRegion(region, Sort.by("population").descending());

    }

    public List<Country> topCountryByRegion(String region, int limit) {
        return getCountrieByRegion(region).stream().limit(limit).collect(Collectors.toList());
    }

    public List<Country> getCountrieByRegion(String region) {
        return countryRepo.findAllByRegion(region, Sort.by("population").descending());

    }

    public List<Country> getAllCountries() {
        return countryRepo.findAll(Sort.by("population").descending());

    }

    public List<Country> getAllByContinent(String continent) {
        return countryRepo.findAllByContinent(continent, Sort.by("population").descending());

    }

    public List<Country> getWorldTopCountries(int limit) {
        return countryRepo.findAll(Sort.by("population").descending()).stream().limit(limit)
                .collect(Collectors.toList());

    }

    public List<Country> getContinentTopCountries(String continent, int limit) {
        return countryRepo.findAllByContinent(continent, Sort.by("population").descending()).stream().limit(limit)
                .collect(Collectors.toList());

    }

    public List<City> getAllCities() {
        return cityRepo.findAll(Sort.by("population").descending());
    }

    public List<City> getAllCitiesByContinent(String continent) {
        List<City> cities = new ArrayList<>();
        countryRepo.findAllByContinent(continent, Sort.unsorted())
                .forEach(c -> cities.addAll(cityRepo.findAllByCountry(c.getName())));
        cities.sort(Comparator.comparingLong(City::getPopulation).reversed());

        return cities;

    }

    public List<City> findAllCitiesByCountry(String country) {
        List<City> cities = cityRepo.findAllByCountry(country);
        cities.sort(Comparator.comparingLong(City::getPopulation));
        return cities;
    }

    public List<City> topCities(int limit) {
        return cityRepo.findAll(Sort.by("population").descending()).stream().limit(limit).collect(Collectors.toList());
    }

    public List<City> topCitesByContinent(String continent, int limit) {
        return getAllCitiesByContinent(continent).stream().limit(limit).collect(Collectors.toList());

    }

    public List<City> topCitiesByCountry(String country, int limit) {
        return findAllCitiesByCountry(country).stream().limit(limit).collect(Collectors.toList());

    }

    public List<City> getAllCapitalCities() {
        return getAllCities().stream().filter(City::isCapital).collect(Collectors.toList());

    }

    public List<City> getAllCapitalCitiesByContinent(String continent) {
        return getAllCitiesByContinent(continent).stream().filter(City::isCapital).collect(Collectors.toList());

    }

    public List<City> topCapitalCities(int limit) {
        return getAllCapitalCities().stream().limit(limit).collect(Collectors.toList());
    }

    public List<City> topCapitalCitiesByContinent(String continent, int limit) {
        return getAllCapitalCitiesByContinent(continent).stream().limit(limit).collect(Collectors.toList());
    }

    public List<People> getPeopleByContinent() {
        List<People> peoples = new ArrayList<>();

        return peoples;

    }

}