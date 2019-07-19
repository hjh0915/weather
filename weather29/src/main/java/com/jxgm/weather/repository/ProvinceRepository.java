package com.jxgm.weather.repository;

import com.jxgm.weather.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Sort;

import java.util.List;
// import org.springframework.stereotype.Repository;

// @Repository 
public interface ProvinceRepository extends JpaRepository<Province, Long> {
    // Province findById(Long id);

    @Query("select distinct s from Province s left join fetch s.cities a ")
    List<Province> findAllWithCitiesAndSort(Sort sort);
    
}