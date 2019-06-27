package com.jxgm.dao;

import java.util.*;

import java.sql.*;

import com.jxgm.entities.City;

import com.jxgm.DBConnection.DB;

//城市
public class PlainCityDao implements CityDao {

    public List<City> findByPid(String pid) {
        City c;
        List<City> cities = new ArrayList<>();
        Connection connection = null;
        try {
            connection = DB.getCon();
            PreparedStatement pstmt = connection.prepareStatement("select code, name from pcity where pid = ?");
            pstmt.setString(1, pid);

            ResultSet result = pstmt.executeQuery();

            while (result.next()) {
                String code = result.getString("code");
                String name = result.getString("name");

                c = new City();
                c.setPid(pid);
                c.setCode(code);
                c.setName(name);
                cities.add(c);
            }
            pstmt.close();
        } catch (SQLException ex) {
            System.out.println("database conn error");
        } finally{
        }
        return cities;
    }
}