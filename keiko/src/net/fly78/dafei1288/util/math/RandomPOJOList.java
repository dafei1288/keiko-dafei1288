package net.fly78.dafei1288.util.math;

import java.util.ArrayList;
import java.util.List;

public class RandomPOJOList  extends ArrayList{
	
	private List<RandomPOJO> _al;
	private int sumPower = 0;
	private int size = 0;
	public int getSumPower() {
		return sumPower;
	}

	public RandomPOJOList(){
		sumPower = 0;
		size = 0;
		_al = new ArrayList<RandomPOJO>();
	}

	public void add(RandomPOJO pojo){
		_al.add(pojo);
		size++;
		sumPower +=pojo.getPower();
	}
	@Override
	public Object remove(int index){
		sumPower -= _al.get(index).getPower();
		size--;
		return _al.remove(index);
	}
	
	@Override
	public int size(){
		return size;
		
	}
	
	@Override
	public Object get(int index){
		return _al.get(index);
		
	}
	@Override
	public void clear(){
		sumPower = 0;
		_al.clear();
	}
	
}
