package com.jxgm.weather;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import org.springframework.beans.factory.annotation.Autowired;
import com.jxgm.weather.service.ProvService;

import java.util.Optional;
import com.jxgm.weather.entity.Province;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    ProvService provService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("okkkkkkkkkkkkkkkkkkkkk");
        Optional<Province> p = provService.findById(new Long(16));
        if (p.isPresent()) {
            Province x = p.get();
            System.out.println(x);
        }
    }
}