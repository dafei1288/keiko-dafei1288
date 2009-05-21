/**
 * net.fly78.designpattern.state
 * 
 * @author dafei1288
 *
 * @version 2009/Apr 9, 2009/12:45:33 PM
 */
package net.fly78.designpattern.state;

public class HasMoneyState implements IState {
	private SaleMachine saleMachine;
	public HasMoneyState(SaleMachine saleMachine) {
		this.saleMachine = saleMachine;
	}

	public void insertMoney(int a) {
		System.out.println("不要重复投币了。。。。"+a+"元退回");
		
	}

	public void payBack() {
		System.out.println(saleMachine.getMoney()+"退回");
		saleMachine.setState(saleMachine.getWait4m());
	}

	public void payGallmbe() {
		System.out.println("拉杆先");
		
	}

	public void turnHandle() {
		saleMachine.setState(saleMachine.getSold());
	}
	public String toString(){
		return "持有硬币状态";
	}
}
