package net.fly78.dafei1288.util.io;

import java.util.Enumeration;
import java.util.ResourceBundle;

public class ConfigResources {
	private String configFile ;
	private ResourceBundle rb;
	public ConfigResources(String configFile){
		this.init(configFile);
	}
	/*
	private void init(){
		this.configFile = configFile;
		//ResourceBundle.clearCache();
		rb = ResourceBundle.getBundle(this.configFile); 
	}*/
	private void init(String configFile){
		this.configFile = configFile;
		//ResourceBundle.clearCache();
		rb = ResourceBundle.getBundle(this.configFile); 
	}
	
	public void setConfigFile(String configFile){
		this.init(configFile);
	}
	
	public String getConfigFile(){
		return this.configFile;
	}
	
	public Enumeration<String> getConfigInfomationKeys(){
		return this.rb.getKeys();
	}
	
	public String getConfigInfomation(String key){
		return this.rb.getString(key);
	}
    
}
