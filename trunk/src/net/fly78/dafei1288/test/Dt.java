/**
 * net.fly78.dafei1288.test
 * 
 * @author dafei1288
 *
 * @version 2009/Apr 2, 2009/7:22:47 PM
 */
package net.fly78.dafei1288.test;

public class Dt {
	
	private int drucked = 0;
	private int spent = 0;
	private int duz = 0;
	
	public int getDrucked() {
		return drucked;
	}

	
	public int getDuz() {
		return duz*3+drucked;
	}


	public void setDuz(int duz) {
		this.duz = duz;
	}


	public void setDrucked() {
		this.drucked++;
		this.spent+=5;
		System.out.println("喝了1瓶");
		if(drucked%3==0){
			this.duz++;
			this.drucked = 1;
			System.out.println("赠送1瓶");
			//this.spent+=5;
		}else{
			
		}
		
	}


	public int getSpent() {
		return spent;
	}


	public void setSpent(int spent) {
		this.spent = spent;
	}


	public static void main(String [] arg){
		int PERCENT = 3;
		int MAXBOTTLE = 5;
		int PRICE = 5;
		System.out.println("总共买 "+MAXBOTTLE+"单价："+PRICE);
		
		Dt d = new Dt();
		for(int i=1;i<=MAXBOTTLE&&d.getDuz()<=MAXBOTTLE;i++){
			d.setDrucked();
		}
		System.out.println("共喝"+d.getDuz()+"花了："+d.getSpent()+" 赠送了"+d.duz);
	}
}
