package com.jxgm.entities;

public class City {
    String pid;
    String code;
    String name;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
    
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

    @Override
    public String toString() {
        return "pid:" + pid + ", code:" + code + ", name:" + name;
    }
}