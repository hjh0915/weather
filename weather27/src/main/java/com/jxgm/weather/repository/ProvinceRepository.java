package com.jxgm.weather.repository;

import com.jxgm.weather.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// @Repository 
public interface ProvinceRepository extends JpaRepository<Province, Long> {
    // Province findById(Long id);
    // List<Province> findAll();
}