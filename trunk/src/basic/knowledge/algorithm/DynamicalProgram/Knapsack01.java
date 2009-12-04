package basic.knowledge.algorithm.DynamicalProgram;

public class Knapsack01 {

	/**
	 * 
	 * n=5
	 * p=[6,3,5,4,6]
	 * w=[2,2,6,5,4]
	 * c=10
	 * 
	 * */
	
	public int[] bag = {0,0,0,0,0};
	public int cargo = 0;
	
	
	public static final int n=5;
	public static final int c=10;
	public static final int[] p = {6,3,5,4,6};
	public static final int[] w = {2,2,6,5,4};
	
	public int max(int i,int j){
		return i>j?i:j;
	}
	
	
	public int change(int i,int left){
		if(i==n)return (left<w[i-1]?0:p[n-1]);
		if(w[i]>left)return change(i+1,left);
		return max(change(i+1,left),change(i+1,left-w[i])+p[i]);
	}
	
	
	public int action(int bagleft,int index,int[] bagstate){
		return 0;
	}
	
	
	
	public static void main(String[] args) {
		Knapsack01 k = new Knapsack01();
		//int i = k.action(10,0,new int[]{0,0,0,0,0});
		//System.out.println(i);
		int ia = k.change(0, 10);
		System.out.println(ia);
	}

}
