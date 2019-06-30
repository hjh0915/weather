package com.jxgm.service;

import java.util.List;
import javax.sql.DataSource;

import com.jxgm.dao.*;
import com.jxgm.entities.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class ProvinceService implements IProvinceService {
    PlainProvDao provDao = new PlainProvDao();
    PlainCityDao cityDao = new PlainCityDao();

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