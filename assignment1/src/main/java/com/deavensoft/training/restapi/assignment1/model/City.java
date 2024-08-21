package com.deavensoft.training.restapi.assignment1.model;
import jakarta.persistence.*;
import java.util.*;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String zip;

    @Column(unique = true)
    private String name;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        City city = (City) o;
        return Objects.equals(id, city.id) && Objects.equals(zip, city.zip)
                && Objects.equals(name, city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, zip, name);
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", zip='" + zip + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
