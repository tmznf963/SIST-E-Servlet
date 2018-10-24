package com.example.controller;

import java.sql.SQLException;
import java.util.Vector;

import com.example.model.CityDAO;
import com.example.model.CityVO;

public class SelectController {
	public static Vector<CityVO> select(String countryCode){
		Vector<CityVO> vector = null;
		try {
			vector = CityDAO.select(countryCode);
		}catch(SQLException e) {
			System.out.println(e);
		}
		return vector;
	}
}
