/**
 * net.fly78
 * 
 * @author dafei1288
 *
 * @version 2009/Jul 8, 2009/1:11:01 PM
 */
package net.fly78;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.logging.Logger;
import javax.servlet.http.*;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CrossWall extends HttpServlet {
	// private static final Logger log = Logger.getLogger(CrossWall.class
	// .getName());
	//
	// public void doPost(HttpServletRequest req, HttpServletResponse resp)
	// throws IOException {
	// PrintWriter out = resp.getWriter();
	// out.write(req.getParameter("path"));
	// out.write("dafei1288<br />dddd");
	// try{
	//		
	//
	// HttpClient httpClient = new HttpClient();
	// //创建GET方法的实例
	// GetMethod getMethod = new GetMethod(req.getParameter("path"));
	// //使用系统提供的默认的恢复策略
	// getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
	// new DefaultHttpMethodRetryHandler());
	// try {
	// //执行getMethod
	// int statusCode = httpClient.executeMethod(getMethod);
	// if (statusCode != HttpStatus.SC_OK) {
	// out.write("Method failed: " + getMethod.getStatusLine());
	// }
	// //读取内容
	// byte[] responseBody = getMethod.getResponseBody();
	// //处理内容
	// out.write(new String(responseBody));
	// } catch (HttpException e) {
	// //发生致命的异常，可能是协议不对或者返回的内容有问题
	// out.write("Please check your provided http address!");
	// e.printStackTrace();
	// } catch (IOException e) {
	// //发生网络异常
	// e.printStackTrace(out);
	// } finally {
	// //释放连接
	// getMethod.releaseConnection();
	//
	// }
	// }catch(Throwable e){
	// e.printStackTrace(out);
	// }
	// }

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		PrintWriter out = resp.getWriter();
		out.write("dafei's simple example! :)  u want to cross to => "+req.getParameter("path")+"<br />");
		try {
			URL url = new URL(req.getParameter("path"));
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					url.openStream()));
			StringBuffer sb = new StringBuffer();
			String line = "";
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			out.write(line==null?"no message":line);
			out.write(sb.toString());
			reader.close();
		} catch (MalformedURLException e) {
			e.printStackTrace(out);
		} catch (IOException e) {
			e.printStackTrace(out);
		}catch(Throwable e){
			e.printStackTrace(out);
		}finally{
			out.flush();
			out.close();
		}
	}

}
