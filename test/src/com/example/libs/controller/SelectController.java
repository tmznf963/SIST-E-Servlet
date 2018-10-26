package com.example.libs.controller;

import java.sql.SQLException;
import java.util.Vector;

import com.example.libs.model.StudentDAO;
import com.example.libs.model.StudentDTO;

public class SelectController {
	public static StudentDTO select(String hakbun) {
		StudentDTO s = null;
		try {
			s = StudentDAO.select(hakbun);
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return s;
	}
	public static Vector<StudentDTO> selectAll() {
		Vector<StudentDTO> vector = null;
		try {
			vector = StudentDAO.selectAll();
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return vector;
	}
}
