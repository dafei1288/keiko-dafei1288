package net.fly78.dafei1288.util.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Writer;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

public class RequestProbe {
	private static PrintStream printer = System.out;
	public static boolean isUse = true;
	
	public static void setAppender(PrintStream writer){
		printer =  writer;
	}
	
	
	public static void printHeader(HttpServletRequest request) throws IOException{
		if(!isUse) return;
		printer.println("");
		printer.println("");
		printer.println(net.fly78.dafei1288.util.date.DateOption.data2String(new Date()));
		printer.println(request);
		printer.println("*******************************************************************************************");
		printer.println("Protocol: " + request.getProtocol()); 
		printer.println("Scheme: " + request.getScheme()); 
		printer.println("Server Name: " + request.getServerName() ); 
		printer.println("Server Port: " + request.getServerPort()); 
		printer.println("Protocol: " + request.getProtocol()); 
		//printer.println("Server Info: " + getServletConfig().getServletContext().getServerInfo()); 
		printer.println("Remote Addr: " + request.getRemoteAddr()); 
		printer.println("Remote Host: " + request.getRemoteHost()); 
		printer.println("Character Encoding: " + request.getCharacterEncoding()); 
		printer.println("Content Length: " + request.getContentLength()); 
		printer.println("Content Type: "+ request.getContentType()); 
		printer.println("Auth Type: " + request.getAuthType()); 
		printer.println("HTTP Method: " + request.getMethod()); 
		printer.println("Path Info: " + request.getPathInfo()); 
		printer.println("Path Trans: " + request.getPathTranslated()); 
		printer.println("Query String: " + request.getQueryString()); 
		printer.println("Remote User: " + request.getRemoteUser()); 
		printer.println("Session Id: " + request.getRequestedSessionId()); 
		printer.println("Request URI: " + request.getRequestURI()); 
		printer.println("Servlet Path: " + request.getServletPath()); 
		printer.println("Accept: " + request.getHeader("Accept")); 
		printer.println("Host: " + request.getHeader("Host")); 
		printer.println("Referer : " + request.getHeader("Referer")); 
		printer.println("Accept-Language : " + request.getHeader("Accept-Language")); 
		printer.println("Accept-Encoding : " + request.getHeader("Accept-Encoding")); 
		printer.println("User-Agent : " + request.getHeader("User-Agent")); 
		printer.println("Connection : " + request.getHeader("Connection")); 
		printer.println("Cookie : " + request.getHeader("Cookie")); 
		printer.println("Created : " + request.getSession().getCreationTime()); 
		printer.println("LastAccessed : " +  request.getSession().getLastAccessedTime());
		printer.println("********************************************************************************************");
		printer.println("");
		printer.println("");
	}
	
	public static void printParams(HttpServletRequest request) throws IOException{
		if(!isUse) return;
		
		printer.println("");
		printer.println("");
		printer.println(net.fly78.dafei1288.util.date.DateOption.data2String(new Date()));
		printer.println(request);
		printer.println("*******************************************************************************************");
		Enumeration em = request.getParameterNames();
		while(em.hasMoreElements()){
			String key = (String) em.nextElement();
			printer.println(key+" : "+request.getParameter(key));
		}
		printer.println("********************************************************************************************");
		printer.println("");
		printer.println("");
	}
}
