package com.jxgm.dao;

import java.util.*;

import java.sql.*;

import com.jxgm.entities.Province;
import com.jxgm.entities.City;

import com.jxgm.DBConnection.DB;

//省
public class PlainProvDao implements ProvDao {
    
    public Province findById(String id) {
        Province p = new Province();
        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = DB.getCon();
            stmt = connection.prepareStatement("select name from province where id = ?");
            stmt.setString(1, id);

            ResultSet result = stmt.executeQuery();

            if (result.next()) {
                String name = result.getString("name");

                p.setId(id);
                p.setName(name);

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
        return p;
    }

    public List<Province> findAll() {
        List<Province> provinces = new ArrayList<>();
        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = DB.getCon();
            stmt = connection.prepareStatement("select id, name from province");

            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                Province prov = new Province();
                String id = result.getString("id");
                String name = result.getString("name");

                prov.setId(id);
                prov.setName(name);

                provinces.add(prov);
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
        return provinces; 
    }

    public List<Province> findAllWithCities() {

        List<Province> provinces = new ArrayList<>();
        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = DB.getCon();
            stmt = connection.prepareStatement("select t1.id, t1.name, t2.pid, t2.code, t2.name as cname from province t1, pcity t2 where t1.id = t2.pid");

            ResultSet result = stmt.executeQuery();

            Map<String, Province> map = new HashMap<>();
            Province prov;

            while (result.next()) {

                String id = result.getString("id");
                prov = map.get(id);
                
                if (prov == null) {
                    prov = new Province();
                    prov.setId(id);
                    prov.setName(result.getString("name"));
                    map.put(id, prov);

                    City city = new City();
                    String pid = result.getString("pid");
                    String code = result.getString("code");
                    String name = result.getString("cname");

                    city.setPid(pid);
                    city.setCode(code);
                    city.setName(name);

                    prov.addCity(city);

                } else {
                    City city = new City();
                    String pid = result.getString("pid");
                    String code = result.getString("code");
                    String name = result.getString("cname");

                    city.setPid(pid);
                    city.setCode(code);
                    city.setName(name);

                    prov.addCity(city);
                }

            }

            for (Province x : map.values()) {
                provinces.add(x);
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
        return provinces;
    }
}