/**
 * net.fly78.designpattern.state
 * 
 * @author dafei1288
 *
 * @version 2009/Apr 13, 2009/4:14:48 PM
 */
package net.fly78.designpattern.state;

public class SoldOutState implements IState {

	private SaleMachine saleMachine;
	public SoldOutState(SaleMachine saleMachine) {
		this.saleMachine = saleMachine;
	}

	public void insertMoney(int a) {
		System.out.println("卖光了。。。。");
		System.out.println("退给你投入的"+a+"元！");
	}

	public void payBack() {
		System.out.println("你投入了"+saleMachine.getMoney()+"退还给你。。。");
		saleMachine.setMoney(0);
	}

	public void payGallmbe() {
		System.out.println("已经卖光了。。。");
	}

	public void turnHandle() {
		System.out.println("卖光了，晃动摇柄也不给你。。。");
	}
	public String toString(){
		return "卖空状态";
	}
}
