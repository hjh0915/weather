package com.jxgm.weather.service;

import com.jxgm.weather.entity.Province;
import java.util.List;

public interface ProvService {
    List<Province> findAll();
}