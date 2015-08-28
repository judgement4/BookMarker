/**本类实现对于UserModel的数据操作
 * 方法：验证用户登录，增加用户，删除用户，改用户信息，列举用户列表
 */

package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.Conn;

public class User {
	
	private Connection userDBConn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	public boolean flag = false;
	
	public UserModel checkUser(String username, String password){

		String passwd;
		String sql = "select * from user where username = ?";
		UserModel user = new UserModel();
		Conn conn = new Conn();
		userDBConn = conn.getConn();
		try{
			ps = conn.prepare(userDBConn, sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
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
				if(rs != null)
					conn.close(rs);
				if(ps != null)
					conn.close(ps);
				if(userDBConn != null)
					conn.close(userDBConn);
				}
		return user;
	}
	
	
	public int add(UserModel regForm){
		int count = 0;
		String sql = "insert into user(username,password,email) values(?,?,?)";
		Conn conn = new Conn();
		
		userDBConn = conn.getConn();

		try {
			ps = userDBConn.prepareStatement(sql);
			ps.setString(1, regForm.getUsername());
			ps.setString(2, regForm.getPassword());
			ps.setString(3, regForm.getEmail());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conn.close(userDBConn);
		conn.close(ps);
		conn.close(rs);
		return count;
	}
	
	
	public int delete(UserModel deleteForm){
		int flag = 0;
		Conn conn = new Conn();
		
		String sql = "delete from user where id = ?";
		
		userDBConn = conn.getConn();
		try {
			ps = userDBConn.prepareStatement(sql);
			ps.setInt(1, deleteForm.getUid());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			flag = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;	
	}
	
	public List list(){
		List userList = new ArrayList();
		
		return userList;
		
	}
	
	public int change(){
		int flag = 0;
		return flag;
	}
	
}
