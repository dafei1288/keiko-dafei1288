package net.fly78.domain;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.fly78.guestbook.domain.ProjectUsers;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class JdoGoogle extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public JdoGoogle() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		PersistenceManager pm = PMF.get().getPersistenceManager();
		if("insert".equals(request.getParameter("action"))){
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String im = request.getParameter("im");
			String brithday = request.getParameter("brithday");
			String url = request.getParameter("url");
			ProjectUsers p = new ProjectUsers(username,password,email,im,brithday,url);
			try {    
				pm.makePersistent(p); 
			} catch(Exception e){
				e.printStackTrace(out);
			}finally { 
				pm.close();   
			}
			
		}else if("checkuser".equals(request.getParameter("action"))){
			
		}else{
			String query = "select from " + ProjectUsers.class.getName();
			List<ProjectUsers> greetings = (List<ProjectUsers>) pm.newQuery(query).execute();  
			if (greetings.isEmpty()) {
				out.write("<p>The ProjectUsers has no messages.</p>"); 
			} else {      
				for (ProjectUsers g : greetings) {
					out.write(g.toString()+"<br />");
				}
			}
			pm.close();
		}
		
		/*
		PersistenceManager pm = PMF.get().getPersistenceManager();  
//		String content = "我爱你"+ new Random().nextInt(); 
//		Date date = new Date();
//		TestBean greeting = new TestBean(user, content, date);   
//		PersistenceManager pm = PMF.get().getPersistenceManager();  
//		try {    
//			pm.makePersistent(greeting); 
//		} catch(Exception e){
//			e.printStackTrace(out);
//		}finally { 
//			pm.close();   
//		}
		pm = PMF.get().getPersistenceManager();
		String query = "select from " + TestBean.class.getName();
		List<TestBean> greetings = (List<TestBean>) pm.newQuery(query).execute();  
		if (greetings.isEmpty()) {
			out.write("<p>The guestbook has no messages.</p>"); 
		} else {      
			for (TestBean g : greetings) {
				out.write(g.toString()+"<br />");
			}
		}
		pm.close();
		*/
//		Enumeration em = request.getParameterNames();
//		while(em.hasMoreElements()){
//			String key = (String) em.nextElement();
//			out.write(" key = "+key+" , value = "+request.getParameter(key)+"<br>");
//		}
		
		
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
