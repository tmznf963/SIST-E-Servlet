package com.example.libs.controller;

import java.sql.SQLException;

import com.example.libs.model.StudentDAO;
import com.example.libs.model.StudentDTO;

public class InsertController {
	public static int insert(StudentDTO s) {
		int row = 0;
		try {
			row = StudentDAO.insert(s);
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return row;
	}
}
