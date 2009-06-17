package net.fly78.dafei1288.test;

import java.util.Calendar;
import java.util.Date;

import net.fly78.dafei1288.util.date.*;
import junit.framework.TestCase;
import java.text.*;
public class testDateUtilBetween extends TestCase {
	public void testDate() throws ParseException{
		try{
			DateFormat sdf =SimpleDateFormat.getDateTimeInstance();
			Date begin =sdf.parse("1999-8-17 1:22:33");
			Date end = sdf.parse("1999-8-17 23:22:32");
			DateUtilBetween dub = 	DateUtilBetween.getInstance(begin, end);
			SimpleDateUtilBetween sd = SimpleDateUtilBetween.getInstance(begin, end);
			System.out.println("**********1");
			System.out.println("这个应该是0....--->"+sd.getRealAllDays());
			
			this.assertEquals(0, sd.getRealAllDays());
			
			System.out.println("**********2");
			begin =sdf.parse("1999-12-31 00:22:33");
			end = sdf.parse("2000-1-1 00:25:32");
			sd = SimpleDateUtilBetween.getInstance(begin, end);
			
			
			System.out.println(sd.getBeginc().get(Calendar.DAY_OF_YEAR));
			System.out.println(sd.getEndc().get(Calendar.DAY_OF_YEAR));
			System.out.println(sd.getRealAllDays());
			
			this.assertEquals(1, sd.getRealAllDays());
			
			
			
			

			System.out.println("**********22");
			begin =sdf.parse("1999-12-31 00:22:33");
			end = sdf.parse("2000-1-1 00:12:32");
			sd = SimpleDateUtilBetween.getInstance(begin, end);
			
			
			System.out.println(sd.getBeginc().get(Calendar.DAY_OF_YEAR));
			System.out.println(sd.getEndc().get(Calendar.DAY_OF_YEAR));
			System.out.println(sd.getRealAllDays());
			
			this.assertEquals(1, sd.getRealAllDays());
			
			
			System.out.println("**********3");
			begin =sdf.parse("1999-12-31 11:22:33");
			end = sdf.parse("2000-2-1 11:22:32");
			sd = SimpleDateUtilBetween.getInstance(begin, end);
			System.out.println(sd.getRealAllDays());
			this.assertEquals(32, sd.getRealAllDays());
			
			
			System.out.println("**********4");
			
			begin =sdf.parse("1999-11-30 23:22:33");
			end = sdf.parse("1999-12-1 11:22:32");
			sd = SimpleDateUtilBetween.getInstance(begin, end);
			System.out.println(sd.getRealAllDays());	
			System.out.println("**********5");
			
			
			begin =sdf.parse("1999-11-1 23:22:33");
			end = sdf.parse("1999-11-3 11:22:32");
			sd = SimpleDateUtilBetween.getInstance(begin, end);
			System.out.println(sd.getRealAllDays());	
			System.out.println("**********6");
			
			
			begin =sdf.parse("1999-11-30 11:22:33");
			end = sdf.parse("1999-12-3 23:22:32");
			sd = SimpleDateUtilBetween.getInstance(begin, end);
			System.out.println(sd.getRealAllDays());	
			System.out.println("**********7");
			
			
			begin =sdf.parse("1999-12-1 11:22:33");
			end = sdf.parse("1999-12-4 23:22:32");
			sd = SimpleDateUtilBetween.getInstance(begin, end);
			System.out.println(sd.getRealAllDays());	
			System.out.println("**********8");
			
			
			
			begin =sdf.parse("1999-12-1 11:22:33");
			end = sdf.parse("1999-12-4 3:22:32");
			sd = SimpleDateUtilBetween.getInstance(begin, end);
			System.out.println(sd.getRealAllDays());	
			System.out.println("**********9");
			
			System.out.println(sd.getDays());
			System.out.println(sd.getHours());
			System.out.println(sd.getMins());
			System.out.println(sd.getSecs());
			System.out.println();
			System.out.println();
			System.out.println(sd.getAllDays());
			System.out.println(sd.getAllHours());
			System.out.println(sd.getAllMins());
			System.out.println(sd.getAllSecs());
			
			System.out.println(sd.isTheSameDay());
			SimpleDateUtilBetween sd1 = SimpleDateUtilBetween.getInstance("1999-8-17 11:22:32", "1999-8-17 11:22:32");
			System.out.println();
			System.out.println();
			System.out.println(sd1.isTheDifferentDay());
			/*
			Date begin =sdf.parse("1999-8-17 11:22:33");
			Date end = sdf.parse("1999-8-17 11:22:32");
			 * */
			SimpleDateUtilBetween sd2 = SimpleDateUtilBetween.getInstance("2008-8-17 2:11:33", "2008-8-19 11:2:34");
			System.out.println(sd2.getBeginc().getTime().toLocaleString());
			System.out.println(sd2.getEndc().getTime().toLocaleString());
			System.out.println();
			System.out.println();
			System.out.println(sd2.getDays());
			System.out.println(sd2.getHours());
			System.out.println(sd2.getMins());
			System.out.println(sd2.getSecs());
			System.out.println();
			System.out.println();
			System.out.println(sd2.getAllDays());
			System.out.println(sd2.getAllHours());
			System.out.println(sd2.getAllMins());
			System.out.println(sd2.getAllSecs());
			System.out.println(sd2.isTheDifferentDay());
			System.out.println();
			System.out.println();
			System.out.println(sd2.between());
			
			//System.out.println(sd2.getUserFild(Calendar.LONG));
			System.out.println(sd2.toString());
			//this.assertEquals(sd2.between()	, sd2.getUserFild(Calendar.LONG));
			
			begin =sdf.parse("1999-12-31 00:22:33");
			end = sdf.parse("1999-12-29 00:22:32");
			sd = SimpleDateUtilBetween.getInstance(begin, end);
			
			
			System.out.println(sd.getBeginc().get(Calendar.DAY_OF_YEAR));
			System.out.println(sd.getEndc().get(Calendar.DAY_OF_YEAR));
			System.out.println(sd.getRealAllDays());
			
			

			begin =sdf.parse("2000-1-1 00:22:33");
			end = sdf.parse("1999-12-29 00:22:32");
			sd = SimpleDateUtilBetween.getInstance(begin, end);
			
			
			System.out.println(sd.getRealAllDays());
			
			begin =sdf.parse("2000-1-1 00:22:33");
			end = sdf.parse("1999-12-29 00:22:36");
			sd = SimpleDateUtilBetween.getInstance(begin, end);
			
			
			System.out.println(sd.getRealAllDays());
		}catch(Exception e){
			e.printStackTrace();
			
		}
		/*
		System.out.println(dub.getDays());
		System.out.println(dub.getHours());
		System.out.println(dub.getMins());
		System.out.println(dub.getSecs());
		*/
		
		
		
		/*
		
		this.assertEquals(2, dub.getHours());
		this.assertEquals(0, dub.getMins());
		this.assertEquals(0, dub.getSecs());
		*/
	}
	
}
