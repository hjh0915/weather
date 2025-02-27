package com.jxgm.service;

import com.jxgm.entities.Province;
import java.util.List;

public interface ProvService {
    Province findById(Long id);
    List<Province> findAll();
    List<Province> findAllWithCity();
    
    List<Province> findAllByNativeQuery();

    Province save(Province province);
}