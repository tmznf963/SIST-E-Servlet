package com.example.libs.controller;

import java.sql.SQLException;
import java.util.Vector;

import com.example.libs.model.MemberDAO;
import com.example.libs.model.ZipcodeDAO;
import com.example.libs.model.ZipcodeDTO;

public class SelectController {
	public static int userLogin(String userid, String userpasswd) {
		int flag = -2;
		try {
			flag = MemberDAO.userLogin(userid, userpasswd);
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return flag;
	}
	public static Vector<ZipcodeDTO> select(String dongName){
		Vector<ZipcodeDTO> vector = null;
		try {
			vector = ZipcodeDAO.selectZipcode(dongName);
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return vector;
	}
}
