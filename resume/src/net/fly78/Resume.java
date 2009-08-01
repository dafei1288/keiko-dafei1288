package net.fly78;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Resume extends HttpServlet {

	public Resume() {
		super();
	}
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		try{
			
			String language = request.getParameter("lang")==null?"":request.getParameter("lang");
//			Locale local = new Locale(language);
//			
//			ResourceBundle sys_resource = ResourceBundle.getBundle("sys_messages",local);
//			ResourceBundle user_resource = ResourceBundle.getBundle("user_messages",local);
//			
//			request.setAttribute("sys_resource", sys_resource);
//			request.setAttribute("user_resource", user_resource);
			
			if("en".equals(language)){
				request.getRequestDispatcher("/resume_en.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("/resume_zh.jsp").forward(request, response);
			}
			
			
		}catch(Exception e){
			e.printStackTrace(out);
			e.printStackTrace();
			request.getRequestDispatcher("/resume.htm").forward(request, response);
		}finally{
			out.flush();
			out.close();
		}
		
	}

	public void init() throws ServletException {
	}

}
