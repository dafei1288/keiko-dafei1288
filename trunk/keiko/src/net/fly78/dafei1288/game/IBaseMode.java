/**
 * @author dafei1288
 * 
 * */
package net.fly78.dafei1288.game;
/**
 * 抽象人物模型
 * */
public interface IBaseMode {
	/**
	 * 得到人物模型的当前血量
	 * */
	public int getCurrentBlood();
	
	/**
	 * 设置人物模型的当前血量
	 * */
	public void setCurrentBlood(int point);
	
	/**
	 * 得到人物模型的处理过后血量
	 * */
	public int getBlood();
	
	/**
	 * 设置人物模型的处理过后血量
	 * */
	public void setBlood(int point);
	
}
