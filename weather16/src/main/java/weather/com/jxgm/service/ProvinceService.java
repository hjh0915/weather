package com.jxgm.service;

import java.util.List;
import com.jxgm.dao.*;
import com.jxgm.entities.*;
import com.jxgm.DBConnection.DB;

import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class ProvinceService implements IProvinceService {
    SimpleDriverDataSource ds = DB.getDataSource();
    JdbcTemplate jtm = new JdbcTemplate(ds);
    NamedParameterJdbcTemplate njtm = new NamedParameterJdbcTemplate(ds);

    public List<Province> findAll() {

        ProvDao provDao = new PlainProvDao();
        CityDao cityDao = new PlainCityDao();

        provDao.setJdbcTemplate(jtm);
        provDao.setNamedParameterJdbcTemplate(njtm);

        cityDao.setJdbcTemplate(jtm);

        List<Province> provinces = provDao.findAll();
        
        for (Province p: provinces) {
            String id = p.getId();

            List<City> cities = cityDao.findByPid(id);

            p.setCities(cities); 
        }  

        return provinces;
    }

    public List<Province> findAllWithCities() {

        ProvDao provDao = new PlainProvDao();

        provDao.setJdbcTemplate(jtm);
        provDao.setNamedParameterJdbcTemplate(njtm);

        List<Province> prov = provDao.findAllWithCities();

        return prov;
    }    
}