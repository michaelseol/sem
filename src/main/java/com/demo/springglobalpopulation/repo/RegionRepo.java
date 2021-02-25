package com.demo.springglobalpopulation.repo;

import java.util.Optional;

import com.demo.springglobalpopulation.domain.Region;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepo extends JpaRepository<Region, String> {
    Optional<Region> findByCountry(String country);

}
