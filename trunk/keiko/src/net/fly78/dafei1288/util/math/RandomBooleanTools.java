package net.fly78.dafei1288.util.math;

public class RandomBooleanTools {
	
	private Integer truthPower = 1;
	private Integer falsePower = 1;
	private RandomPOJO truthPOJO;
	private RandomPOJO falsePOJO;
	private RandomAction ra;
	private RandomPOJOList rpl;
	public Integer getTruthPower() {
		return truthPower;
	}

	public void setTruthPower(Integer truthPower) {
		this.init(truthPower, this.falsePower);
	}

	public Integer getFalsePower() {
		return falsePower;
	}

	public void setFalsePower(Integer falsePower) {
		this.init(this.truthPower, falsePower);
	}
	
	public RandomBooleanTools(Integer truthPower,Integer falsePower){
		this.init(truthPower, falsePower);
	}
	
	private void init(Integer truthPower,Integer falsePower){
		this.truthPower = truthPower;
		this.falsePower = falsePower;
		falsePOJO = new RandomPOJO();
		falsePOJO.setProperty(false);
		falsePOJO.setPower(falsePower);
		
		truthPOJO = new RandomPOJO();
		truthPOJO.setProperty(true);
		truthPOJO.setPower(truthPower);
		
		rpl = new RandomPOJOList();
		rpl.add(truthPOJO);
		rpl.add(falsePOJO);
		
		ra = new RandomAction(rpl);
	}
	
	public boolean getNextBoolean(){
		return (Boolean)ra.getNext().getProperty();
	}
}
