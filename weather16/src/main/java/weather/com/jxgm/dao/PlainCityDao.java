package com.jxgm.dao;

import java.util.*;

import com.jxgm.entities.City;
import com.jxgm.DBConnection.DB;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

//城市
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