package com.jxgm.entities;

import java.util.*;

public class Province {
    String id;
    String name;
    List<City> cities;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id; 
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean addCity(City city) {
        if (cities == null) {
            cities = new ArrayList<>();
            cities.add(city);
            return true;
        } else {
            if (cities.contains(city)) {
                return false;
            }
        }
        cities.add(city);
        return true;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public List<City> getCities() {
        return cities;
    }

    @Override
    public String toString() {
        return "id:" + id + ", name:" + name;
    }
}