package com.qianfeng.demo1;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DemoC3p0 {
	
	@Test
	public void test1(){
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		try {
			comboPooledDataSource.setDriverClass("com.mysql.jdbc.Driver");
			comboPooledDataSource.setJdbcUrl("jdbc:mysql:///test1");
			comboPooledDataSource.setUser("root");
			comboPooledDataSource.setPassword("123456");
			
			
			Connection conn = comboPooledDataSource.getConnection();
			System.out.println(conn);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
