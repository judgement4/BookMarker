package common;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;



public class Conn {
	 Connection conn = null;
	 
	 public Connection getConn(){
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
}
