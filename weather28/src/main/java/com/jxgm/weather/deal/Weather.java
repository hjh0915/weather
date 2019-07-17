package com.jxgm.weather.deal;

import java.util.*;

public class Weather {
    public String cityid;
    public String update_time; 
    public String city;
    public String cityEn;
    public String country;
    public String countryEn;

    List<Data> data;


    @Override
    public String toString() {
        return "city:" + this.city; 
    }
}

class Data {
    String day;
    String date;
    String week;
    String wea;
    String wea_img;
    int air;
    int humidity;
    String air_leve1;
    String air_tips;

    Alarm alarm;

    String tem1;
    String tem2;
    String tem;

    List<String> win;

    String win_speed;

    List<Hour> hours;
    List<Index> indexes;
}

class Alarm {
    String alarm_type;
    String alarm_level;
    String alarm_content;
}

class Hour {
    String day;
    String wea;
    String tem;
    String win;
    String win_speed;
}

class Index {
    String title;
    String level;
    String desc;
}