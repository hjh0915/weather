package com.jxgm.service;

import com.jxgm.entities.Province;
import java.util.List;
import java.util.Optional;

public interface ProvService {
    Optional<Province> findById(Long id);
    List<Province> findAll();
}