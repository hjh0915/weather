package com.jxgm.dao;

import com.jxgm.entities.Province;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public interface ProvDao {
    void setJdbcTemplate(JdbcTemplate jdbcTemplate);
    void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate);

    Province findById(String id);   //通过id找到province
    List<Province> findAll();
    List<Province> findAllWithCities();
}