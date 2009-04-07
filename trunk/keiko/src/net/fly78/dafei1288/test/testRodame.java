package net.fly78.dafei1288.test;

import junit.framework.TestCase;
import net.fly78.dafei1288.util.math.RandomEx;

public class testRodame  extends TestCase {
	public void testR(){
		//RandomEx.getRandom(objects);
		String[] ri = new String[100];
		for(int i=0;i<100;i++){
			ri[i] = "ab"+i;
		}
		for(int i=0;i<100;i++){
			
			//System.out.println(RandomEx.getRandom(ri).toString());
		}
		System.out.println();
		System.out.println();
		System.out.println();
		Object[] o = RandomEx.getRandomArray(10, ri);
		for(Object ob : o){
			System.out.println((String)ob);
		}
		
	}
}
