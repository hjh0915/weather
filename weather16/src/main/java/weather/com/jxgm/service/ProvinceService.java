package com.jxgm.service;

import java.util.List;
import com.jxgm.dao.*;
import com.jxgm.entities.*;
import com.jxgm.DBConnection.DB;

import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class ProvinceService implements IProvinceService {
    PlainProvDao provDao = new PlainProvDao();
    PlainCityDao cityDao = new PlainCityDao();

    public ProvinceService() {
        SimpleDriverDataSource ds = DB.getDataSource();
        JdbcTemplate jtm = new JdbcTemplate(ds);

        provDao.setJdbcTemplate(jtm);
        cityDao.setJdbcTemplate(jtm);
    }

    public List<Province> findAll() {
        List<Province> provinces = provDao.findAll();
        
        for (Province p: provinces) {
            String id = p.getId();
            List<City> cities = cityDao.findByPid(id);
            p.setCities(cities); 
        }  
        return provinces;
    }

    public List<Province> findAllWithCities() {
        List<Province> prov = provDao.findAllWithCities();
        return prov;
    }    
}