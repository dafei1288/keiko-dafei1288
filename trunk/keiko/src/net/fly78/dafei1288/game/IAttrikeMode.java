/**
 * @author dafei1288
 * 
 * */
package net.fly78.dafei1288.game;
/**
 * 进攻方人物模型
 * */
public interface IAttrikeMode extends IBaseMode {
	/**
	 * 得到进攻方人物模型的当前血量
	 * */
	public int getCurrentBlood();
	/**
	 * 设置进攻方人物模型的当前血量
	 * */
	public void setCurrentBlood(int point);
	
	/**
	 * 得到进攻方人物模型的处理过血量
	 * */
	public int getBlood();
	/**
	 * 设置进攻方人物模型的处理过血量
	 * */
	public void setBlood(int point);
	
	
	/**
	 *设置基础伤害
	 * */
	public void setBreakBace(int point);
	
	
	/**
	 * 取得基础伤害
	 * */
	public int getBreakBace();
	
	
	/**
	 * 攻击点数
	 * */
	public int breaked();
	
	
	/**
	 * 取得攻击状态
	 * */
	public int getAttState();
	
	/**
	 * 设置防御防御状态
	 * */
	public void setAttState(int point);
	
	/**
	 * 设置防守人
	 * */
	public void setDefer(IDefendMode def); 
	
	
	
	/**
	 * 取得进攻人物模型的命中率点数
	 * */
	public int getHitPercentPoint();
	/**
	 * 设置进攻人物模型的命中率点数
	 * */
	public int setHitPercentPoint(int point);
	/**
	 * 命中率是否有效
	 * */
	public boolean isCanHitPercent();
	
	
	/**
	 * 取得进攻人物模型的暴率点数
	 * */
	public int getPowerPoint();
	/**
	 * 设置进攻人物模型的暴率点数
	 * */
	public int setPowerPoint(int point);
	/**
	 * 命中率是否有效
	 * */
	public boolean isCanPower();
	
	
	
	
	
	
	
	
}
