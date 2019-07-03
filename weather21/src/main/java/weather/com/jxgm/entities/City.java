package com.jxgm.entities;

import javax.persistence.*;

@Entity
@Table(name="city")
public class City {
    
    String code;
    int pid;
    String name;

    Province province;

    @Id
    @Column(name="code", nullable=false)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name="pid", nullable=false)
    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Column(name="name", nullable=false, length=100)
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