package com.example.libs.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.libs.controller.SelectController;

public class LoginServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
		String userid = req.getParameter("userid");
		String userpasswd = req.getParameter("userpasswd");
		int flag = SelectController.userLogin(userid, userpasswd);
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		switch(flag) {
			case 0 :
				out.println("<body bgcolor='red'><h1>비밀번호가 일치하지 않습니다.</h1></body>");
				break;
			case 1 :
				out.println("<body bgcolor='green'><h1>회원만의 환상적인 서비스를 기대하세요.</h1></body>");
				break;
			case -1 : 
				out.println("<body bgcolor='orange'><h1>아이디 자체가 없습니다.</h1></body>");
				break;
		}
		out.close();
	}
}






