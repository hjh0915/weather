package com.jxgm.dao;

import java.util.*;
import javax.sql.DataSource;

import com.jxgm.entities.City;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

//城市
public class PlainCityDao implements CityDao {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
    }

    public List<City> findByPid(String pid) {
        String sql = "select pid, code, name from pcity where pid = ?";
        return jdbcTemplate.query(sql, new Object[]{pid}, 
                BeanPropertyRowMapper.newInstance(City.class));
    }
}