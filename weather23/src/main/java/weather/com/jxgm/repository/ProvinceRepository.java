package com.jxgm.repository;

import java.util.List;

import com.jxgm.entities.Province;
import org.springframework.data.repository.CrudRepository;

public interface ProvinceRepository extends CrudRepository<Province, Long> {
    // Province findById(Long id);
    // List<Province> findAll();
}