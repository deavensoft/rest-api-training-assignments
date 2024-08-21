package com.deavensoft.training.restapi.assignment1.repository;
import com.deavensoft.training.restapi.assignment1.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface CountryRepository extends JpaRepository<Country, UUID> {}

