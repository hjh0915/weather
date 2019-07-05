package com.jxgm.dao;

import com.jxgm.entities.Province;
import java.util.List;

public interface ProvDao {
    List<Province> findAllWithCities();
}