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
