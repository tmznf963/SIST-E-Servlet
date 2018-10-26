package com.example.libs.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.libs.controller.Calc;
import com.example.libs.controller.InsertController;
import com.example.libs.model.StudentDTO;

public class InputServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
     throws ServletException, IOException{
		req.setCharacterEncoding("utf-8");
		PrintWriter out = res.getWriter();
		
		String hakbun = req.getParameter("hakbun");
		String name = req.getParameter("name");
		int kor = Integer.parseInt(req.getParameter("kor"));
		int eng = Integer.parseInt(req.getParameter("eng"));
		int mat = Integer.parseInt(req.getParameter("mat"));
		int edp = Integer.parseInt(req.getParameter("edp"));
		StudentDTO s = new StudentDTO(hakbun, name, kor, eng, mat, edp);
		Calc calc = new Calc(s);    calc.calc();
		int row = InsertController.insert(s);
		
		if(row == 1) {
			out.println("<script>");
			out.println("alert('Insert Success');");
			out.println("window.location.href = '/sungjukmgmt/servlet/Index';");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('Insert Failure');");
			out.println("history.back();");
			out.println("</script>");
		}
		out.close();
	}
}









