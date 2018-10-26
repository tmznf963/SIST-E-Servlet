package com.example.libs.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.libs.controller.SelectController;
import com.example.libs.model.StudentDTO;

public class DetailServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
     throws ServletException, IOException{
		String hakbun = req.getParameter("hakbun");
		StudentDTO s = SelectController.select(hakbun);
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println("<h3>" + s.getName() + "의 정보</h3>");
		out.println("<ul>");
		out.println("<li>학번 : " + s.getHakbun() + "</li>");
		out.println("<li>국어 : " + s.getKor() + "</li>");
		out.println("<li>영어 : " + s.getEng() + "</li>") ;
		out.println("<li>수학 : " + s.getMat() + "</li>");
		out.println("<li>전산 : " + s.getEdp() + "</li>");
		out.println("<li>총점 : " + s.getSum() + "</li>");
		out.println("<li>평균 : " + s.getAvg() + "</li>");
		out.println("<li>평점 : " + s.getGrade() + "</li>");
		out.println("<li><button onclick='javascript:self.close();'>창 닫기</button></li>");
		out.println("</ul>");
		out.close();
	}
}









