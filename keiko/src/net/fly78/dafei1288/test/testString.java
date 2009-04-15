package net.fly78.dafei1288.test;

import java.io.File;

import junit.framework.TestCase;
import net.fly78.dafei1288.util.io.FileUtil;
import net.fly78.dafei1288.util.string.*;
public class testString  extends TestCase{
	public void testSpilt(){
		try{
			//String[] res =SupString.spiltString("", ",");
			;
			System.out.println(SupString.isNullorEmpty(""));
			System.out.println(SupString.isNullorEmpty(null));
			System.out.println(SupString.isNullorEmpty("asdas"));
			System.out.println(SupString.isNullorEmpty("        "));
			System.out.println(SupString.isNullorEmpty("   a"));
			System.out.println(SupString.isNullorEmpty("a    "));
			
			System.out.println();
			System.out.println();
			RandomString rs = new RandomString();
			for(int i=1;i<10;i++){
				System.out.println(i+"   "+rs.getRandomChar()+"");
				
			}
			for(int i=1;i<10;i++){
				System.out.println(i+"   "+rs.getRandomString(i));
				
			}
			File f = new File("c:/tt/eeee/df/aa.htm");
			System.out.println(f.getParent());
			System.out.println(f.getPath());
			FileUtil fu = new FileUtil("c:/tt1/eeee/df/aa.htm");
			fu.setFile(new File("c:/tt1/eeeeasds/df/aa.htm"));
			
			fu.writeContent("asdausdhiuasdhasjd asd\nasdhaisjdha sda\tjasdhas\n\n\n\n\n\n\nn\\iasd");
			fu.addContent("asdausdhiuasdhasjd asd\nasdhaisjdha sda\tasdasdasdku23487if98234938jasdhas\n\n\n\n\n\n\nn\\iasd");
			String res = fu.getContent();
			
			fu.copyFileTo("c:/tt1/eeeeasds/df/aa1.htm");
			
			System.out.println(res);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
