package com.jxgm.service;

import java.util.List;
import com.jxgm.dao.*;
import com.jxgm.entities.*;

public class ProvinceService implements IProvinceService {
    public List<Province> findAll() {

        ProvDao provDao = new PlainProvDao();
        CityDao cityDao = new PlainCityDao();

        List<Province> provinces = provDao.findAll();
        
        for (Province p: provinces) {
            String id = p.getId();

            List<City> cities = cityDao.findByPid(id);

            p.setCities(cities);
        }  

        return provinces;
    }
}