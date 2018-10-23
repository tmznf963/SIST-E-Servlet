import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException{
		this.doPost(req, res);
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException{
		req.setCharacterEncoding("utf-8");//Post Encoding
		String username = req.getParameter("username");
		int age =Integer.parseInt( req.getParameter("userage"));
		
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		
		out.print("<ul>");
		out.println("<li>Name : "+username+"</li>");
		out.println("<li>Age : "+age+"</li>");
		out.print("</ul>");
		out.close();
	}
}
