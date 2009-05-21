/**
 * net.fly78.designpattern.state
 * 
 * @author dafei1288
 *
 * @version 2009/Apr 13, 2009/4:05:52 PM
 */
package net.fly78.designpattern.state;

public class WaitForMoneyState implements IState {
	private SaleMachine saleMachine;
	public WaitForMoneyState(SaleMachine saleMachine) {
		this.saleMachine = saleMachine;
	}

	public void insertMoney(int a) {
		System.out.println("投入了"+a+"元");
		saleMachine.setMoney(a);
		saleMachine.setState(saleMachine.getHasm());
	}

	public void payBack() {
		System.out.println("请投币在退钱");
	}

	public void payGallmbe() {
		System.out.println("请投币在要东西");
	}

	public void turnHandle() {
		System.out.println("请投币再拉拉干");
	}
	public String toString(){
		return "等待投笔状态";
	}
}
