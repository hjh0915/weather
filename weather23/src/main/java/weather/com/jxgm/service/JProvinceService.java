package com.jxgm.service;

import java.util.List;

import com.jxgm.dao.*;
import com.jxgm.entities.*;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("namedService")
public class JProvinceService implements IJProvinceService {
    // @Autowired 
    PlainProvDao provDao;
    
    // @Autowired
    public JProvinceService(PlainProvDao provDao) {
        this.provDao = provDao;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
        provDao.setJdbcTemplate(jdbcTemplate);
    }

    public List<Province> findAllWithCities() {
        List<Province> prov = provDao.findAllWithCities();
        return prov;
    }    
}