package common;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;



public class Conn {
	 Connection conn = null;
	 
	 public Connection getConn(){
		 try {
			   Class.forName("com.mysql.jdbc.Driver"); //����mysq����
			  } catch (ClassNotFoundException e) {
			   System.out.println("�������ش���");
			   e.printStackTrace();//��ӡ������ϸ��Ϣ
			  }
		 try {
			  conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/struts2book", "admin", "admin"); //�������ݿ�
			  } catch (SQLException e) {
			   System.out.println("�������ش���");
			   e.printStackTrace();//��ӡ������ϸ��Ϣ
			  }
		 return conn;
	 }
}
