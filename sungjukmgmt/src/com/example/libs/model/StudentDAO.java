package com.example.libs.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class StudentDAO {
	public static StudentDTO select(String hakbun) throws SQLException{
		Connection conn = DBConnection.getConnection("pool");//File Name :: pool.jocl
		String sql = "SELECT * FROM Student WHERE hakbun = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, hakbun);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		StudentDTO s = new StudentDTO(rs.getString("hakbun"), rs.getString("name"),
				                 rs.getInt("kor"), rs.getInt("eng"), rs.getInt("mat"), rs.getInt("edp"));
		s.setSum(rs.getInt("sum"));
		s.setAvg(rs.getDouble("avg"));
		s.setGrade(rs.getString("grade").charAt(0));
		DBClose.close(conn);
		return s;
	}
	public static int insert(StudentDTO s) throws SQLException{
		Connection conn = DBConnection.getConnection("pool");
		String sql = "INSERT INTO Student VALUES(?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, s.getHakbun());
		pstmt.setString(2, s.getName());
		pstmt.setInt(3, s.getKor());    pstmt.setInt(4, s.getEng());
		pstmt.setInt(5, s.getMat());    pstmt.setInt(6, s.getEdp());
		pstmt.setInt(7, s.getSum());   pstmt.setDouble(8, s.getAvg());
		pstmt.setString(9, String.valueOf(s.getGrade()));
		int row = pstmt.executeUpdate();
		DBClose.close(conn);
		return row;
	}
	
	public static Vector<StudentDTO> selectAll() throws SQLException{
		Connection conn = DBConnection.getConnection("pool");
		Statement stmt = conn.createStatement();
		String sql = "SELECT hakbun, name, kor, eng, mat, edp FROM Student " +
		                  "ORDER BY hakbun ASC";
		ResultSet rs = stmt.executeQuery(sql);
		Vector<StudentDTO> vector = new Vector<StudentDTO>(1,1);
		if(!rs.next()) {  //학생 데이터가 한 개도 없다면
			vector = null;
		}else {   //한 명이라도 있다면
			do {
				StudentDTO s = new StudentDTO(rs.getString("hakbun"), 
						rs.getString("name"), rs.getInt("kor"), rs.getInt("eng"),
						rs.getInt("mat"), rs.getInt("edp"));
				vector.addElement(s);
			}while(rs.next());
		}
		DBClose.close(conn);
		return vector;
	}
}
