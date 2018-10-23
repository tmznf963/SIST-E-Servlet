import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitParameterServlet extends HttpServlet{
	private ServletConfig config;
	@Override
	public void init() {
		config = this.getServletConfig();
	}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		Enumeration<String> names = config.getInitParameterNames();
		out.println("<ul>");
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			out.println("<li>" + name + " : " + config.getInitParameter(name)+"</li>");
		}
		out.println("</ul>");
		out.close();
	}
}
