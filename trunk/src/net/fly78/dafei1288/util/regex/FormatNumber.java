package net.fly78.dafei1288.util.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormatNumber {
	public static final String FRONTNUMBER = "^\\d*";
	public static final String ENDNUMBER = "\\d*$";
	public static final String MIDDNUMBER = "\\d*";
	
	
	public static final Pattern FRONTPATTERN = Pattern.compile(FRONTNUMBER);
	public static final Pattern ENDPATTERN = Pattern.compile(ENDNUMBER);
	public static final Pattern MIDDPATTERN = Pattern.compile(MIDDNUMBER);
	
	private static Integer processMatcher(Matcher m){
		Integer i = null;
		if(m.find()){
			try{
				i = Integer.valueOf(m.group());
			}catch(NumberFormatException e){
				//TODO some process maybe throw a excpetion .... Orz
				//e.printStackTrace();
			}
		}
		return i;
	}
	
	/**
	 * 从输入字符串中 截取开头的数字
	 * 
	 * @param 输入字符串
	 * 
	 * @return 返回字符串开头的数字，没有返回null
	 * 
	 * */
	public static Integer getFrontNumberFromString(String str) {
		Matcher m=FRONTPATTERN.matcher(str);
		return processMatcher(m);
		
		
	}
	
	/**
	 * 从输入字符串中 截取结尾的数字
	 * 
	 * @param 输入字符串
	 * 
	 * @return 返回字符串结尾的数字，没有返回null
	 * 
	 * */
	public static Integer getBackNumberFromString(String str) {
		Matcher m=ENDPATTERN.matcher(str);
		return processMatcher(m);
		
		
	}
	
	/**
	 * 从输入字符串中 截取所有数字
	 * 
	 * @param 输入字符串
	 * 
	 * @return 返回字符串中所有的数字，没有返回null
	 * 
	 * */
	public static Integer getAllNumberFromString(String str) {
		Matcher m=MIDDPATTERN.matcher(str);
		Integer i = null;
		StringBuffer sb = new StringBuffer();
		while(m.find()){
			sb.append(m.group().trim());
		}
		try{
			i = Integer.valueOf(sb.toString());
		}catch(NumberFormatException e){
			//TODO some process maybe throw a excpetion .... Orz
			//e.printStackTrace();
		}
		return i;
		
		
	}
	
	
	public static void main(String[] args) {
		String[] str = {"aasd23","aaa32sdas","asdas2323asdasd2323","121212asdasd","asdasd","2323","ddd1"};
		
		for(String a : str){
			try{
				System.out.println(a+" ===>"+getAllNumberFromString(a)+"  ");
			}catch(Exception e){
				//e.printStackTrace();
			}
			System.out.println();
		}
		
		
	}
}
