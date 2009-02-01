package net.fly78.dafei1288.util.string;

import net.fly78.dafei1288.exception.StringSpiltException;


public class SupString {
	 /**
	  * 转换特殊符号
	  * */
	public static String escapeChar(String str) {
	        return str.replace('<', '＜').replace('>', '＞').replace('&','＆').replace('\'','`').replace('\"','`');
	}
	
	public static String[] spiltString(String str,String split) throws StringSpiltException{
		String res[] = str.split(split);
		if(res.length==1){
			throw new StringSpiltException();
		}
		return res;
	}
	/**
	 * 判断是空或null
	 * */
	public static boolean isNullorEmpty(String str){
		boolean tag = false;
		
		if(str==null||str.equals(null)||str.trim().length()==0){
			tag = true;
		}
		
		return tag;
	}
}
