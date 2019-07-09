package com.jxgm.weather.repository;

import com.jxgm.weather.entity.Province;
import org.springframework.data.repository.CrudRepository;
// import org.springframework.stereotype.Repository;

// @Repository 
public interface ProvinceRepository extends CrudRepository<Province, Long> {
    // Province findById(Long id);
    // List<Province> findAll();
}