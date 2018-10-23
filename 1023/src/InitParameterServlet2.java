import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="IninParameter2",urlPatterns= {"/servlet/InitParameterDemo2"},
								initParams= {	@WebInitParam(name="dbinfo",value="C:/temp/dbinfo.properties")})//annotation
public class InitParameterServlet2 extends HttpServlet{
	private ServletConfig config;
	private Properties props;//set,get
	
	@Override
	public void init() {//초기화(생성자 역할)
		config = this.getServletConfig();
		String filename = config.getInitParameter("dbinfo");
		props = new Properties();
		try {
			props.load(new FileInputStream(new File(filename)));
		} catch (IOException e) {
			System.out.println("File Not Found...");
		} 
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		Enumeration<Object> enums = this.props.keys();
		out.println("<ul>");
		while(enums.hasMoreElements()) {
			String key = (String)enums.nextElement();//object --> String
			out.println("<li>" + key + " : " + this.props.getProperty(key)+"</li>");
		}
		out.println("</ul>");
		out.close();
	}
}
