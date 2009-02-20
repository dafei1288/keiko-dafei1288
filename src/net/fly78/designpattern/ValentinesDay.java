package net.fly78.designpattern;

public class ValentinesDay {
	public static void main(String[] args) {
		ManImp man = new ManImp("小C","男人");
		WomanImp women = new WomanImp("2008","女人");
		System.out.println(man.getName()+"和"+women.getName()+"一起过情人节...");
		women.addObserver(man);
		man.sentGift(women, "玫瑰");
	}

}
