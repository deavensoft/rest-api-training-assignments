package com.deavensoft.training.restapi.assignment1.repository;

import com.deavensoft.training.restapi.assignment1.model.City;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, UUID> {}

