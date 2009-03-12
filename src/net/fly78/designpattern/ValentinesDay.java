package net.fly78.designpattern;

import net.fly78.designpattern.human.ManImp;
import net.fly78.designpattern.human.Sex;
import net.fly78.designpattern.human.WomanImp;

public class ValentinesDay {
	public static void main(String[] args) {
		ManImp man = new ManImp("小C",Sex.MALE);
		WomanImp women = new WomanImp("2008",Sex.FEMALE);
		System.out.println(man+"和"+women+"一起过情人节...");
		women.addObserver(man);
		man.sentGift(women, "玫瑰");
	}

}
