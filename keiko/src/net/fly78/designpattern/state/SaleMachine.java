/**
 * net.fly78.designpattern.state
 * 
 * @author dafei1288
 *
 * @version 2009/Apr 13, 2009/4:25:54 PM
 */
package net.fly78.designpattern.state;

public class SaleMachine {
	
	private IState hasm = new HasMoneyState(this);
	private IState wait4m = new WaitForMoneyState(this);
	private IState soldou = new SoldOutState(this);
	private IState sold = new SoldState(this);
	
	private IState state = soldou;
	private int count = 0;
	private int money = 0;
	
	
	public void setState(IState state){
		this.state = state;
	}
	public IState getState(){
		return this.state;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public IState getHasm() {
		return hasm;
	}
	public IState getWait4m() {
		return wait4m;
	}
	public IState getSoldou() {
		return soldou;
	}
	public IState getSold() {
		return sold;
	}
	public SaleMachine(int count){
		if(count > 0){
			this.count = count;
			this.state = this.wait4m;
		}
	}
	
	

	public void insertMoney(int a) {
		this.money = a;
		this.state.insertMoney(a);
	}

	public void payBack() {
		this.state.payBack();
	}

	public void payGallmbe() {
		this.state.payGallmbe();
	}

	public void turnHandle() {
		this.state.turnHandle();
	}
	
	
	
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	public String toString(){
		return "自动售货机"+this.hashCode()+"号 | 现在还有货物 ："+this.count+"个 | 货柜状态： "+this.state;
	}
	
	
	public static void main(String[] args) {
		SaleMachine s =	new SaleMachine(2);
		System.out.println(s);
		
		s.payBack();
		
		System.out.println(s);
		
		s.turnHandle();
		System.out.println(s);
		
		s.insertMoney(10);
		s.insertMoney(10);
		s.insertMoney(10);
		System.out.println(s);
		
		s.turnHandle();
		System.out.println(s);
		
		s.payGallmbe();
		System.out.println(s);
		
		s.insertMoney(10);
		s.turnHandle();
		s.payBack();
		System.out.println(s);
		s.insertMoney(10);
		s.turnHandle();
		s.payGallmbe();
		System.out.println(s);

		s.insertMoney(10);
		s.turnHandle();
		s.payGallmbe();
		System.out.println(s);
		
		s.insertMoney(10);
		s.turnHandle();
		s.payGallmbe();
		System.out.println(s);
		
		s.insertMoney(10);
		s.turnHandle();
		s.payGallmbe();
		System.out.println(s);
	}
}
