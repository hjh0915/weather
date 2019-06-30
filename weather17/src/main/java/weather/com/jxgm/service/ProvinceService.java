package com.jxgm.service;

import java.util.List;
import javax.sql.DataSource;

import com.jxgm.dao.*;
import com.jxgm.entities.*;

public class ProvinceService implements IProvinceService {
    PlainProvDao provDao;
    PlainCityDao cityDao;

    public ProvinceService(PlainProvDao provDao, PlainCityDao cityDao) {
        this.provDao = provDao;
        this.cityDao = cityDao;
    }
    
    public void setDataSource(DataSource dataSource) {
        provDao.setDataSource(dataSource);
        cityDao.setDataSource(dataSource);
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