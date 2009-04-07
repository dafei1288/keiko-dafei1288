package net.fly78.dafei1288.util.math;
/**
 * @author dafei1288
 * */
public class RandomPOJO {
	
	private Object property;
	private int power;
	@Deprecated
	private int rank;
	private boolean zero = false;
	
	
	public static final int ISUSE = 1000;
	public static final int ISNOTUSE = 0;
	
	
	private static RandomPOJO _rp = null ;
	public static final RandomPOJO getZERORandomPOJO(){
		if(_rp==null){
			_rp = new RandomPOJO();
			_rp.setPower(0);
			_rp.setProperty(0);
			_rp.setRank(0);
			_rp.setZero(true);
			
		}
		return _rp;
	}
	
	
	
	
	/**
	 * 取得属性值
	 * */
	public Object getProperty() {
		return property;
	}
	
	/**
	 * 设置属性值
	 * @param Object 属性值
	 * */
	public void setProperty(Object property) {
		this.property = property;
	}
	
	
	/**
	 * 取得权重
	 * */
	public int getPower() {
		return power;
	}
	
	/**
	 * 设置权重
	 * @param int 权重整数范围
	 * */
	public void setPower(int power) {
		this.power = power;
	}
	
	/**
	 * 设置权重
	 * @param float 权重整数范围 精确到  千分之一
	 * */
	public void setPower(float power) {
		this.power = (int)power*1000;
	}
	
	/**
	 * 属性出来的概率
	 * @return int  /1000 为实际概率
	 * */
	public int getRank() {
		return rank;
	}
	/**
	 * 设置属性出来的概率
	 * @param int isUser/1000 
	 * @deprecated
	 * */
	@Deprecated
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	/**
	 * 设置属性出来的概率
	 * @param float isUser 精确到  千分之一
	 * 
	 * */
	@Deprecated
	public void setRank(float rank) {
		this.rank = (int)rank*1000;
	}



	/**
	 * 是不是空属性
	 * */
	public boolean isZero() {
		return zero;
	}



	/***
	 * 设置是不是空属性
	 * @param boolean
	 * */
	public void setZero(boolean zero) {
		this.zero = zero;
	}
	
	
}
