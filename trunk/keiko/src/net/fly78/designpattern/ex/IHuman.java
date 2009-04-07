package net.fly78.designpattern.ex;

import net.fly78.designpattern.ex.human.Sex;

/**
 * 人类接口
 * */
public interface IHuman {

	public void setName(String name);
	public String getName();
	public Sex getSex();
	
	public void play();
	public void ml(IHuman another);
	
}
