package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.Conn;

public class Book {
	
	Connection bookDBConn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public void upload(BookModel bookInfo, int uploadId){
		String sql = "insert into book(bookName,uploadId,writerName) values(?,?,?)";
		
		
		Conn conn = new Conn();
		bookDBConn = conn.getConn();
		try {
			ps = bookDBConn.prepareStatement(sql);
			ps.setString(1, bookInfo.getBookName());
			ps.setString(3, bookInfo.getWriterName());
			ps.setInt(2, uploadId);		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
