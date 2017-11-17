package com.qianfeng.demo2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import com.qianfeng.uitl.JDBCTools;

public class Demo2 {
	QueryRunner queryRunner = new QueryRunner();
	
	@Test
	public void test1() throws SQLException{
		Connection conn = JDBCTools.getConnection();
		String sql = "INSERT INTO student values(?,?)";
		queryRunner.update(conn, sql, 33,"zhang");
	}
	
	
	@Test
	public void test2() throws SQLException{
		Connection conn = JDBCTools.getConnection();
		String sql = "SELECT * FROM t_Student WHERE t_Studentid = ?";
		//rsh:结果集处理器
		ResultSetHandler<Student> rsh = new ResultSetHandler<Student>() {

			@Override
			public Student handle(ResultSet rs) throws SQLException {
				Student Student = new Student();
				if(rs.next()){
					Student.setId(rs.getInt("id"));
					Student.setName(rs.getString("name"));

				}
				return Student;
			}
			
		};
		Student student= queryRunner.query(conn, sql, rsh, 1);
		System.out.println(student);
		
	}
	
	
	///获取一条数据
	@Test
	public void test3() throws SQLException{
		Connection conn = JDBCTools.getConnection();
		String sql = "SELECT t_Studentid StudentId,t_Studentname Studentname,t_password password FROM t_Student WHERE t_Studentid = ?";
		Student Student = queryRunner.query(conn, sql, new BeanHandler<>(Student.class) , 1);
		System.out.println(Student);
	}
	
	//获取多条数据   
	@Test
	public void test4() throws SQLException{
		Connection conn = JDBCTools.getConnection();
		String sql = "SELECT t_Studentid StudentId,t_Studentname Studentname,t_password password FROM t_Student";
		List<Student> Students = (List<Student>) queryRunner.query(conn, sql, new BeanListHandler<>(Student.class));
		System.out.println(Students);
	}
	
	
	//以键值对的方式进行获取  
	@Test
	public void test5() throws SQLException{
		Connection conn = JDBCTools.getConnection();
		String sql = "SELECT t_Studentid StudentId,t_Studentname Studentname,t_password password FROM t_Student WHERE t_Studentid=?";
		Map<String,Object> map = queryRunner.query(conn, sql, new MapHandler(),1);
		System.out.println(map);
	}
	
	
	
	//获取单个字段   
	@Test
	public void test6() throws SQLException{
		Connection conn = JDBCTools.getConnection();
		String sql = "SELECT t_Studentname Studentname FROM t_Student WHERE t_Studentid=?";
		 Object obj = queryRunner.query(conn, sql, new ScalarHandler(),1);
		System.out.println(obj);
	}
	
	
	//获取总记录数  
	@Test
	public void test7() throws SQLException{
		Connection conn = JDBCTools.getConnection();
		String sql = "SELECT count(*) FROM t_Student ";
		 Object obj = queryRunner.query(conn, sql, new ScalarHandler());
		System.out.println(obj);
	}
	
	
	
	
	

}
