package net.fly78.designpattern.human;

import net.fly78.designpattern.IHuman;

public interface LoveState {
	public void changeState(IHuman human);
	public void handle(IHuman human);
}
