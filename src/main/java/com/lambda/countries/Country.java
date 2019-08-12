package com.lambda.countries;

import java.util.concurrent.atomic.AtomicLong;

public class Country {

    private static final AtomicLong counter = new AtomicLong();
    private long id;
    private String name;
    private long population;
    private long landMass;
    private int medianAge;

    public Country(long id, String name, long population, long landMass, int medianAge) {
        this.id = counter.incrementAndGet();
        this.name = name;
        this.population = population;
        this.landMass = landMass;
        this.medianAge = medianAge;
    }

    public Country() {

    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPopulation() {
        return this.population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public long getLandMass() {
        return this.landMass;
    }

    public void setLandMass(long landMass) {
        this.landMass = landMass;
    }

    public int getMedianAge() {
        return this.medianAge;
    }

    public void setMedianAge(int medianAge) {
        this.medianAge = medianAge;
    }

}

//a country name, population, land mass size, and median age
