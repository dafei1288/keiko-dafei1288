package net.fly78.dafei1288.util.math.algorithm;

import java.math.BigInteger;

import org.apache.log4j.Logger;

public class Algorithm {
	private static Logger log = Logger.getLogger(Algorithm.class);
	public static long GCD(long x,long y){
		long remainder = 0l;
		int setp = 0;
		
		log.debug("#######begin######## ");
		log.debug( "x = "+x+" y = "+y);
		log.debug("");
		
		while(y!=0){
			log.debug("setp ["+ setp++ +"]:  x = "+x+" y = "+y);
		
			remainder = x%y;
			
			log.debug("	===>remainder =( x % y ) = "+remainder);
			
			x=y;
			
			log.debug("	===>   x = y = "+x);
			
			y=remainder;
			
			log.debug("	===>   y = remainder = "+y);
		}
		
		log.debug("");
		log.debug("#######end######## ");
		
		return x;
	}
	
	public static long[] extGCD(long N,long D){
		   long x=0, y=1,
		   		u=1, v=0,
		   		a=N, b=D;
		  
		   log.debug("#######begin######## ");
		   log.debug( "x = "+x+" y = "+y);
		   log.debug( "u = "+u+" v = "+v);
		   log.debug( "a = "+a+" b = "+b);
		   log.debug("");
		   
		   int setp = 0;
		   while (0 != a){
			   
			   log.debug("setp ["+ setp++ +"]:  x = "+x+" y = "+y+" u = "+u+" v = "+v+"a = "+a+" b = "+b);
		       
			   long q = (long)(b/a);
		       
			   log.debug(" ===> q = (b/a) = "+q);
		       
			   long r = b%a;
		       
			   log.debug(" ===> r = (b%a)  = "+r);
		       
			   long m = x - u*q;
		       
			   log.debug(" ===> m = (x - u*q) = "+m);
		       
			   long n = y - v*q;
		       
			   log.debug(" ===> n = ( y - v*q) = "+n);
		       
			   b=a; a=r; x=u; y=v; u=m; v=n;
		       
			   log.debug(" b=a; a=r; x=u; y=v; u=m; v=n ;");
			   log.debug(" ===> x = "+x+" y = "+y+" b = "+b);
		   }
		   log.debug("");
		   log.debug("#######end######## ");

		   long[] ret = {x, y, b};
		   return ret;
	}
	//x, y, b
	public static long invMOD(long N,long D){
		   long[] ret = extGCD(N,D);
		   if( ret[2] == 1) 
			   return ((ret[0]+D)%D);
		   else
			   throw new NoneInvMODException();
	}
	
	
	public static class NoneInvMODException extends RuntimeException{
		public  static final String ERRORMESSAGE = "none InvMOD for the params...";
		public NoneInvMODException() {
			super(ERRORMESSAGE);
		}

		public NoneInvMODException(String arg0, Throwable arg1) {
			super(ERRORMESSAGE, arg1);
		}

		public NoneInvMODException(String arg0) {
			super(arg0);
		}

		public NoneInvMODException(Throwable arg0) {
			super(arg0);
		}
		
	}
}
