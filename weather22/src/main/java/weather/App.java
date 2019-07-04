/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package weather;

import java.io.IOException;
import java.util.*;
import java.sql.*;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jxgm.config.AppConfig;
import com.jxgm.service.ProvService;
import com.jxgm.entities.Province;

public class App {

    public static void main(String[] args) throws IOException {

        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ProvService provService = ctx.getBean("jpaProvinceService", ProvService.class);

        Province p = provService.findById(new Long(16));
        System.out.println(p);
        System.out.println(p.getCities());

        List<Province> provinces = provService.findAllWithCity();
        provinces.forEach(System.out::println);

        System.out.println("-----------------------------");
        
        provinces = provService.findAll();
        provinces.forEach(System.out::println);

        System.out.println("-----------------------------");

        provinces = provService.findAllByNativeQuery();
        provinces.forEach(System.out::println);
    }
}
