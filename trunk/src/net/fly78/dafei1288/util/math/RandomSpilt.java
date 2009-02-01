package net.fly78.dafei1288.util.math;

import java.util.Random;

import net.fly78.dafei1288.exception.FormatRandomSpiltException;

public class RandomSpilt {
	
	private Random r;
	public static final String SPILTLINE = "-"; 
	
	private int firstNum;
	private int secendNum;
	
	
	private void press(String str,String op) throws FormatRandomSpiltException{
		String[] lt = str.split(op);
		
		if(lt.length != 2){
			throw new FormatRandomSpiltException(); 
		}
		
		try{
			firstNum = Integer.parseInt(lt[0]);
			secendNum = Integer.parseInt(lt[1]);
		}catch(Exception e){
			throw new FormatRandomSpiltException(); 
		}
	}
	
	public RandomSpilt(String str,String op) throws FormatRandomSpiltException{
		r = new Random();
		this.press(str, op);
		
	}
	
	
	public void setProessString(String str,String op) throws FormatRandomSpiltException{
		this.press(str, op);
	}
	
	public static String setNums2String(int first,int sec){
		return new StringBuffer().append(first).append(SPILTLINE).append(sec).toString();
	}
	
	public static String setNums2String(int first,int sec,String spilt){
		return new StringBuffer().append(first).append(spilt).append(sec).toString();
	}
	
	public int getNext(){
		int res = 0;
		if(secendNum > firstNum){
			res = r.nextInt(secendNum-firstNum)+firstNum;
		}else{
			res = r.nextInt(firstNum-secendNum)+secendNum;
		}
		return res;
	}

	public Random getRandomSeed() {
		return r;
	}

	public void setRandomSeed(Random r) {
		this.r = r;
	}

	public int getFirstNum() {
		return firstNum;
	}

	public void setFirstNum(int firstNum) {
		this.firstNum = firstNum;
	}

	public int getSecendNum() {
		return secendNum;
	}

	public void setSecendNum(int secendNum) {
		this.secendNum = secendNum;
	}
	
}
