package net.fly78.designpattern.human;
import java.util.Observable;
import java.util.Observer;

import net.fly78.designpattern.IHuman;
import net.fly78.designpattern.othertools.Glove;
import net.fly78.designpattern.othertools.PlasticGlove;
import net.fly78.designpattern.safetytools.Condom;
import net.fly78.designpattern.safetytools.CondomAdpter;
public  class ManImp extends WomanImp  implements Observer  {
	
	private int i = 0;
	
	public ManImp(String name,Sex sex){
		super(name,sex);
	}
	
	public void ml(IHuman another) {
		System.out.println(this.getName()+"mling.... 凸....");
		
		if(i++ < 3){
			another.ml(this);
		}else{
			System.out.println("射.....");
			return;
		}
	}
	
	public void saftMl(Condom condom,IHuman another){
		System.out.println("安全ml...");
		condom.use();
		this.ml(another);
	}
	
	public void sentGift(IHuman another,String gift){
		if(another instanceof WomanImp){
			WomanImp wi = (WomanImp)another;
			wi.getGift(gift);
		}
	}
	
	
	/**
	 * 观察者 更新的方法
	 * */
	public void update(Observable o, Object arg) {
		//if(arg instanceof IHuman){
			if(o instanceof WomanImp){
				WomanImp wi = (WomanImp)o;
				System.out.println(wi.getName()+"...收到 情人节礼物: 想ml了.....");
				//this.ml(wi);
				Glove glove = new PlasticGlove();
				CondomAdpter condomadpter = new CondomAdpter();
				condomadpter.setGlove(glove);
				this.saftMl(condomadpter, wi);
			}else{
				System.out.println("不是女人");
			}
			
			
		/*
		}else{
			System.out.println("不是人");
		}*/
		
	}

}
