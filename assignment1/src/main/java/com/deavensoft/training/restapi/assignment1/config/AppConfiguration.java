package com.deavensoft.training.restapi.assignment1.config;

import com.deavensoft.training.restapi.assignment1.repository.CityRepository;
import com.deavensoft.training.restapi.assignment1.repository.CountryRepository;
import com.deavensoft.training.restapi.assignment1.service.CountryService;
import com.deavensoft.training.restapi.assignment1.service.CountryServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class AppConfiguration {

    @Bean
    CountryService countryService(CountryRepository countryRepository, CityRepository cityRepository) {
        return new CountryServiceImpl(countryRepository, cityRepository);
    }
}
