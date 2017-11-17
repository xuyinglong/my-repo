package com.qianfeng.uitl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCTools {
	/*private static String driver;
	private static String url;
	private static String username;
	private static String password;
	private static Properties prop = new Properties();
	
	static{
		InputStream in = JDBCTools.class.getClassLoader().getResourceAsStream("db.properties");
		try {
			prop.load(in);
			driver = prop.getProperty("jdbc.driver");
			url = prop.getProperty("jdbc.url");
			username = prop.getProperty("jdbc.username");
			password = prop.getProperty("jdbc.password");
			
			Class.forName(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
		
	}
	*/
	
	
	/*public static Connection getConnection(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url ,username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}*/
	
	//使用dbcp连接池
	/*static DataSource dataSource = null;
	static Properties prop = new Properties();
	
	static{
		 try {
			prop.load(JDBCTools.class.getClassLoader().getResourceAsStream("db.properties"));
			dataSource =  BasicDataSourceFactory.createDataSource(prop);
			System.out.println(dataSource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	*/
	
	//使用c3p0链接池 
	
	static DataSource dataSource = null;
	static{
		dataSource = new ComboPooledDataSource("hello");
	}
	
	public static Connection getConnection(){
		Connection conn = null;
		try {
			conn = dataSource.getConnection() ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	
	
	public static void closeConnection(Connection conn,PreparedStatement ps,ResultSet rs){
		
		
		try {
			if(rs != null)
				rs.close();
			if(ps != null)
				ps.close();
			if(conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		System.out.println(getConnection());
	}
	

}
