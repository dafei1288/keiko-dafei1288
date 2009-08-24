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

import net.fly78.domain.PMF;
import net.fly78.guestbook.domain.GuestBookBean;
import net.fly78.guestbook.domain.ProjectUsers;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;



response.setContentType("text/html");
response.setCharacterEncoding("utf-8");
PrintWriter out = response.getWriter();
PersistenceManager pm = PMF.get().getPersistenceManager();
		
		if(!"chirs".equals(request.getParameter("pwd"))){
			response.sendRedirect("/guest.jsp");
		}
		
		if("insert".equals(request.getParameter("action"))){
			
			
		}else if("checkuser".equals(request.getParameter("action"))){
			
		}else{
			String query = "select from " + GuestBookBean.class.getName() +" where belongid == 1";
			List<GuestBookBean> greetings = (List<GuestBookBean>) pm.newQuery(query).execute();  
			pm.close();
			request.setAttribute("list", greetings);
			request.getRequestDispatcher("/guest.jsp").forward(request, response);
		}