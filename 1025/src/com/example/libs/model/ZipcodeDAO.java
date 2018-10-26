package com.example.libs.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class ZipcodeDAO {
	public static Vector<ZipcodeDTO> selectZipcode(String dongName) 
			throws SQLException{
		Connection conn = DBConnection.getConnection();
		String sql = "SELECT zipcode, sido, gugun, dong, bunji ";
		sql += "   FROM zipcode  WHERE  dong LIKE '%" + dongName + "%' ";
		Statement pstmt = conn.createStatement();
		ResultSet rs = pstmt.executeQuery(sql);
		Vector<ZipcodeDTO> vector = new Vector<ZipcodeDTO>(1,1);
		if(!rs.next()) {  //찾고자 하는 읍/면/동이 없다면
			vector = null;
		}else {
			do {
				ZipcodeDTO zip = new ZipcodeDTO(rs.getString("zipcode"), 
						rs.getString("sido"), rs.getString("gugun"), rs.getString("dong"),
						rs.getString("bunji"));
				vector.addElement(zip);
			}while(rs.next());
		}
		DBClose.close(conn);
		return vector;
	}
}





