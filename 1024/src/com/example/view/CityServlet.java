package com.example.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.controller.SelectController;
import com.example.model.CityVO;

public class CityServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<form method='post' action='/1024/servlet/City'>");
		out.println("Country Code : <input type='text' name='countrycode' /><br />");
		out.println("<input type='submit' value='Search' />");
		out.println("</form>");
		out.close();
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
		String countryCode = req.getParameter("countrycode");
		Vector<CityVO> vector = SelectController.select(countryCode);
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println("<form method='post' action='/1024/servlet/City'>");
		out.println("Country Code : <input type='text' name='countrycode' /><br />");
		out.println("<input type='submit' value='Search' />");
		out.println("</form>");
		out.println("<hr />");
		out.println("<table border = '1'>");
		out.println("<thead><tr>");
		out.println("<th>번호</th><th>도시명</th><th>국가코드</th><th>지역</th><th>인구</th>");
		out.println("</tr></thead>");
		out.println("<tbody>");
		for(int i = 0 ; i < vector.size() ; i++) {
			out.println("<tr>");
			CityVO city = vector.elementAt(i);
			out.print("<td>" + city.getId() + "</td><td>" + city.getName() + "</td>");
			out.print("<td>" + city.getCountryCode() + "</td><td>" + city.getDistrict() + "</td>") ;
			out.println("<td>" + city.getPopulation() + "</td>");
			out.println("</tr>");
		}
		out.println("</tbody>");
		out.println("</table>");
		out.close();
	}
}


