package net.fly78.dafei1288.util.servlet;

import javax.servlet.http.HttpServletRequest;

public class GetRealIpFromRqeuest {
	/**
	 * 取得真实IP
	 * */
	public static String getIpAddr(HttpServletRequest request) {    
	       String ip = request.getHeader("x-forwarded-for");    
	       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {    
	           ip = request.getHeader("Proxy-Client-IP");    
	       }    
	       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {    
	           ip = request.getHeader("WL-Proxy-Client-IP");    
	       }    
	       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {    
	           ip = request.getRemoteAddr();    
	       }    
	       return ip;    
	   }   
}
