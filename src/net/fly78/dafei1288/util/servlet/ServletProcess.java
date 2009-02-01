package net.fly78.dafei1288.util.servlet;

import java.io.UnsupportedEncodingException;
import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.fly78.dafei1288.exception.ProcessingReq_and_ResException;

public class ServletProcess {
	
	public static Hashtable<String,Object> processing(Object...obj) throws ProcessingReq_and_ResException{
		Hashtable<String,Object> ht = new Hashtable<String,Object>();
		try
		{
			HttpServletRequest hreq ;//= (HttpServletRequest)obj[0];
			HttpServletResponse hres;
			if(obj.length==2){
				hreq = (HttpServletRequest)obj[0];
				hres = (HttpServletResponse)obj[1];
				hreq= ServletProcess.getRequest4Encoding(hreq);
				hres = ServletProcess.getResponse4Encoding(hres);
				ht.put("request", hreq);
				ht.put("response", hres);
			}else if(obj.length == 4){
				String str1 = (String)obj[0];
				hreq = (HttpServletRequest)obj[1];
				String str2 = (String)obj[2];
				hres = (HttpServletResponse)obj[3];
				hreq= ServletProcess.getRequest4Encoding(hreq);
				hres = ServletProcess.getResponse4Encoding(hres);
				ht.put(str1, hreq);
				ht.put(str2, hres);
			}else{
				throw new ProcessingReq_and_ResException();
			}	
		}catch(Exception e){
			throw new ProcessingReq_and_ResException(e);	
		}
		
		return ht;
	}
	
	public static HttpServletRequest getRequest4Encoding(HttpServletRequest request)
    throws UnsupportedEncodingException
    {
	    request.setCharacterEncoding("iso8859-1");
	    return request;
    }

	public static HttpServletResponse getResponse4Encoding(HttpServletResponse response)
	{
	    response.setCharacterEncoding("utf-8");
	    response.setContentType("text/html;charset=utf-8");
	    return response;
	}

	public static String getString4EncodingUTF8(String str)
	    throws UnsupportedEncodingException
	{
	    return new String(str.getBytes("iso8859-1"), "utf-8");
	}

	public HttpServletRequest requestProcessing(HttpServletRequest request,String charset) throws UnsupportedEncodingException{
		request.setCharacterEncoding(charset);
		return request;
	}
	
	public HttpServletResponse responseProcessing(HttpServletResponse response,String charset){
		response.setCharacterEncoding(charset);
		response.setContentType("text/html;charset="+charset+"");
		return response;
	}
	
	
}

