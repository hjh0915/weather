package com.jxgm.dao;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Collections;

import com.jxgm.entities.Province;
import com.jxgm.entities.City;
import com.jxgm.util.MyIntComparator;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import org.springframework.stereotype.Repository;

//省
@Repository
public class PlainProvDao implements ProvDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Province> findAllWithCities() {
        String sql = "select t1.id, t1.name, t2.pid, t2.code, t2.name as cname" +
                     " from province t1, city t2 where t1.id = t2.pid order by t1.id";

        return jdbcTemplate.query(sql, result -> {
            Map<Long, Province> map = new TreeMap<>();
            Province prov;

            while (result.next()) {

                Long id = result.getLong("id");
                prov = map.get(id);
                
                if (prov == null) {
                    prov = new Province();
                    prov.setId(id);
                    prov.setName(result.getString("name"));
                    map.put(id, prov);
                } 
                City city = new City();
                Long pid = result.getLong("pid");
                String code = result.getString("code");
                String name = result.getString("cname");

                city.setCode(code);
                city.setName(name);

                prov.addCity(city);
            }

            List<Province> provinces = new ArrayList<Province>(map.values());
            // Collections.sort(provinces, new MyIntComparator());
            return provinces;
        });
    }
}