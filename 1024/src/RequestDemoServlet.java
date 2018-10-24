import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestDemoServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
		throws IOException, ServletException{
		this.myService(req, res);
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
		throws IOException, ServletException{
		this.myService(req, res);
	}
	private void myService(HttpServletRequest req, HttpServletResponse res)
		throws IOException, ServletException{
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("username");
		int age = Integer.parseInt(req.getParameter("userage"));
		String gender = req.getParameter("gender");  //male, female
		String [] array = req.getParameterValues("hobby");
		String hobby = "";
		for(int i = 0 ; i < array.length ; i++) hobby += array[i] + ",";
		hobby = hobby.substring(0,  hobby.length() - 1);
		
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println("<h1>회원 가입 결과</h1>");
		out.println("<ul>");
		out.println("<li>이름 : " + name + "</li>");
		out.println("<li>나이 : " + age + "</li>");
		out.println("<li>성별 : " + gender + "</li>");
		out.println("<li>취미 : " + hobby + "</li>");
		out.println("</ul>");
		out.close();
	}
}