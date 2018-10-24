import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;   //1. import 한다.   

public class JdbcDemoServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		try {
			Class.forName("org.mariadb.jdbc.Driver");  //2. Driver loading 한다.
		}catch(ClassNotFoundException ex) {
			System.out.println("Class Not Found");
		}
		Connection conn = null;
		try {
			//3. Database Connection한다.
			conn = DriverManager.getConnection("jdbc:mariadb://192.168.56.4:3306/world", 
				                                     "root", "root");
		}catch(SQLException ex) {
			System.out.println("Mariadb cannot connect.");
		}
		Statement stmt = null;   //4. Statement 객체 생성
		try {
			stmt = conn.createStatement();
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		ResultSet rs = null;
		try {
			//5. query 실행한다.
			rs = stmt.executeQuery("SELECT version(), user(), now() ");
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		//6. ResultSet 처리
		try {
			out.println("<h1>MariaDB version, username, current datetime.</h1>");
			while(rs.next()) {
				String version = rs.getString(1);
				String user = rs.getString(2);
				String now = rs.getString(3);
				out.print("<ul>");
				out.println("<li>Version : " + version + "</li>");
				out.println("<li>User : " + user + "</li>");
				out.println("<li>Now : " + now + "</li>");
				out.println("</ul>");
			}
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		//7. Database Close
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		out.close();
	}
}

