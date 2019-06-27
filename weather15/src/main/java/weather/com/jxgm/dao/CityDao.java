package com.jxgm.dao;

import com.jxgm.entities.City;

import java.util.*;

public interface CityDao {
    List<City> findByPid(String pid);   //通过pid找到city
}