package net.fly78.dafei1288.util.math;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomAction {
	
	private ArrayList<RandomPOJO> alrp;
	private Random _r;
	/**
	 * 取得 随机集合
	 * */
	public List<RandomPOJO> getRandomPOJOList() {
		return alrp;
	}
	/**
	 * 设置 随机集合
	 * */
	public void setRandomPOJOList(ArrayList<RandomPOJO> alrp) {
		this.alrp = alrp==null?new ArrayList<RandomPOJO>():alrp;
	}

	public RandomAction(ArrayList<RandomPOJO> alrp){
		_r = new Random();
		this.alrp = alrp==null?new ArrayList<RandomPOJO>():alrp;
	}
	/**
	 * 取得设置随即属性集合的下一个属性 
	 * */
	public RandomPOJO getNext(){
		RandomPOJO rt = RandomPOJO.getZERORandomPOJO();
		/*
		for(RandomPOJO rpojo:alrp){
			
		}
		*/
		int powersum = 0;
		int randomseed = 0;
		//System.out.println(alrp instanceof RandomPOJOList);
		if(alrp instanceof RandomPOJOList){
			randomseed = ((RandomPOJOList)alrp).getSumPower();
			//System.out.println(randomseed);
		}else{
			for(RandomPOJO rp : alrp){
				randomseed+=rp.getPower();
			}
		}
		
		int rtnum = _r.nextInt(randomseed);
		for(int i=0;i<alrp.size();i++){
			//RandomPOJO ppt_i = alrp.get(i);
			/*
			powersum = 0;
			for(int j=0;j<=i;j++){
				powersum += alrp.get(j).getPower();
			}
			*/
			powersum+=alrp.get(i).getPower();
			if(rtnum<powersum){
				rt = alrp.get(i);
				break;
			}
			
		}
		
		return rt;
	}
	/**
	 * 获得随机数种子
	 * @return Random
	 * */
	public Random getRandomSeed() {
		return _r;
	}
	/**
	 * 设置随机数种子
	 * @param Random
	 * */
	public void setRandomSeed(Random _r) {
		this._r = _r;
	}
}
