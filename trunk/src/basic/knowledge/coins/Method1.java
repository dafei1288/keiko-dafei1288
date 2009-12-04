package basic.knowledge.coins;

/**
 * 有1元，5元，10元，20元，50元，问组成100元有多少种情况
 * */

public class Method1 {

	static final int[] COINS = {1,5,10,20,50}; 
	static final int SUM = 100;
	public void action(){
		int count = 0;
		for(int i=0;i<=SUM/COINS[0];i++){
			for(int j=0;j<=SUM/COINS[1];j++){
				for(int k=0;k<=SUM/COINS[2];k++){
					for(int l=0;l<=SUM/COINS[3];l++){
						for(int m=0;m<=SUM/COINS[4];m++){
							if((i*COINS[0]+j*COINS[1]+k*COINS[2]+l*COINS[3]+m*COINS[4])==SUM){
								System.out.println("case: "+ ++count +" 1 = "+i +" , 5 =" + j+ " , 10 = "+k+" , 20 = "+ l +" , 50 ="+m);
							}
						}
					}
				}
			}
		}
		System.out.println("total solution : "+ count);
	}
	public static void main(String[] args) {
		new Method1().action();
	}

}
