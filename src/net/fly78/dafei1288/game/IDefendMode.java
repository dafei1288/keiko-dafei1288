/**
 * @author dafei1288
 * 
 * */
package net.fly78.dafei1288.game;
/**
 * 防守方人物模型
 * */
public interface IDefendMode extends IBaseMode{
	/**
	 * 得到防守方人物模型的当前血量
	 * */
	public int getCurrentBlood();
	/**
	 * 设置防守方人物模型的当前血量
	 * */
	public void setCurrentBlood(int point);
	
	
	/**
	 * 得到防守方人物模型的处理过血量
	 * */
	public int getBlood();
	/**
	 * 设置防守方人物模型的处理过血量
	 * */
	public void setBlood(int point);
	
	
	/**
	 * 被伤害点数
	 * */
	public int hadBreak();
	
	
	
	
	/**
	 * 取得防御状态
	 * */
	public int getDefState();
	
	/**
	 * 设置防御防御状态
	 * */
	public void setDefStete(int point);
	
	
	/**
	 * 设置进攻人
	 * */
	public void setAtter(IAttrikeMode att); 
	
	
	
	
	
	
	/**
	 * 得到防守点数
	 * */
	public int getDefentPoint();
	
	/**
	 * 设置防守点数
	 * */
	public void setDefentPoint(int point);
	
	/**
	 * 得到是不是能防守
	 * */
	public boolean isCanDefent();
	
	
	
	
	
	
	
	
	
	/**
	 * 得到闪避点数
	 * */
	public int getAgilityPoint();

	/**
	 * 设置闪避点数
	 * */
	public void setAgilityPoint(int point);
	/**
	 * 得到是不是能闪避
	 * */
	public boolean isCanAgility();
	
	
	
	
	
	
	/**
	 * 得到反伤点数
	 * */
	public int getRehitPoint();
	
	/**
	 * 设置反伤点数
	 * */
	public void setRehitPoint(int point);
	
	/**
	 * 得到是不是能反伤
	 * */
	public boolean isCanRehit();
	
	
}
