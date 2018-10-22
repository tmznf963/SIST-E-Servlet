import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class HelloWorldServlet extends HttpServlet {
	//ctrl+shift+o
	@Override
	public void doGet(HttpServletRequest req , HttpServletResponse res)throws IOException, ServletException{
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.print("<!DOCTYPE html>");
		out.print("<html lang=\"ko\">");
		out.print("<head>");
		out.print("    <meta charset=\"UTF-8\">");
		out.print("    <title>Document</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h1>Welcome!! 접속시간"+new Date()+"</h1>");
		out.print("</body>");
		out.print("</html>");
		out.close();
	}
}
