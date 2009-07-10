/**
 * net.fly78.dafei1288.util.properties
 * 
 * @author dafei1288
 *
 * @version 2009/Jul 6, 2009/3:49:26 PM
 */
package net.fly78.dafei1288.util.properties;

import java.io.*;
import java.util.*;

/**  
 * java 读取配置（属性）文件    
 * @author dafei1288   
 * dafei1288@gmail.com  
 */
public class EnvironmentConfig {
	static EnvironmentConfig ec;// 创建对象ec   
	private static Hashtable<String, Properties> register = new Hashtable<String, Properties>();// 静态对象初始化[在其它对象之前]   
	private String fileName = "dafei1288.config.properties";
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	private EnvironmentConfig() {
		super();
	}
	
	
	public EnvironmentConfig(String fileName){
		this.fileName = fileName;
	}
	
	/**  
	 * 取得EnvironmentConfig的一个实例  
	 */
	public static EnvironmentConfig getInstance() {
		if (ec == null)
			ec = new EnvironmentConfig();// 创建EnvironmentConfig对象   
		return ec;// 返回EnvironmentConfig对象   
	}

	/**  
	 * 取得EnvironmentConfig的一个实例  
	 */
	public static EnvironmentConfig getInstance(String fileName) {
		ec = EnvironmentConfig.getInstance();
		ec.setFileName(fileName);
		return ec;// 返回EnvironmentConfig对象   
	}
	/**  
	 * 读取配置文件  
	 */
	public Properties getProperties(String fileName) {// 传递配置文件路径   
		InputStream is = null;// 定义输入流is   
		Properties p = null;
		try {
			p = (Properties) register.get(fileName);// 将fileName存于一个HashTable   
			/**  
			 * 如果为空就尝试输入进文件  
			 */
			if (p == null) {
				try {
					is = new FileInputStream(fileName);// 创建输入流   
				} catch (Exception e) {
					if (fileName.startsWith("/"))
						// 用getResourceAsStream()方法用于定位并打开外部文件。   
						is = EnvironmentConfig.class
								.getResourceAsStream(fileName);
					else
						is = EnvironmentConfig.class.getResourceAsStream("/"
								+ fileName);
				}
				p = new Properties();
				p.load(is);// 加载输入流   
				register.put(fileName, p);// 将其存放于HashTable缓存   
				is.close();// 关闭输入流   
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		return p;// 返回Properties对象   
	}
	
	
	/**  
	 * 此处插入方法描述。  
	 */
	public String getPropertyValue(String strKey) {
		return this.getPropertyValue(this.fileName, strKey);
	}
	
	
	
	/**  
	 * 此处插入方法描述。  
	 */
	public String getPropertyValue(String fileName, String strKey) {
		Properties p = getProperties(fileName);
		try {
			return (String) p.getProperty(strKey);
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		return null;
	}
	public static void main(String[] args){
		EnvironmentConfig ec=EnvironmentConfig.getInstance();   
		String driverClassName=ec.getPropertyValue("log4j.appender.A1");  
		System.out.println(driverClassName);
		System.out.println("--------------");
	}
}
