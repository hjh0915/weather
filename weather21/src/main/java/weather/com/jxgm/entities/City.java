package com.jxgm.entities;

import javax.persistence.*;

@Entity
@Table(name="city")
public class City {
    
    @Id
    @Column(name="code", nullable=false)
    String code;

    @Column(name="name", nullable=false, length=100)
    String name;

    @ManyToOne
    @JoinColumn(name="PID")
    Province province;

    
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
        return "pid:" + pid + ", code:" + code + ", name:" + name;
    }
}