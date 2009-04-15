package net.fly78.dafei1288.test;

public class T {
	
	{
		System.out.println("T is running");
	}
	
	public  T(){
		System.out.println("T is loaded");
	}
	
	public void set(){
		System.out.println("set running");
	}
	
	public String geta(String t,int i,int j){
		return t+(i+j);
	}
	public String what(String t,Integer i,Integer l){
		return t+(i+l);
	}
}
