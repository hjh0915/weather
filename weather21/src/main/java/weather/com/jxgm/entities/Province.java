package com.jxgm.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.io.Serializable;

@Entity
@Table(name="province")
@NamedQueries({
    @NamedQuery(name=Province.FIND_ALL, 
        query="select s from Province s"),
    @NamedQuery(name=Province.FIND_PROVINCE_BY_ID,
        query="select distinct s from Province s " +
                "left join fetch s.cities a " +
                "where s.id = :id"),
    @NamedQuery(name=Province.FIND_ALL_WITH_CITY,
        query="select distinct s from Province s " +
                "left join fetch s.cities a ")
})
@SqlResultSetMapping(
    name="provinceResult",
    entities=@EntityResult(entityClass=Province.class)
)
public class Province implements Serializable {
    
    public static final String FIND_ALL = "Province.findAll";
    public static final String FIND_PROVINCE_BY_ID = "Province.findById";
    public static final String FIND_ALL_WITH_CITY = "Province.findAllWithCity";

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
    public Set<City> getCities() {
        return cities;
    }

    @Override
    public String toString() {
        return "id:" + id + ", name:" + name;
    }
}