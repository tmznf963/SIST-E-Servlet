import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/servlets/servlet/Lifecycle")
public class LifecycleServlet1 extends HttpServlet {
	private int initCount;
	private int serviceCount;
	private int destroyCount;

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("called init() : " + ++initCount); 
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("called service() : " + ++serviceCount);
	}

	@Override
	public void destroy() {
		System.out.println("called destroy() : " + ++destroyCount);
	}
}
