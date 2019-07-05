package com.jxgm.service;

import com.jxgm.entities.Province;
import java.util.List;

public interface IJProvinceService {
    List<Province> findAllWithCities();
}