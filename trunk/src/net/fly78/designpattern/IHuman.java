package net.fly78.designpattern;
/**
 * 人类接口
 * */
public interface IHuman {

	public void setName(String name);
	public String getName();
	public String getSex();
	
	public void play();
	public void ml(IHuman another);
	
}
