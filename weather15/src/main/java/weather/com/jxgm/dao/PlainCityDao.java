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
        PreparedStatement stmt = null;
        try {
            connection = DB.getCon();
            stmt = connection.prepareStatement("select code, name from pcity where pid = ?");
            stmt.setString(1, pid);

            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                String code = result.getString("code");
                String name = result.getString("name");

                c = new City();
                c.setPid(pid);
                c.setCode(code);
                c.setName(name);
                cities.add(c);
            }
            
        } catch (SQLException ex) {
            System.out.println("database conn error");
        } finally{
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                //
            }
        }
        return cities;
    }
}