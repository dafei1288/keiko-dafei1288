package net.fly78.dafei1288.game;

public class CyclialTable {
	
	public static class AttrikeCyclial{
		/**
		 * 击空
		 * 0%伤害
		 * */
		public static final int HITAIR = 0;
		
		/**
		 * 未命中
		 * 50%伤害
		 * */
		public static final int HITNOTH = 1;
		
		/**
		 * 普通攻击
		 * 100%伤害
		 * */
		public static final int COMM = 2;
		/**
		 * 重击
		 * 120%伤害
		 * */
		public static final int POWER = 3;
		/**
		 * 爆击
		 * 180%伤害
		 * */
		public static final int BOIL = 4;
		/**
		 * 碾压
		 * 300%伤害
		 * */
		public static final int ROLLER = 5;
	}
	
	public static class DefendCyclial{
		/**
		 * 闪避
		 * 减免攻击80%
		 * */
		public static final int AGILITY = 0;	
		/**
		 * 档格
		 * 减免攻击50%
		 * */
		public static final int DANGGE = 1;		
		/**
		 * 招架
		 * 减免攻击20%
		 * */
		public static final int ZHAOJIA= 2;		
		/**
		 * 击中
		 * 减免攻击0%
		 * */
		public static final int HIT = 3;		
		/**
		 * 反伤
		 * 减免攻击0% 但反馈20%伤害
		 * */
		public static final int REHIT = 4;		
		
	}
	
}
