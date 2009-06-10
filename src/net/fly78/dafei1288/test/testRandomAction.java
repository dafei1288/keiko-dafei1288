package net.fly78.dafei1288.test;

import java.util.ArrayList;
import java.util.List;

import net.fly78.dafei1288.exception.FormatRandomSpiltException;
import net.fly78.dafei1288.util.math.RandomAction;
import net.fly78.dafei1288.util.math.RandomPOJO;
import net.fly78.dafei1288.util.math.RandomPOJOList;
import net.fly78.dafei1288.util.math.RandomSpilt;

import junit.framework.TestCase;

public class testRandomAction extends TestCase {
	public void testAction(){
		
		
		
		for(int i=0;i<1000;i++){
			try {
				RandomSpilt rsasdasd = new RandomSpilt("1-3","-");
				System.out.print(rsasdasd.getNext());
			
			} catch (FormatRandomSpiltException e1) {
				e1.printStackTrace();
			} 
			
		}
		Integer ati = new Integer("1");
		System.out.println(ati+11);
		
		long s = System.currentTimeMillis();
		ArrayList<RandomPOJO> al = new ArrayList<RandomPOJO>();
		RandomPOJOList alt = new RandomPOJOList();
		int[] tt = new int[10];
		for(int i = 0;i<10;i++){
			RandomPOJO rp = new RandomPOJO();
			//属性值
			rp.setProperty(i);
			//权重规则
			rp.setPower(i+1);
			alt.add(rp);
			tt[i]=0;
		}
		//System.out.println(alt.size());
		
		RandomAction ra = new RandomAction(alt);
		for(int i=0;i<100000;i++){
			RandomPOJO rt = ra.getNext();
			tt[(Integer)rt.getProperty()]++;
			
		}
		
		
		for(int i =0;i<tt.length;i++){
			System.out.println(i+"出现: "+tt[i]);
		}
		
		System.out.println(System.currentTimeMillis()-s);
		for(int i =0;i<tt.length;i++){
			try {
				RandomSpilt rs = new RandomSpilt("156-300","-");
				System.out.println(rs.getNext());
			} catch (FormatRandomSpiltException e) {
				e.printStackTrace();
			}
		}
		
		
	}
}
