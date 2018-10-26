package com.example.libs.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
	//-1 : 그런 아이디 없다., 0 : 아이디는 있으나 비밀번호가 불일치한다. , 1 : 모두 맞다.
	public static int userLogin(String userid, String userpasswd) throws SQLException{
		Connection conn = DBConnection1.getConnection();
		String sql = "SELECT userpasswd FROM Member WHERE userid = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userid);
		ResultSet rs = pstmt.executeQuery();
		int flag = -2;
		if(!rs.next())  flag = -1;    //그런 아이디가 아예 없었다면
		else {   //아이디는 있다.
			String dbpwd = rs.getString("userpasswd");
			if(dbpwd.trim().equals(userpasswd.trim()))  flag = 1;
			else flag = 0;
		}
		DBClose.close(conn);
		return flag;
	}
	public static int insert(MemberVO member) throws SQLException{
		Connection conn = DBConnection1.getConnection();
		String sql = "INSERT INTO Member VALUES(?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, member.getUserid());
		pstmt.setString(2, member.getUsername());
		pstmt.setString(3, member.getUserpasswd());
		pstmt.setString(4, member.getUseremail());
		pstmt.setString(5, member.getZippost());
		pstmt.setString(6,  member.getUseraddress());
		int row = pstmt.executeUpdate();
		DBClose.close(conn);
		return row;
	}
}




