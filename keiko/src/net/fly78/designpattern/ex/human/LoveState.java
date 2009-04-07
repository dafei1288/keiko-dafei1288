package net.fly78.designpattern.ex.human;

import net.fly78.designpattern.ex.IHuman;

public interface LoveState {
	public void changeState(IHuman human);
	public void handle(IHuman human);
}
