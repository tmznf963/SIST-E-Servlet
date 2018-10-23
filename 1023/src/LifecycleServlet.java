import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/servlets/servlet/Lifecycle1")
public class LifecycleServlet extends HttpServlet {
	private PrintWriter pw;
	private int initCount = 1;
	private int serviceCount = 1;
	private int destroyCount = 1;

	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
			this.pw = new PrintWriter(new BufferedWriter(new FileWriter(new File("C:/temp/servletlifecycle.txt"))));
			this.pw.println("called init() : "+ initCount++ +"\n");
			this.pw.flush();//내보내기
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		this.pw.println("called service() : " + serviceCount++ + "\n");
		this.pw.flush();//내보내기
		System.out.println(getServletInfo());
	}

	@Override
	public void destroy() {
		this.pw.println("called destroy() : " + destroyCount++ + "\n");
		this.pw.flush();//내보내기
		this.pw.close();//끝내기
	}
}
