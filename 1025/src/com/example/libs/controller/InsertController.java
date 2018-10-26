package com.example.libs.controller;

import java.sql.SQLException;

import com.example.libs.model.MemberDAO;
import com.example.libs.model.MemberVO;

public class InsertController {
	public static int insert(MemberVO member) {
		int row = 0;
		try {
			row = MemberDAO.insert(member);
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return row;
	}
}
