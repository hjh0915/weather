package com.jxgm.weather.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.io.Serializable;

@Entity
@Table(name="province")
public class Province implements Serializable {
    Long id;
    String name;
    Set<City> cities = new HashSet<>();

    @Id
    @Column(name="id", nullable=false)
    public Long getId() {
        return id;
    }

    @Column(name="name", nullable=false, length=100)
    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id; 
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean addCity(City city) {
        city.setProvince(this);
		getCities().add(city);

        return true;
    }

    public void removeCity(City city) {
		getCities().remove(city);
	}

    public void setCities(Set<City> cities) {
        this.cities = cities;
    }

    @OneToMany(mappedBy="province", cascade=CascadeType.ALL, orphanRemoval=true)
    @OrderBy("code ASC")
    public Set<City> getCities() {
        return cities;
    }

    @Override
    public String toString() {
        return "id:" + id + ", name:" + name;
    }
}