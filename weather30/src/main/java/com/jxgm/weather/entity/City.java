package com.jxgm.weather.entity;

import javax.persistence.*;
import java.io.Serializable;

@NamedEntityGraph
@Entity
@Table(name="city")
public class City implements Serializable {
    
    @Id
    @Column(name="code", nullable=false)
    String code;

    @Column(name="name", nullable=false, length=100)
    String name;

    @ManyToOne
    @JoinColumn(name="pid")
    Province province;

    public City() {}
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProvince(Province province) {
		this.province = province;
	}

    @Override
    public String toString() {
        return "code:" + code + ", name:" + name;
    }
}