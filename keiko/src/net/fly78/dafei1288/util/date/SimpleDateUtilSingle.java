package net.fly78.dafei1288.util.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class SimpleDateUtilSingle {
	private Date _date;
	private Calendar _calendar;
	private SimpleDateUtilSingle(Date date){
		_date = date;
		_calendar = Calendar.getInstance();
		_calendar.setTime(date);
	}
	
	public static SimpleDateUtilSingle getInstance(Date date){
		return new SimpleDateUtilSingle(date);
	}
	public static SimpleDateUtilSingle getInstance(long date){
		return new SimpleDateUtilSingle(new Date(date));
	}
	public static SimpleDateUtilSingle getInstance(String date) throws ParseException{
			return new SimpleDateUtilSingle(DateFormat.getDateTimeInstance().parse(date));
	}
	
	public Date getDate(){
		return _calendar.getTime();
	}
	
	public Date addDate(int day){
		_calendar.set(Calendar.DAY_OF_MONTH, _calendar.get(Calendar.DAY_OF_MONTH)+day);
		return _calendar.getTime();
	}
	public Date addHour(int hour){
		_calendar.set(Calendar.HOUR_OF_DAY, _calendar.get(Calendar.HOUR_OF_DAY)+hour);
		return _calendar.getTime();
	}
	
	public Date addMins(int mins){
		_calendar.set(Calendar.MINUTE, _calendar.get(Calendar.MINUTE)+mins);
		return _calendar.getTime();
	}
	
	public Date changeFilds(int key,int value){
		_calendar.set(key, _calendar.get(key)+value);
		return _calendar.getTime();
	}
	
}
