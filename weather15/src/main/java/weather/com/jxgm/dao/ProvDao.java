package com.jxgm.dao;

import com.jxgm.entities.Province;
import java.util.List;

public interface ProvDao {
    Province findById(String id);   //通过id找到province
    List<Province> findAll();

}