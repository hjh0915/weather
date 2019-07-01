package com.jxgm.service;

import java.util.List;
import com.jxgm.entities.*;

public interface IProvinceService {
    List<Province> findAll();
    List<Province> findAllWithCities();   
}