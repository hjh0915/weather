package com.jxgm.dao;

import com.jxgm.entities.City;

import java.util.*;
import org.springframework.jdbc.core.JdbcTemplate;

public interface CityDao {
    void setJdbcTemplate(JdbcTemplate jdbcTemplate);
    List<City> findByPid(String pid);   //通过pid找到city
}