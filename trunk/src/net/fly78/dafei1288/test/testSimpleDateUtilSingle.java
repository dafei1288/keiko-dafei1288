package net.fly78.dafei1288.test;

import java.text.ParseException;

import junit.framework.TestCase;

import net.fly78.dafei1288.util.date.SimpleDateUtilSingle;

public class testSimpleDateUtilSingle extends TestCase  {
	public void testSingle(){
		try {
			/*
			SimpleDateUtilSingle sdus = SimpleDateUtilSingle.getInstance("2008-11-2 12:22:55");
			
			System.out.println(sdus.getDate().toLocaleString());
			
			System.out.println();
			
			System.out.println(sdus.addDate(5).toLocaleString());
			sdus = SimpleDateUtilSingle.getInstance("2008-11-2 12:22:55");
			System.out.println(sdus.addDate(-5).toLocaleString());
			sdus = SimpleDateUtilSingle.getInstance("2008-11-2 12:22:55");
			System.out.println(sdus.addDate(15).toLocaleString());
			sdus = SimpleDateUtilSingle.getInstance("2008-11-2 12:22:55");
			System.out.println(sdus.addDate(35).toLocaleString());
			sdus = SimpleDateUtilSingle.getInstance("2008-11-2 12:22:55");
			System.out.println(sdus.addDate(55).toLocaleString());
			sdus = SimpleDateUtilSingle.getInstance("2008-11-2 12:22:55");
			System.out.println(sdus.addDate(-15).toLocaleString());
			sdus = SimpleDateUtilSingle.getInstance("2008-11-2 12:22:55");
			System.out.println(sdus.addDate(-35).toLocaleString());
			sdus = SimpleDateUtilSingle.getInstance("2008-11-2 12:22:55");
			System.out.println(sdus.addDate(1115).toLocaleString());
			sdus = SimpleDateUtilSingle.getInstance("2008-11-2 12:22:55");
			System.out.println(sdus.addDate(-1115).toLocaleString());
			*/
		/*	
SimpleDateUtilSingle sdus = SimpleDateUtilSingle.getInstance("2008-11-2 12:22:55");
			
			System.out.println(sdus.getDate().toLocaleString());
			
			System.out.println();
			
			System.out.println(sdus.addHour(5).toLocaleString());
			sdus = SimpleDateUtilSingle.getInstance("2008-11-2 12:22:55");
			System.out.println(sdus.addHour(-5).toLocaleString());
			sdus = SimpleDateUtilSingle.getInstance("2008-11-2 12:22:55");
			System.out.println(sdus.addHour(24).toLocaleString());
			sdus = SimpleDateUtilSingle.getInstance("2008-11-2 12:22:55");
			System.out.println(sdus.addHour(-24).toLocaleString());
			sdus = SimpleDateUtilSingle.getInstance("2008-11-2 12:22:55");
			System.out.println(sdus.addHour(55).toLocaleString());
			sdus = SimpleDateUtilSingle.getInstance("2008-11-2 12:22:55");
			System.out.println(sdus.addHour(-15).toLocaleString());
			sdus = SimpleDateUtilSingle.getInstance("2008-11-2 12:22:55");
			System.out.println(sdus.addHour(-35).toLocaleString());
			sdus = SimpleDateUtilSingle.getInstance("2008-11-2 12:22:55");
			System.out.println(sdus.addHour(1115).toLocaleString());
			sdus = SimpleDateUtilSingle.getInstance("2008-11-2 12:22:55");
			System.out.println(sdus.addHour(-1115).toLocaleString());
		*/
			
SimpleDateUtilSingle sdus = SimpleDateUtilSingle.getInstance("2008-11-2 12:22:55");
			
			System.out.println(sdus.getDate().toLocaleString());
			
			System.out.println();
			
			System.out.println(sdus.addMins(5).toLocaleString());
			sdus = SimpleDateUtilSingle.getInstance("2008-11-2 12:22:55");
			System.out.println(sdus.addMins(-5).toLocaleString());
			sdus = SimpleDateUtilSingle.getInstance("2008-11-2 12:22:55");
			System.out.println(sdus.addMins(24).toLocaleString());
			sdus = SimpleDateUtilSingle.getInstance("2008-11-2 12:22:55");
			System.out.println(sdus.addMins(-24).toLocaleString());
			sdus = SimpleDateUtilSingle.getInstance("2008-11-2 12:22:55");
			System.out.println(sdus.addMins(55).toLocaleString());
			sdus = SimpleDateUtilSingle.getInstance("2008-11-2 12:22:55");
			System.out.println(sdus.addMins(-15).toLocaleString());
			sdus = SimpleDateUtilSingle.getInstance("2008-11-2 12:22:55");
			System.out.println(sdus.addMins(-35).toLocaleString());
			sdus = SimpleDateUtilSingle.getInstance("2008-11-2 12:22:55");
			System.out.println(sdus.addMins(1115).toLocaleString());
			sdus = SimpleDateUtilSingle.getInstance("2008-11-2 12:22:55");
			System.out.println(sdus.addMins(-1115).toLocaleString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
