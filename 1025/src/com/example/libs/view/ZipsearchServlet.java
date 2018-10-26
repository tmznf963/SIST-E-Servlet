package com.example.libs.view;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.libs.controller.SelectController;
import com.example.libs.model.ZipcodeDTO;

public class ZipsearchServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println("<h3>찾고자 하시는 읍/면/동이름을 입력후 검색버튼을 눌러주세요.</h3>");
		out.println("<form method='post'>");
		out.println("읍/면/동 : <input type='text' name='txtZipcode' required='required'>");
		out.println("<input type='submit' value='검색'>");
		out.println("</form>");
		out.close();
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
		req.setCharacterEncoding("utf-8");
		String dongName = req.getParameter("txtZipcode");
		Vector<ZipcodeDTO> vector = SelectController.select(dongName);
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println("<h3>찾고자 하시는 읍/면/동이름을 입력후 검색버튼을 눌러주세요.</h3>");
		out.println("<form method='post'>");
		out.println("읍/면/동 : <input type='text' name='txtZipcode' required='required'>");
		out.println("<input type='submit' value='검색'>");
		out.println("</form>");
		out.println("<hr />");
		if(vector == null || vector.size() == 0) {
			out.println("<p style='color:red'>검색 결과가 없습니다. 확인 후 다시 검색해 주세요.</p>");
		}else {
			out.println("<select id='ziplist'>");
			out.println("<option>--선택--</option>");
			for(int i = 0 ; i < vector.size(); i++) {
				ZipcodeDTO zip = vector.elementAt(i);
				out.print("<option value='" + zip.toString() + "'>");
				out.println(zip.toString() + " " + zip.getBunji() + "</option>");
			}
			out.println("</select><br />");
			out.println("<button type='button' onclick='myclose()'>창닫기</button>");
			out.println("<script>");
			out.println("  function myclose(){");
			out.println("    var idx = document.getElementById('ziplist').selectedIndex;");
			out.println("    var str = document.getElementById('ziplist').options[idx].value;");
			out.println("    opener.document.forms[0].zippost1.value = str.substring(1, 4);");
			out.println("    opener.document.forms[0].zippost2.value = str.substring(5, 8);");
			out.println("    opener.document.forms[0].useraddress1.value = str.substring(10);");
			out.println("    self.close();");
			out.println("  }");
			out.println("</script>");
		}
		out.close();
	}
}





