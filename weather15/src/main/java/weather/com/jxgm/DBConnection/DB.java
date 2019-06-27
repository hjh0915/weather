package com.jxgm.DBConnection;
import java.sql.*;
import java.util.*;
import java.io.InputStream;
import java.io.IOException;
import java.net.URL;

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
	
	public static Connection getCon() throws SQLException {

        Properties props = getConnectionData();

        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String passwd = props.getProperty("db.passwd");
		String jdbcdriver = props.getProperty("db.jdbcdriver");

        try {
			Class.forName(jdbcdriver);
		} catch (ClassNotFoundException e) {
		}
		Connection con = DriverManager.getConnection(url, user, passwd);
		return con;
	}

	public void closeCon(Connection con) throws SQLException{
		if (con != null) {
			con.close();
		}
	}
}