package com.deavensoft.training.restapi.assignment1.service;


import com.deavensoft.training.restapi.assignment1.controller.ResourceNotFoundException;
import com.deavensoft.training.restapi.assignment1.model.City;
import com.deavensoft.training.restapi.assignment1.model.Country;
import com.deavensoft.training.restapi.assignment1.repository.CityRepository;
import com.deavensoft.training.restapi.assignment1.repository.CountryRepository;
import java.util.List;
import java.util.UUID;

public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;
    private final CityRepository cityRepository;

    public CountryServiceImpl(CountryRepository countryRepository, CityRepository cityRepository) {
        this.countryRepository = countryRepository;
        this.cityRepository = cityRepository;
    }
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public Country getCountryById(UUID id) {
        return countryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Country not found"));
    }

    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }

    public Country updateCountry(UUID id, Country countryDetails) {
        Country country = getCountryById(id);
        country.setName(countryDetails.getName());
        country.setCode(countryDetails.getCode());
        return countryRepository.save(country);
    }

    public void deleteCountry(UUID id) {
        countryRepository.deleteById(id);
    }

    public City addCityToCountry(UUID countryId, City city) {
        Country country = getCountryById(countryId);
        country.getCities().add(city);
        Country updatedCountry = countryRepository.save(country);
        return updatedCountry.getCities().stream().filter(c -> c.getName().equals(city.getName())).findFirst().orElseThrow(() -> new ResourceNotFoundException("City not found"));
    }

    public void removeCityFromCountry(UUID countryId, UUID cityId) {
        Country country = getCountryById(countryId);
        country.getCities().removeIf(city -> city.getId().equals(cityId));
        countryRepository.save(country);
        cityRepository.deleteById(cityId);
    }
}
