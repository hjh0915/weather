package com.jxgm.weather.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.ModelMap;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import com.jxgm.weather.service.ProvService;
import com.jxgm.weather.entity.Province;

@Controller
public class MyController {

    @Autowired  
    private ProvService pservice;

    @GetMapping("/")
    public String index(ModelMap map) {
        List<Province> provinces = pservice.findAll();
        map.addAttribute("provinces", provinces);

        return "index";
    }
}