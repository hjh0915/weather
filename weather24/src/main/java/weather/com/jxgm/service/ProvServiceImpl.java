package com.jxgm.service;

import com.jxgm.entities.Province;
import com.jxgm.repository.ProvinceRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

@Service
@Transactional
public class ProvServiceImpl implements ProvService {

    @Autowired
    ProvinceRepository provinceRepository;

    @Override
    public Optional<Province> findById(Long id) {
        return provinceRepository.findById(id);
    }

    @Override
    public List<Province> findAll() {
        List<Province> provinces = new ArrayList<Province>();
        Iterable<Province> results = provinceRepository.findAll();
        for(Province p: results) {
            provinces.add(p);
        }
        return provinces;
    }

}