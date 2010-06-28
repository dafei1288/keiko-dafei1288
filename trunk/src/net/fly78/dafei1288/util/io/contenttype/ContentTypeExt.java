package net.fly78.dafei1288.util.io.contenttype;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import net.fly78.dafei1288.util.io.FileUtilsExt;

public class ContentTypeExt {
	
	public static String FILE = "/net/fly78/dafei1288/util/io/contenttype/typeDic";
	
	private static ContentTypeExt cte;
	private static Properties p;
	
	private ContentTypeExt() throws IOException{
		p = new Properties();
		p.load(this.getClass().getResourceAsStream(FILE));
	}
	
	public static synchronized ContentTypeExt getInstance() throws IOException{
		synchronized(FILE){
			if(cte ==null){
				cte = new ContentTypeExt();
			}
		}
		return cte;
	}
	
	
	public String getContentType(String key){
		return p.getProperty(key);
	}
	
	
	public String getContentType(File f){
		return p.getProperty(FileUtilsExt.getFileExtensionName(f));
	}
	
	public String getContentTypeFromPath(String path){
		File f = new File(path);
		return this.getContentType(f);
	}
	
	
	
	
	
	
	public static void main(String[] args){
		try {
			String res = ContentTypeExt.getInstance().getContentTypeFromPath("aa.xml");
			System.out.println(res);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
