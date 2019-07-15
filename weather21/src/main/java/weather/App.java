/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package weather;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.*;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jxgm.config.AppConfig;
import com.jxgm.service.ProvService;
import com.jxgm.service.ProvServiceImpl;
import com.jxgm.entities.Province;
import com.jxgm.entities.City;

import weather.Place;

public class App {

    public static Map<Place, List<Place>> getProvinces() throws IOException {
        Gson gson = new GsonBuilder().create();

        Map<Place, List<Place>> cmap = new HashMap<>();

        String fileName = "_city.json";

        List<Place> provinces = new ArrayList<>();
        
        InputStream in = App.class.getClassLoader().getResourceAsStream(fileName);
        
        //String content = Files.toString(new File(fileName), Charsets.UTF_8);
        StringBuilder sb = new StringBuilder();
        String line;

        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        String content = sb.toString();
        //-----------------------------

        Place[] places = gson.fromJson(content, Place[].class);
        
        Arrays.stream(places).forEach( e -> {
            if (e.pid == 0) {
                provinces.add(e);
            }
        });

        for (Place p : provinces) {
            List<Place> cities = new ArrayList<>();
            for (int i=0; i<places.length; i++) {
                //如果市的pid等于省的id，并且市的code不为空
                if (places[i].pid == p.id && !places[i].city_code.equals("")) {
                    //如果省的名称为重庆，并且市的名称中包含了“县”,不加入市列表中
                    if (p.city_name.equals("重庆") && places[i].city_name.contains("县")) {
                    } else {
                        cities.add(places[i]);
                    }
                }
            }
            cmap.put(p, cities);
        }

        return cmap;
    }

    public static void main(String[] args) throws IOException {

        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ProvService provService = ctx.getBean("jpaProvinceService", ProvService.class);

        Map<Place, List<Place>> cmap = getProvinces();
        
        for (Map.Entry<Place, List<Place>> c: cmap.entrySet()) {
            Place k = c.getKey();
            Province province = new Province();
            province.setId(new Long((long)k.getId()));
            province.setName(k.getCityname());

            for (Place x: c.getValue()) {
                City city = new City();
                city.setCode(x.getCitycode());
                city.setName(x.getCityname());
                province.addCity(city);
            }

            provService.save(province);
        }

    }
}
