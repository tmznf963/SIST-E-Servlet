package com.example.libs.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.libs.controller.SelectController;
import com.example.libs.model.StudentDTO;

public class IndexServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
     throws ServletException, IOException{
		Vector<StudentDTO> vector = SelectController.selectAll();
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"utf-8\">");
		out.println("<title>쌍용고등학교 성적관리 프로그램</title>");
		out.println("<link rel=\"stylesheet\" href=\"../css/style.css\">");
		out.println("<script>");
		out.println("  function myclick(obj){");
		out.println("      var hakbun = obj.getAttribute('id');  ");
		out.println("      var myevent = window.event;");
		out.println("      var feature = 'left=' + myevent.screenX + ', top=' + myevent.screenY + ', width=500, height=500';");
		out.println("      window.open('/sungjukmgmt/servlet/Detail?hakbun=' + hakbun, '_blank', feature)");
		out.println("  }");
		out.println("</script>");
		out.println("</head>");
		out.println("<body>");
		out.println("	<h1>쌍용고등학교 학생 성적표</h1>");
		out.println("<table border='0'>");
		out.println("<tbody>");
		out.println("<tr>");
		int count = 0;
		if(vector == null)  count = 0;
		else count = vector.size(); 
		out.print("<td><a href='/sungjukmgmt/input.html'>학생 입력하기</a>");
		out.println("</td><td>(" + count + "명)</td>");
		out.println("</tr>");
		out.println("</tbody>");
		out.println("</table>");
		out.println("<table>");
		out.println("<thead>");
		out.println("<tr>");
		out.println("<th>학번</th><th>이름</th><th>국어</th>");
		out.println("<th>영어</th><th>수학</th><th>전산</th>");
		out.println("</tr>");
		out.println("</thead>");
		out.println("<tbody>");
		if(vector == null || vector.size() == 0) {
			out.print("<tr><td colspan='6' style='text-align:center'>");
			out.println("학생 데이터가 없습니다.</td></tr>");
		}else {
			for(int i = 0 ; i < vector.size(); i++) {
				out.println("<tr>");
				StudentDTO s = vector.elementAt(i);
				out.print("<td><a href='javascript:void(0)' id='" + s.getHakbun() + "' onclick='myclick(this)'>" + s.getHakbun() + "</a></td><td>" + s.getName() + "</td>");
				out.print("<td>" + s.getKor() + "</td><td>" + s.getEng() + "</td>");
				out.print("<td>" + s.getMat() + "</td><td>" + s.getEdp() + "</td>");
				out.println("</tr>");
			}
		}
		out.println("</tbody>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}





