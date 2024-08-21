package com.deavensoft.training.restapi.assignment1.service;

import com.deavensoft.training.restapi.assignment1.model.City;
import com.deavensoft.training.restapi.assignment1.model.Country;
import java.util.List;
import java.util.UUID;

public interface CountryService {

    List<Country> getAllCountries();

    Country getCountryById(UUID id);

    Country addCountry(Country country);

    Country updateCountry(UUID id, Country countryDetails);

    void deleteCountry(UUID id);

    City addCityToCountry(UUID countryId, City city);

    void removeCityFromCountry(UUID countryId, UUID cityId);
}
