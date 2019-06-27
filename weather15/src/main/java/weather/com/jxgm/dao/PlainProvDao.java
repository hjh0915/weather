package com.jxgm.dao;

import java.util.*;

import java.sql.*;

import com.jxgm.entities.Province;

import com.jxgm.DBConnection.DB;

//省
public class PlainProvDao implements ProvDao {
    
    public Province findById(String id) {
        Province p = new Province();
        Connection connection = null;
        try {
            connection = DB.getCon();
            PreparedStatement pstmt = connection.prepareStatement("select name from province where id = ?");
            pstmt.setString(1, id);

            ResultSet result = pstmt.executeQuery();

            if (result.next()) {
                String name = result.getString("name");

                p.setId(id);
                p.setName(name);

            }
            pstmt.close();
        } catch (SQLException ex) {
            System.out.println("database conn error");
        } finally{
        }
        return p;
    }

    public List<Province> findAll() {
        List<Province> provinces = new ArrayList<>();
        Connection connection = null;
        try {
            connection = DB.getCon();
            PreparedStatement pstmt = connection.prepareStatement("select id, name from province");

            ResultSet result = pstmt.executeQuery();

            while (result.next()) {
                Province prov = new Province();
                String id = result.getString("id");
                String name = result.getString("name");

                prov.setId(id);
                prov.setName(name);

                provinces.add(prov);
            }
            pstmt.close();
        } catch (SQLException ex) {
            System.out.println("database conn error");
        } finally{
        }
        return provinces; 
    }
}