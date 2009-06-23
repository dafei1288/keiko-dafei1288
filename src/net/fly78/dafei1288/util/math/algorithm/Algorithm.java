package net.fly78.dafei1288.util.math.algorithm;

public class Algorithm {
	public static long GCD(long x,long y){
		long remainder = 0l;
		int setp = 0;
		
		System.out.println("#######begin######## ");
		System.out.println( "x = "+x+" y = "+y);
		System.out.println();
		while(y!=0){
			System.out.println("setp ["+ setp++ +"]:  x = "+x+" y = "+y);
			remainder = x%y;
			System.out.println("	===>remainder = "+remainder);
			x=y;
			System.out.println("	===>   x = "+x);
			y=remainder;
			System.out.println("	===>   y = "+y);
		}
		System.out.println();
		System.out.println("#######end######## ");
		return x;
	}
	
	public static long[] extGCD(long N,long D){
		   long x=0, y=1,
		   		u=1, v=0,
		   		a=N, b=D;
		   while (0 != a){
		       long q = (long)(b/a);
		       long r = b%a;
		       long m = x - u*q;
		       long n = y - v*q;
		       b=a; a=r; x=u; y=v; u=m; v=n;
		   }
		   long[] ret = {x, y, b};
		   return ret;
	}
	//x, y, b
	public static long invMOD(long N,long D){
		   long[] ret = extGCD(N,D);
		   if( ret[2] == 1) 
			   return ((ret[0]+D)%D);
		   else
			   return -9999;
	}
}
