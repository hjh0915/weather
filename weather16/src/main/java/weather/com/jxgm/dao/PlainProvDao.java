package com.jxgm.dao;

import java.util.*;

import com.jxgm.entities.Province;
import com.jxgm.entities.City;

import com.jxgm.DBConnection.DB;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

//省
public class PlainProvDao implements ProvDao {
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public Province findById(String id) {    
        String sql = "select * from province where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id},
                    BeanPropertyRowMapper.newInstance(Province.class));
    }

    public List<Province> findAll() {
        String sql = "select * from province";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Province.class));
    }

    public List<Province> findAllWithCities() {
        String sql = "select t1.id, t1.name, t2.pid, t2.code, t2.name as cname" +
                     " from province t1, pcity t2 where t1.id = t2.pid;";

        return namedParameterJdbcTemplate.query(sql, result -> {
            Map<String, Province> map = new HashMap<>();
            Province prov;

            while (result.next()) {

                String id = result.getString("id");
                prov = map.get(id);
                
                if (prov == null) {
                    prov = new Province();
                    prov.setId(id);
                    prov.setName(result.getString("name"));
                    map.put(id, prov);
                } 
                City city = new City();
                String pid = result.getString("pid");
                String code = result.getString("code");
                String name = result.getString("cname");

                city.setPid(pid);
                city.setCode(code);
                city.setName(name);

                prov.addCity(city);
            }

            return new ArrayList<Province>(map.values());
        });
    }
}