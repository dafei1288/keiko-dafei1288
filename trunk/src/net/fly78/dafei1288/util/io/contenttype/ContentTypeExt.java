package net.fly78.dafei1288.util.io.contenttype;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;

import net.fly78.dafei1288.util.io.FileUtilsExt;

public class ContentTypeExt {
	
	public static String FILE = "/net/fly78/dafei1288/util/io/contenttype/typeDic";
	
	private static ContentTypeExt cte;
	private static Properties p;
	
	private Hashtable<String,String> _hs; 
	
	private ContentTypeExt() throws IOException{
		p = new Properties();
		p.load(this.getClass().getResourceAsStream(FILE));
		_hs = new Hashtable<String,String>();
		Enumeration em = p.keys();
		while(em.hasMoreElements()){
			String key = (String) em.nextElement();
			_hs.put(key, p.getProperty(key));
		}
	
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
	
	
	public String getHContentType(String key){
		return _hs.get(key);
	}
	
	
	public String getHContentType(File f){
		return _hs.get(FileUtilsExt.getFileExtensionName(f));
	}
	
	public String getHContentTypeFromPath(String path){
		File f = new File(path);
		return this.getHContentType(f);
	}
	
	
	
	public static void main(String[] args){
		long times = 400;
		long start = System.currentTimeMillis();
		for(int i =0;i<times;i++){
			try {
				String res = ContentTypeExt.getInstance().getContentTypeFromPath("aa.xml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("use : "+(System.currentTimeMillis()-start));
		
		start = System.currentTimeMillis();
		for(int i =0;i<times;i++){
			try {
				String res = ContentTypeExt.getInstance().getHContentTypeFromPath("aa.xml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("use H : "+(System.currentTimeMillis()-start));
		
	}
	
}
