package com.lambda.countries;

import java.util.ArrayList;

public class CountryList {

    ArrayList<Country> countryList = new ArrayList<Country>();

    public CountryList() {
        countryList.add(new Country("China",1420062022,9388211,39));
        countryList.add(new Country("India",1368737513,2973190,28));
        countryList.add(new Country("U.S.",329093110,9147420,38));
        countryList.add(new Country("Nepal",29942018,143350,25));
    }

    // find first country that matches filter
    public Country findCountry(CheckCountry tester) {

        for(Country c: countryList) {
            if(tester.test(c)) {
                return c;
            }
        }
        return null;
    }

   public ArrayList<Country> findCountries(CheckCountry tester) {

       ArrayList<Country> tempCountry = new ArrayList<>();

       for(Country c: countryList) {
           if(tester.test(c)) {
               tempCountry.add(c);
           }
       }
       return tempCountry;
   }
}
