package net.fly78.designpattern;
/**
 * 手套改装成安全套
 * */
public class CondomAdpter implements Condom {
	private Glove glove;
	public void setGlove(Glove glove){
		this.glove = glove;
	}
	public void use() {
		this.glove.wear();
		System.out.println("改造成Dulex....");
	}

}
