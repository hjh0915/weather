package com.jxgm.weather;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import org.springframework.beans.factory.annotation.Autowired;
import com.jxgm.weather.service.ProvService;

import java.util.Optional;
import com.jxgm.weather.entity.Province;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class MyRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);

    @Autowired
    ProvService provService;

    @Override
    public void run(String... args) throws Exception {
        logger.info("开始打印...");
        Optional<Province> p = provService.findById(new Long(16));
        if (p.isPresent()) {
            Province x = p.get();
            logger.info("{}", x);
        }
    }
}