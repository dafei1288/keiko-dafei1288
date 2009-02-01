package net.fly78.dafei1288.util.date;

import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;;

public class DateOption {
	public static Date Add(Date base,int minlater){
		Date d = null;
		Calendar cal = Calendar.getInstance();
		cal.setTime(base);
		long t = cal.getTimeInMillis()+(minlater*60*1000l);
		d= new Date(t);
		return d;
	}
	
	
	public static boolean isBefore(Date start,Date end){
		boolean tag = false;
		Calendar cal = Calendar.getInstance();
		cal.setTime(start);
		long t1 = cal.getTimeInMillis();
		cal.setTime(end);
		long t2 = cal.getTimeInMillis();
		
		if(t1-t2<0){
			tag = true;
		}else{
			tag = false;
		}
		
		return tag;
	}
	
	public static boolean isTheSameDate(Date start,Date end){
		boolean tag = true;
		try{
			Calendar cals = Calendar.getInstance();
			cals.setTime(start);
			Calendar cale= Calendar.getInstance();
			cale.setTime(end);
			
			tag = tag&&(cals.get(Calendar.DAY_OF_MONTH)==cale.get(Calendar.DAY_OF_MONTH));
			tag = tag&&(cals.get(Calendar.MONTH)==cale.get(Calendar.MONTH));
			tag = tag&&(cals.get(Calendar.YEAR)==cale.get(Calendar.YEAR));
		}catch(Exception e){
			tag = false;
		}
		
		return tag;
	}
	
	public static boolean isHoursin(Date start,Date end,int timer){
		boolean tag = true;
		try{
			Calendar cals = Calendar.getInstance();
			cals.setTime(start);
			Calendar cale= Calendar.getInstance();
			cale.setTime(end);
			
			
			//System.out.println("init tag:"+tag);
			tag = tag && (cals.get(Calendar.YEAR)==cale.get(Calendar.YEAR));
			//System.out.println("year tag:"+tag);
			tag = tag && (cals.get(Calendar.MONTH)==cale.get(Calendar.MONTH));
			//System.out.println("month tag:"+tag);
			tag = tag && (cals.get(Calendar.DAY_OF_MONTH)==cale.get(Calendar.DAY_OF_MONTH));
			//System.out.println("day tag:"+tag);
			tag = tag&&(Math.abs(cals.get(Calendar.HOUR_OF_DAY)-cale.get(Calendar.HOUR_OF_DAY))<=timer);
			//System.out.println("result tag:"+tag);
			//tag = (tag&&(Math.abs(cals.get(Calendar.HOUR_OF_DAY)-cale.get(Calendar.HOUR_OF_DAY))<=timer))&&((cals.get(Calendar.MONTH)==cale.get(Calendar.MONTH))||(cals.get(Calendar.YEAR)==cale.get(Calendar.YEAR))||(cals.get(Calendar.DAY_OF_MONTH)==cale.get(Calendar.DAY_OF_MONTH)));
			
			/*
			System.out.println(cals.get(Calendar.HOUR_OF_DAY));
			System.out.println(cale.get(Calendar.HOUR_OF_DAY));
			System.out.println(Math.abs(cals.get(Calendar.HOUR_OF_DAY)-cale.get(Calendar.HOUR_OF_DAY)));
			*/
		}catch(Exception e){
			tag = false;
		}
		
		return tag;
		
	}
	
	public static Date str2Date(String str){
		//yyyy.MM.dd G 'at' HH:mm:ss
		DateFormat df =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		try {
			date = df.parse(str);
		} catch (ParseException e) {
		}
		return date;
	}
	
	public static String data2String(Date date){
		DateFormat df =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(date);
	}
}
