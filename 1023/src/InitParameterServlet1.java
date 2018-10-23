import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="IninParameter",urlPatterns= {"/servlet/InitParameterDemo1"},
								initParams= {
															@WebInitParam(name="DBDRIVER",value="org.mariadb.jdbc.Driver"),
															@WebInitParam(name="DBURL",value="jdbc:mariadb://localhost:3306/world"),
															@WebInitParam(name="DBUSER",value="root"),
															@WebInitParam(name="DBPWD",value="javamariadb")
															})//annotation
public class InitParameterServlet1 extends HttpServlet{
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
