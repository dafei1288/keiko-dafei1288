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
	
	
	public static Date addSecs(Date base,int seclater){
		Date d = null;
		Calendar cal = Calendar.getInstance();
		cal.setTime(base);
		long t = cal.getTimeInMillis()+(seclater*1000l);
		d= new Date(t);
		return d;
	}
	
	public static final String DATEWITHOUTTIME = "%s-%s-%s 00:00:00"; 
	public static Date AddDayWithTime(Date base,int dayslater){
		Date d = null;
		Calendar cal = Calendar.getInstance();
		cal.setTime(base);
		
		//System.out.println(cal.getTimeInMillis());
		//System.out.println(dayslater*60*24*60*1000l);
		
		long t = (cal.getTimeInMillis()+(dayslater*60*24*60*1000l));
		
		//System.out.println((cal.getTimeInMillis()+(dayslater*60*24*60*1000l)));
		//System.out.println(t);
		
		d= new Date(t);
		cal.setTime(d);
		
		return str2Date(String.format(DATEWITHOUTTIME, cal.get(Calendar.YEAR),(cal.get(Calendar.MONTH)+1),cal.get(Calendar.DAY_OF_MONTH)));
	}
	
	
	public static boolean isBefore(Date start,Date end){
		boolean tag = false;
		Calendar cal = Calendar.getInstance();
		cal.setTime(start);
		long t1 = cal.getTimeInMillis();
		cal.setTime(end);
		long t2 = cal.getTimeInMillis();
		/*
		if(t1-t2<0){
			tag = true;
		}else{
			tag = false;
		}
		*/
		return t1<t2;
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
	
	public static boolean isBetween(Date strattime,Date endtime,Date now){
		Calendar cals = Calendar.getInstance();
		cals.setTime(strattime);
		long stl = cals.getTimeInMillis();
		
		cals.setTime(endtime);
		long sel = cals.getTimeInMillis();
		
		cals.setTime(now);
		long nowl = cals.getTimeInMillis();
		
		
		return stl<=nowl && nowl<=sel;
	}
	
	public static Date str2Date(String str){
		//yyyy.MM.dd G 'at' HH:mm:ss
		DateFormat df =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		try {
			date = df.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public static String data2String(Date date){
		DateFormat df =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(date);
	}
}
