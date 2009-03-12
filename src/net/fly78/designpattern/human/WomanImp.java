package net.fly78.designpattern.human;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import net.fly78.designpattern.IHuman;

public class WomanImp extends Observable implements IHuman {

	private String name;
	private Sex sex;
	private int i = 0;
	private ArrayList<IHuman> al;
	@Override
	public void addObserver(Observer o) {
		al.add((IHuman) o);
	}

	@Override
	public void notifyObservers() {
		for(IHuman man:al){
			((ManImp)man).update(this, "....");
		}
	}

	public WomanImp(String name,Sex sex){
		this.name = name;
		this.sex = sex;
		al = new ArrayList<IHuman>();
	}
	
	public String getName() {
		return name;
	}

	public Sex getSex() {
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
	@Override
	public String toString(){
		return new StringBuilder().append("[ 姓名：").append(this.name).append(" , 性别 ： ").append(this.sex).append("  ]").toString();
	}

}
