package com.jxgm.dao;

import java.util.*;

import com.jxgm.entities.City;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import org.springframework.stereotype.Repository;

//城市
@Repository
public class PlainCityDao implements CityDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<City> findByPid(String pid) {
        String sql = "select pid, code, name from pcity where pid = ?";
        return jdbcTemplate.query(sql, new Object[]{pid}, 
                BeanPropertyRowMapper.newInstance(City.class));
    }
}