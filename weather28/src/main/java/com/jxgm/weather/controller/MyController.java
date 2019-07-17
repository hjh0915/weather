package com.jxgm.weather.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.ModelMap;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import com.jxgm.weather.service.ProvService;
import com.jxgm.weather.entity.Province;

import java.io.IOException;

import com.jxgm.weather.deal.*;

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

    @GetMapping(value = "/city/{citycode}")
    public String weather(@PathVariable String citycode, ModelMap map) {
        JsonClient jsonClient = new JsonClient();
        JsonConvert jsonConvert = new JsonConvert();

        String cityUrl = jsonClient.getUrl(citycode);

        try{
            String cityVisit = jsonClient.visit(cityUrl);
            Weather w = jsonConvert.deal(cityVisit);
            map.addAttribute("weather", w);
        } catch (Exception e) {
        } 

        return "city";
    }
}