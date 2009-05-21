/** 
* <p>Title: 性别枚举类</p> 
* 
* <p>Description: 性别枚举类</p> 
* 
* <p>Copyright: Copyright fly78.net(c) 2008</p> 
* 
* <p>Company: dafei1288@fly78.net</p> 
* 
* @author dafei1288
* @version 1.0 
*/ 
package net.fly78.designpattern.ex.human;

public enum Sex {
	/**
	 * 男人
	 * **/
	MALE("男"),
	/**
	 * 女人
	 * **/
	FEMALE("女"),
	/**
	 * 人妖
	 * **/
	SHEMALE("人妖");
	
	private String value;   
	Sex(String value){   
        this.value = value;   
    }
	
    public String toString(){   
	    return this.value;
	}
	
}
