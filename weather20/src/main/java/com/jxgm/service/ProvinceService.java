package com.jxgm.service;

import java.util.List;

import com.jxgm.dao.*;
import com.jxgm.entities.*;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("namedService")
public class ProvinceService implements IProvinceService {
    // @Autowired 
    PlainProvDao provDao;
    // @Autowired 
    PlainCityDao cityDao;
    
    // @Autowired
    public ProvinceService(PlainProvDao provDao, PlainCityDao cityDao) {
        this.provDao = provDao;
        this.cityDao = cityDao;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
        provDao.setJdbcTemplate(jdbcTemplate);
        cityDao.setJdbcTemplate(jdbcTemplate);
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