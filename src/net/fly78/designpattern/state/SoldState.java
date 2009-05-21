/**
 * net.fly78.designpattern.state
 * 
 * @author dafei1288
 *
 * @version 2009/Apr 13, 2009/4:14:21 PM
 */
package net.fly78.designpattern.state;

public class SoldState implements IState {
	private SaleMachine saleMachine;
	public SoldState(SaleMachine saleMachine) {
		this.saleMachine = saleMachine;
	}

	public void insertMoney(int a) {
		System.out.println("已经支付过钱啦"+a+"元，退还给你");
	}

	public void payBack() {
		System.out.println(saleMachine.getMoney()+"退还给你");
		saleMachine.setMoney(0);
		saleMachine.setState(saleMachine.getWait4m());
	}

	public void payGallmbe() {
		System.out.println("给你东西");
		saleMachine.setCount(saleMachine.getCount()-1);
		
		if(saleMachine.getCount()>0){
			saleMachine.setState(saleMachine.getWait4m());
		}else{
			saleMachine.setState(saleMachine.getSoldou());
		}
		
	}

	public void turnHandle() {
		this.payBack();
	}
	public String toString(){
		return "贩卖状态";
	}
}
