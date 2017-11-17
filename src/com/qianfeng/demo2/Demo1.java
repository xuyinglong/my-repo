package com.qianfeng.demo2;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import com.qianfeng.uitl.JDBCTools;

public class Demo1 {
		QueryRunner queryRunner = new QueryRunner();
		@Test
		 public void test1() throws SQLException{
			Connection conn = JDBCTools.getConnection();
				String sql = "insert into student values(?,?)";
				queryRunner.update(conn, sql, 3,"李四");
		}
		
}
