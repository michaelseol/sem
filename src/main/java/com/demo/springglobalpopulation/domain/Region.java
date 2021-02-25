package com.demo.springglobalpopulation.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Region {

    @Id
    private String id;
    private String country;
    private String region;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "Region [country=" + country + ", id=" + id + ", region=" + region + "]";
    }

}
