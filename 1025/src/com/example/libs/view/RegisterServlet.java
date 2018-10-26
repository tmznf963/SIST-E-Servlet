package com.example.libs.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.libs.controller.InsertController;
import com.example.libs.model.MemberVO;

public class RegisterServlet extends HttpServlet{
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
		throws IOException, ServletException{
		req.setCharacterEncoding("utf-8");
		String username = req.getParameter("username");
		String userid = req.getParameter("userid");
		String userpasswd = req.getParameter("userpasswd");
		String useremail = req.getParameter("useremail");
		String zip1 = req.getParameter("zippost1");
		String zip2 = req.getParameter("zippost2");
		String zippost = "";
		if(!zip1.equals("") && !zip2.equals(""))
			zippost = zip1 + "-" + zip2;
		String useraddress = "";
		String address1 = req.getParameter("useraddress1");
		String address2 = req.getParameter("useraddress2");
		if(!address1.equals("") && !address2.equals(""))
			useraddress = address1 + " " + address2;
		
		MemberVO member = new MemberVO(userid, username, userpasswd, useremail);
		member.setZippost(zippost);
		member.setUseraddress(useraddress);
		//System.out.println(member);
		int row = InsertController.insert(member);
		
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		if(row == 1) 
			out.println("<h1 style='green'>회원 가입을 축하드립니다.</h1>");
		else {
			out.println("<script>");
			out.println("alert('Insert Failure');");
			out.println("history.go(-1);");
			out.println("<script>");
		}
		out.close();
	}
}







