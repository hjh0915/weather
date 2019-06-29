package com.jxgm.DBConnection;
import java.sql.*;
import java.util.*;
import java.io.InputStream;
import java.io.IOException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public class DB {
	
	static Properties getConnectionData() {

		Properties props = new Properties();

		String fileName = "db.properties";

		InputStream in = DB.class.getClassLoader().getResourceAsStream(fileName);

		try {
            props.load(in);
        } catch (IOException ex) {
			System.out.println("db.properties is none");
        }

        return props;
	}
	
	public static SimpleDriverDataSource getDataSource() {

        Properties props = getConnectionData();

        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String passwd = props.getProperty("db.passwd");
		String jdbcdriver = props.getProperty("db.jdbcdriver");

		try {
			SimpleDriverDataSource ds = new SimpleDriverDataSource();
			ds.setDriverClass((Class<Driver>) Class.forName(jdbcdriver));
			ds.setUrl(url);
			ds.setUsername(user);
			ds.setPassword(passwd);

			return ds;
		} catch (ClassNotFoundException e) {
			return null;
		}
	}
}