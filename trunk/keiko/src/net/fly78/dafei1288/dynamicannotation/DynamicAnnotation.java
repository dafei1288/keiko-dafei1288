package net.fly78.dafei1288.dynamicannotation;

import java.io.IOException;
import java.io.InputStream;
@Deprecated
public class DynamicAnnotation {
	@Deprecated
	public  String S() throws IOException {   
		  StackTraceElement element = new RuntimeException().getStackTrace()[1];   
		  String name = element.getClassName().replace('.', '/') + ".java";   
		  System.out.println(name);
		  InputStream in =this.getClass().getResourceAsStream(name);//.getClassLoader().getResourceAsStream(name);   
		  
		  byte[] b = new byte[1024];
		  int i = 0;;
		  StringBuffer sb = new StringBuffer();
		  while((i=in.read(b))!=-1){
			  sb.append(b);
		  }
		  
		  String s = sb.toString();//convertStreamToString(in, element.getLineNumber());   
		  return s.substring(s.indexOf("/*")+2, s.indexOf("*/"));   
		}  
	public static void main(String[] args) {
		 try {
			 DynamicAnnotation da = new DynamicAnnotation();
			System.out.println(da.S(/*  
					    Wow, we finally have  
					    multiline strings in  
					    Java! HOOO!*/));
		} catch (IOException e) {
			e.printStackTrace();
		}    

	}

}
