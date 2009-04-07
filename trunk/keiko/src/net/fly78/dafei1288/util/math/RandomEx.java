package net.fly78.dafei1288.util.math;

import java.util.Random;


public class RandomEx {
	private static Random _r = new Random();
	public static Object getRandom(Object... objects){
		return objects[_r.nextInt(objects.length)];
	}
	
	public static int getRandom(int t){
		return _r.nextInt(t);
	}
	
	public static Object[] getRandomArray(int count,Object... objects){
		Object[] o = new Object[count];
		for(int t=0;t<count;t++){
			o[t] = RandomEx.getRandom(objects);
		}
		return o;
	}
	
	
	
}
