package com.jxgm.weather.service;

import com.jxgm.weather.entity.Province;
import java.util.List;
import java.util.Optional;

public interface ProvService {
    Optional<Province> findById(Long id);
    List<Province> findAll();
}