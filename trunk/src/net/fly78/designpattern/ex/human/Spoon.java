package net.fly78.designpattern.ex.human;

import net.fly78.designpattern.ex.IHuman;

public class Spoon implements LoveState {

	public void changeState(IHuman human) {
		System.out.println("调情状态状态");
	}

	public void handle(IHuman human) {
		System.out.println("调情状态状态");
	}

}
