package net.fly78.designpattern.human;

import net.fly78.designpattern.IHuman;

public class SendGift implements LoveState {

	public void changeState(IHuman human) {
		System.out.println("赠送礼物状态");
	}

	public void handle(IHuman human) {
		System.out.println("赠送礼物状态");
	}

}
