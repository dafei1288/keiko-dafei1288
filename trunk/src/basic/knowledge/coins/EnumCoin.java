package basic.knowledge.coins;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class EnumCoin { 
    private static final int[] COINS = new int[]{1,5,10,20,50}; 
    private static final int SUM = 100; 
    private static int i=1; 
    public static void main(String[] args) throws FileNotFoundException{ 
//        File output  = new File("C:\\1.out"); 
//        System.setOut(new PrintStream(output)); 
        calc(0, 0, ""); 
        System.out.println("totally "+ (i-1)+ " solutions."); 
    } 

    private static void calc(int sum, int cionIdex, String pre) { 
        if(SUM==sum){ 
            System.out.println("case "+(i++)+ ": " +pre); 
        } 
        for(int i=cionIdex;i<COINS.length; i++){ 
            if(SUM - sum >= 0){ 
                calc(sum+COINS[i],i, pre+" "+ COINS[i]); 
            } 
        } 
    } 
}