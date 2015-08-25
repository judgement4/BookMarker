package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.Conn;

public class User {
	
	private Connection userDBConn = null;
	private PreparedStatement sm = null;
	private ResultSet rs = null;
	public boolean flag = false;
	
	public UserModel checkUser(String username, String password){

		String passwd;
		UserModel user = new UserModel();
		Conn conn = new Conn();
		userDBConn = conn.getConn();
		try{
			sm = userDBConn.prepareStatement("select * from user where username = ?");
			sm.setString(1, username);
			rs = sm.executeQuery();
			if(rs.next()){
				flag = true;
				passwd = rs.getString("password");
				if(passwd.equals(password)){
	
					user.setUsername(username);
					user.setPassword(rs.getString("password"));
					user.setEmail(rs.getString("email"));
					user.setUid(rs.getInt("uid"));
				}

			}

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				if(rs != null)rs.close();
				if(sm != null)sm.close();
				if(userDBConn != null)userDBConn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return user;
	}
}
