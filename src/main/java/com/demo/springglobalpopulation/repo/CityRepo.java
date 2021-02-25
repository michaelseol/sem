package com.demo.springglobalpopulation.repo;

import java.util.List;

import com.demo.springglobalpopulation.domain.City;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepo extends JpaRepository<City, String> {
    List<City> findAllByCountry(String country);

    List<City> findAllByRegion(String region, Sort sort);

}
