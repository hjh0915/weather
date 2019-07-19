package com.jxgm.weather.service;

import com.jxgm.weather.entity.Province;
import com.jxgm.weather.repository.ProvinceRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

@Service
@Transactional
public class ProvServiceImpl implements ProvService {

    @Autowired
    ProvinceRepository provinceRepository;

    @Override
    public List<Province> findAll() {
        return provinceRepository.findAllWithCitiesAndSort(new Sort(Sort.Direction.ASC, "id"));
    }

}