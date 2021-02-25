package com.demo.springglobalpopulation.controler;

import java.util.List;
import java.util.Map;

import com.demo.springglobalpopulation.domain.City;
import com.demo.springglobalpopulation.domain.Country;
import com.demo.springglobalpopulation.service.DBService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/population/")
@CrossOrigin("*")
public class PopulationControler {

    @Autowired
    private DBService dbService;

    @GetMapping("world")

    public long getWorldPopulation() {
        return dbService.getWorldPopulation();
    }

    @GetMapping("capital/region")

    public List<City> getCapitalCityByRegion(@RequestParam String region) {
        return dbService.getCapitalCityByRegion(region);

    }

    @GetMapping("capital/region/top")
    public List<City> topCitiesByRegion(@RequestParam String region, @RequestParam int top) {
        return dbService.topCitiesByRegion(region, top);
    }

    @GetMapping("city/region")
    public List<City> getCityByRegion(@RequestParam String region) {
        return dbService.getCityByRegion(region);
    }

    @GetMapping("country/region/top")

    public List<Country> topCountryByRegion(@RequestParam String region, @RequestParam int top) {
        return dbService.topCountryByRegion(region, top);
    }

    @GetMapping("country/region")

    public List<Country> getCountrieByRegion(@RequestParam String region) {
        return dbService.getCountrieByRegion(region);
    }

    @GetMapping("continents")
    public Map<String, Long> getContinentsPopulation() {
        return dbService.getContinentPopulation();
    }

    @GetMapping("regions")
    public Map<String, Long> getRegionsPopulation() {
        return dbService.getRegionPopulation();
    }

    @GetMapping("country/all")

    public List<Country> getAllCountries() {
        return dbService.getAllCountries();

    }

    @GetMapping("country/continent")
    public List<Country> getAllCoutriesByContinent(@RequestParam String continent) {
        return dbService.getAllByContinent(continent);
    }

    @GetMapping("country/top")
    public List<Country> getTopCountries(@RequestParam int top) {
        return dbService.getWorldTopCountries(top);
    }

    @GetMapping("country/continent/top")
    public List<Country> getTopCountriesByContinent(@RequestParam int top, @RequestParam String continent) {
        return dbService.getContinentTopCountries(continent, top);
    }

    @GetMapping("city/all")
    public List<City> getAllcities() {
        return dbService.getAllCities();

    }

    @GetMapping("city/continent")
    public List<City> getCitiesByContinent(@RequestParam String continent) {
        return dbService.getAllCitiesByContinent(continent);
    }

    @GetMapping("city/country")
    public List<City> getallCitiesByCountry(@RequestParam String country) {
        return dbService.findAllCitiesByCountry(country);
    }

    @GetMapping("city/top/world")
    public List<City> getTopWorldCities(@RequestParam int top) {
        return dbService.topCities(top);
    }

    @GetMapping("city/top/continent/top")

    public List<City> gettopCitiesByContinent(@RequestParam String continent, @RequestParam int top) {
        return dbService.topCapitalCitiesByContinent(continent, top);
    }

    @GetMapping("city/top/country/top")
    public List<City> getTopCitiesByCountry(@RequestParam String country, @RequestParam int top) {
        return dbService.topCitiesByCountry(country, top);
    }

    @GetMapping("capital/all")

    public List<City> getAllCapitalCities() {
        return dbService.getAllCapitalCities();
    }

    @GetMapping("capital/continent")
    public List<City> getAllCapitalCitiesByContinent(@RequestParam String continent) {
        return dbService.getAllCapitalCitiesByContinent(continent);

    }

    @GetMapping("capital/top")
    public List<City> topCapitalCities(@RequestParam int top) {
        return dbService.topCapitalCities(top);
    }

    @GetMapping("capital/top/continent")
    public List<City> topCapitalCityByContinent(@RequestParam String continent, @RequestParam int top) {
        return dbService.topCapitalCitiesByContinent(continent, top);
    }

}
