package net.fly78.dafei1288.test;

import net.fly78.dafei1288.util.math.algorithm.Algorithm;

public class testA {
	public static void main(String[] args){
//		int a = 11;
//		int b = 44;
//		System.out.println(Algorithm.GCD(a,b));
//		//GCD(2322, 654), GCD(36, 54), GCD(11, 10), GCD(18, 12), GCD(36, 54), GCD(55, 22),
//		System.out.println("GCD(2322, 654)= "+Algorithm.GCD(2322, 654));
//		System.out.println("GCD(36, 54)= "+Algorithm.GCD(36, 54));
//		System.out.println("GCD(11, 10)= "+Algorithm.GCD(11, 10));
//		System.out.println("GCD(18, 12)= "+Algorithm.GCD(18, 12));
//		System.out.println("GCD(36, 54)= "+Algorithm.GCD(36, 54));
//		System.out.println("GCD(36, 54)= "+Algorithm.GCD(55, 22));
		//GCD(1970, 1066)
		//System.out.println("GCD(1970, 1066)= "+Algorithm.GCD(1970, 1066));
		long [] a = Algorithm.extGCD(3l, 26);
//		System.out.println(a[0]+" / "+a[1]+" / "+a[2]);
		System.out.println(Algorithm.invMOD(550 , 1759 ));
	}
}
