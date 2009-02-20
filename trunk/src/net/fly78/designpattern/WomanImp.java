package net.fly78.designpattern;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class WomanImp extends Observable implements IHuman {

	private String name;
	private String sex;
	private int i = 0;
	private ArrayList<IHuman> al;
	@Override
	public void addObserver(Observer o) {
		//super.addObserver(o);
		al.add((IHuman) o);
	}

	@Override
	public void notifyObservers() {
		for(IHuman man:al){
			((ManImp)man).update(this, "....");
		}
	}

	public WomanImp(String name,String sex){
		this.name = name;
		this.sex = sex;
		al = new ArrayList<IHuman>();
	}
	
	public String getName() {
		return name;
	}

	public String getSex() {
		return sex;
	}

	public void ml(IHuman another) {
		System.out.println(this.name+"mling.... 凹....");
		
		if(i++ < 3){
			System.out.println("啊..... 要....");
			another.ml(this);
		}else{
			return;
		}
	}
	
	public void getGift(String gift){
		System.out.println("得到情人节礼物:"+gift);
		this.setChanged();
		this.notifyObservers();
	}
	
	public void play() {
		System.out.println(this.getSex()+"=>"+this.getName()+"正在 娱乐...");
	}
	
	public void setName(String name) {
		this.name = name;
	}


}
