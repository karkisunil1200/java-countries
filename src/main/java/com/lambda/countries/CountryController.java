package com.lambda.countries;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/data")
public class CountryController {

    // localhost:2019/data/names/all
    @GetMapping(value = "/names/all",
            produces = {"application/json"})

    public ResponseEntity<?> getAllCountries() {

        ArrayList<Country> country = CountriesApplication.countryList.countryList;
        country.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));

        return new ResponseEntity<>(country, HttpStatus.OK);

    }

    //localhost:2019/data//names/start/{letter}
    @GetMapping(value = "/names/start/{letter}", produces = {"application/json"})

    public ResponseEntity<?> getCountryByName(@PathVariable char letter) {

        ArrayList<Country> country = CountriesApplication.countryList.
                findCountries(c -> c.getName().toUpperCase().charAt(0) == Character.toUpperCase(letter));

        country.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(country, HttpStatus.OK);
    }

    ////localhost:2019/data//names/size/{number}
    @GetMapping(value="/names/size/{number}", produces={"application/json"})

    public ResponseEntity<?> getCountryBySize(@PathVariable int number) {
        ArrayList<Country> country = CountriesApplication.countryList.
                findCountries(c -> c.getName().length() <= number);

        country.sort((c1,c2) -> c1.getName().compareToIgnoreCase(c2.getName()));

        return new ResponseEntity<>(country, HttpStatus.OK);
    }



}

//  @GetMapping(value = "/employees/sorted/{letter}",
//                produces = {"application/json"})
//    public ResponseEntity<?> getEmployeesByFirstNameSorted(@PathVariable char letter)
//    {
//        ArrayList<Employee> rtnEmps = WebemployeesApplication.ourEmpList.
//                findEmployees(e -> e.getFname().toUpperCase().charAt(0) == Character.toUpperCase(letter));
//        rtnEmps.sort((e1, e2) -> ((int) (e1.getSalary() - e2.getSalary())));
//        return new ResponseEntity<>(rtnEmps, HttpStatus.OK);
//    }