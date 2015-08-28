package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;


public class Conn {
	 
	 public Connection getConn(){
		 Connection conn = null;
		 try {
			   Class.forName("com.mysql.jdbc.Driver"); //加载mysq驱动
			  } catch (ClassNotFoundException e) {
			   System.out.println("驱动加载错误");
			   e.printStackTrace();//打印出错详细信息
			  }
		 try {
			  conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/struts2book", "admin", "admin"); //连接数据库
			  } catch (SQLException e) {
			   System.out.println("驱动加载错误");
			   e.printStackTrace();//打印出错详细信息
			  }
		 return conn;
	 }
	 public PreparedStatement prepare(Connection conn, String sql){
		 PreparedStatement ps = null;
		 try {
			ps = conn.prepareStatement(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ps;
	 }
	 public void close(Connection conn){
		 if(conn != null){
			 try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
	 }
	 public  void close(Statement st){
		 if(st != null){
			 try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
	 }
	 public void close(ResultSet rs){
		 if(rs != null){
			 try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
	 }
}
