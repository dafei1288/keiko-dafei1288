/** 
* <p>Title: 安全套接口</p> 
* 
* <p>Description: 手套的全全套适配器</p> 
* 
* <p>Copyright: Copyright fly78.net(c) 2008</p> 
* 
* <p>Company: dafei1288@fly78.net</p> 
* 
* @author dafei1288
* @version 1.0 
*/ 
package net.fly78.designpattern.safetytools;

import net.fly78.designpattern.othertools.Glove;

/**
 * 手套改装成安全套
 * */
public class CondomAdpter implements Condom {
	private Glove glove;
	/**
	 * 设置手套
	 * */
	public void setGlove(Glove glove){
		this.glove = glove;
	}
	
	/**
	 * 使用手套安全套
	 * */
	public void use() {
		this.glove.wear();
		System.out.println("改造成Dulex....");
	}

}
