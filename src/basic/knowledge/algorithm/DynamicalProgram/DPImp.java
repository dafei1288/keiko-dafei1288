package basic.knowledge.algorithm.DynamicalProgram;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class DPImp {
	/**
	 *	 描述 Description   
	 *	 	辰辰是个天资聪颖的孩子，他的梦想是成为世界上最伟大的医师。为此，他想拜附近最有威望的医师为师。医师为了判断他的资质，给他出了一个难题。医师把他带到一个到处都是草药的山洞里对他说：“孩子，这个山洞里有一些不同的草药，采每一株都需要一些时间，每一株也有它自身的价值。我会给你一段时间，在这段时间里，你可以采到一些草药。如果你是一个聪明的孩子，你应该可以让采到的草药的总价值最大。” 
	 *	 	如果你是辰辰，你能完成这个任务吗？
	 *	
	 *	 输入格式 Input Format  
	 *	 	输入的第一行有两个整数T（1 <= T <= 1000）和M（1 <= M <= 100），用一个空格隔开，T代表总共能够用来采药的时间，M代表山洞里的草药的数目。接下来的M行每行包括两个在1到100之间（包括1和100）的整数，分别表示采摘某株草药的时间和这株草药的价值。  
	 *	   
	 *	 输出格式 Output Format  
	 *	 	输出包括一行，这一行只包含一个整数，表示在规定的时间内，可以采到的草药的最大总价值。

	 * e.g:
	 * 
	 * 100 5
	 * 
	 * 77 92
	 * 22 22
	 * 29 87
	 * 50 46
	 * 99 90
	 * 
	 * */
	
	public  int limitTime = 0;
	public  int[][] database;
	public  int count = 0;
	
	public void init(String line){
		String[] lineArray = line.trim().split(" ");
		limitTime = Integer.parseInt(lineArray[0]);
		count = Integer.parseInt(lineArray[1]);
		database = new int[count][2];
	}
	
	public void initDB(String line,int index){
		String[] lineArray = line.split(" ");
		database[index][0]=Integer.parseInt(lineArray[0]);
		database[index][1]=Integer.parseInt(lineArray[1]);             
	}
	
	
	public void getInputFile(String filename){
		try {
		
			File f = new File(filename);
			FileReader fr = new FileReader(f);
			
			BufferedReader br = new BufferedReader(fr);
			String temp = "";
			int i = -1;
			while((temp = br.readLine())!=null){
				//System.out.println(temp);
				
				if(++i==0){
					init(temp);
				}else{
					initDB(temp,i-1);
				}
				//i++;
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void displayAttr(){
		System.out.println("*********************************");
		System.out.println();
		
		System.out.println("limitTime = "+limitTime);
		System.out.println("count = "+count);
		System.out.println();
		
		for(int i=0;i<count;i++){
			System.out.println("per time = " + database[i][0]+"  , pirce = "+database[i][1]);
		}
		
		System.out.println();
		System.out.println("*********************************");
		
	}
	
	
	public void actionDP(){
		
	}
	
	
	
	
	public static void main(String[] args) {
		DPImp p = new DPImp();
		p.getInputFile("C:\\Documents and Settings\\lijiaqi\\Workspaces\\MyEclipse\\keiko\\bin\\basic\\knowledge\\algorithm\\DynamicalProgram\\p.pd");
		p.displayAttr();
		p.actionDP();
	}

}
