package com.demo.springglobalpopulation.repo;

import java.util.List;
import java.util.Optional;

import com.demo.springglobalpopulation.domain.Country;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepo extends JpaRepository<Country, String> {
    List<Country> findAllByContinent(String continent, Sort sort);

    List<Country> findAllByRegion(String region, Sort sort);

    Optional<Country> findByName(String name);
}
