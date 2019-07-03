package com.jxgm.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="province")
@NamedQueries({
    @NamedQuery(name=Singer.FIND_ALL, 
        query="select s from Province s"),
    @NamedQuery(name=Singer.FIND_PROVINCE_BY_ID,
        query="select distinct s from Province s " +
                "left join fetch s.cities a " +
                "where s.id = :id"),
    @NamedQuery(name=Singer.FIND_ALL_WITH_CITY,
        query="select distinct s from Province s " +
                "left join fetch s.cities a ")
})
@SqlResultSetMapping(
    name="provinceResult",
    entities=@EntityResult(entityClass=Province.class)
)
public class Province {
    
    int id;
    String name;
    Set<City> cities = new HashSet<>();

    @Id
    @Column(name="id", nullable=false)
    public int getId() {
        return id;
    }

    @Column(name="name", nullable=false, length=100)
    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id; 
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean addCity(City city) {
        city.setProvince(this);
		return getCities().add(city);

        return true;
    }

    public void removeCity(City city) {
		getCities().remove(city);
	}

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    @OneToMany(mappedBy="province", cascade=CascadeType.ALL, orphanRemoval=true)
    public List<City> getCities() {
        return cities;
    }

    @Override
    public String toString() {
        return "id:" + id + ", name:" + name;
    }
}