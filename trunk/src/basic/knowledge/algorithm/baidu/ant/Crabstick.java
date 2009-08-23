package basic.knowledge.algorithm.baidu.ant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Crabstick {
	public static int rightEdge = 27;//右边界
	public static int leftEdge = 0;//左边界


	public static void main(String[] args){
		
		System.out.println("题目描述: 有一根27厘米的细木杆，在第3厘米、7厘米、11厘米、17厘米、23厘米这五个位置上各有一只蚂蚁。木杆很细，不能同时通过一只蚂蚁。开始时，蚂蚁的头朝左还是朝右是任意的，它们只会朝前走或调头，但不会后退。当任意两只蚂蚁碰头时，两只蚂蚁会同时调头朝反方向走。假设蚂蚁们每秒钟可以走一厘米的距离。编写程序，求所有蚂蚁都离开木杆的最小时间和最大时间。 ");
		
		List<List<Ant>> antsList = creatLists(3, 7, 11, 17, 23);   
		
		System.out.println(antsList);
        
		List<Integer> times = new ArrayList<Integer>();   
        
        for (List<Ant> ants : antsList) {   
        	System.out.println(ants);
            int time = 0;   
  
            while (ants.size() > 0) {   
                for (Ant ant : ants) {   
                    ant.go();   
                }   
  
                List<Ant> removed = new ArrayList<Ant>();   
                for (Ant ant : ants) {   
                    int location = ant.getPosition();   
                    if (location <=  leftEdge || location >= rightEdge) {   
                        removed.add(ant);   
                    }   
                }   
                ants.removeAll(removed);   
  
                for (int i = 0; i < ants.size() - 1; i++) {   
                    Ant leftAnt = ants.get(i);   
                    Ant rightAnt = ants.get(i + 1);   
                    if (leftAnt.getPosition() >= rightAnt.getPosition()) {   
                        leftAnt.turn();   
                        rightAnt.turn();   
                    }   
                }   
  
                time++;   
            }   
  
            times.add(time);   
            System.out.println("time==>"+time);
        }   
  
        System.out.println("Max: " + Collections.max(times));   
        System.out.println("Min: " + Collections.min(times));   

		//System.out.println(times);
		
	}
	
	
	public static List<List<Ant>> creatLists(int...pos){
		
		int num = pos.length; //蚂蚁只数
		int times = (int) Math.pow(2, num);
		List<List<Ant>> list = new ArrayList<List<Ant>>();
		//所有情况 的蚂蚁问题
		// 0 0 0 0 0 
		
		for(int i=0;i<times;i++){
			List<Ant> sublist = new ArrayList<Ant>();
			String seq = toBinaryString(i, num);   
			for (int j = 0; j < num; j++) {   
                int location = pos[j];   
                
                int direction = Integer.parseInt(""+seq.charAt(j)) == Ant.FACE_RIGHT ? Ant.FACE_RIGHT:Ant.FACE_LEFT;   
                //System.out.println(seq.charAt(j)+"/"+direction);
                sublist.add(new Ant(location, direction));   
            }   

			
			list.add(sublist);
		}
		
		
		return list;
	}

	 private static String toBinaryString(int integer, int length) {   
	        String result = Integer.toBinaryString(integer);   
	        while (result.length() < length) {   
	            result = "0" + result;   
	        }  
	        return result;   
	    }   

	

}
