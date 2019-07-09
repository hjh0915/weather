package com.jxgm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.ModelMap;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import com.jxgm.service.ProvinceService;
import com.jxgm.entities.*;

@Controller
public class MyController {

    @Autowired  
    private ProvinceService pservice;

    @GetMapping("/")
    public String index(ModelMap map) {
        List<Province> provinces = pservice.findAllWithCities();
        map.addAttribute("provinces", provinces);

        return "index";
    }
}