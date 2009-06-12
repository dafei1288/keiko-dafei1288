/**
 * 得到2个日期之间的差
 * */
package net.fly78.dafei1288.util.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * @author dafei1288
 * */
public class SimpleDateUtilBetween {

	private Date begin;
	private Date end;
	private long between = 0l;
	private Calendar beginc;
	private Calendar endc;
	
	public Calendar getBeginc() {
		return beginc;
	}

	public void setBeginc(Calendar beginc) {
		this.beginc = beginc;
	}
	
	public void setBeginc(Date begin) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(begin);
		this.setBeginc(cal);
		
	}
	
	public Calendar getEndc() {
		return endc;
	}

	public void setEndc(Calendar endc) {
		this.endc = endc;
	}
	
	public void setEndc(Date endc) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(endc);
		this.setEndc(cal);
	}
	
	public Date getBegin() {
		return begin;
	}

	public void setBegin(Date begin) {
		this.begin = begin;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}
	
	protected  SimpleDateUtilBetween(){}
	public static SimpleDateUtilBetween getInstance(Date begin,Date end){
		return SimpleDateUtilBetween.flushData(begin, end);
	}
	/**
	 * 构造SimpleDateUtilBetween事例
	 * @param String beginstr 启始时间的字符串 YYYY-MM-dd HH:mm:ss
	 * @param String endstr 结束时间的字符串 YYYY-MM-dd HH:mm:ss
	 * @return SimpleDateUtilBetween 实力
	 * */
	public static SimpleDateUtilBetween getInstance(String beginstr,String endstr) throws ParseException{
		Date begin;
		Date end;		
		DateFormat df = DateFormat.getDateTimeInstance();
		begin = df.parse(beginstr);
		end = df.parse(endstr);
		return SimpleDateUtilBetween.flushData(begin, end);
	}
	/**
	 * 构造SimpleDateUtilBetween事例
	 * @param long beginstr 启始时间的字符串 
	 * @param long endstr 结束时间的字符串 
	 * @return SimpleDateUtilBetween 实力
	 * */
	public static SimpleDateUtilBetween getInstance(long beginstr,long endstr) throws ParseException{
		Date begin = new Date(beginstr);
		Date end = new Date(endstr);		
		return SimpleDateUtilBetween.flushData(begin, end);
	}
	/**
	 * 构造SimpleDateUtilBetween事例
	 * @param Date begin,Date end begin 启始时间的字符串
	 * @param Date begin,Date end end 结束时间的字符串 
	 * @return SimpleDateUtilBetween 实力
	 * */
	private static SimpleDateUtilBetween flushData(Date begin,Date end){
		SimpleDateUtilBetween _dateutil = new SimpleDateUtilBetween();
		_dateutil.setBegin(begin);
		_dateutil.setEnd(end);
		_dateutil.setBeginc(begin);
		_dateutil.setEndc(end);
		return _dateutil;	
	}	
	/**
	 * 得到两个日期间所有天数 24小时制度
	 * */
	public int getAllDays(){
		return (int)(this.between()/SimpleDateUtilBetween.DateTimeUtil.DAY);		
	}
	
	/**
	 * 得到两个日期之间所有的真实天数
	 * */
	public int getRealAllDays(){
		int ald = this.getAllDays();
		
		if(this.beginc.get(Calendar.HOUR_OF_DAY)>this.endc.get(Calendar.HOUR_OF_DAY)){
			ald++;
		}
		
		return ald;//this.getBeginc().get(Calendar.DAY_OF_YEAR)-this.getEndc().get(Calendar.DAY_OF_YEAR);
	}
	
	
	/**
	 * 得到两个日期间所有小时数
	 * */
	public int getAllHours(){
		return (int)(this.between()/SimpleDateUtilBetween.DateTimeUtil.HOUR);
	}
	/**
	 * 得到两个日期间所有分钟数
	 * */
	public int getAllMins(){
		return (int)(this.between()/SimpleDateUtilBetween.DateTimeUtil.MIN);
	}
	/**
	 * 得到两个日期间所有秒数
	 * */
	public int getAllSecs(){
		return (int)(this.between()/SimpleDateUtilBetween.DateTimeUtil.SEC);
	}

	public int getDays(){
		return this.getUserFild(Calendar.DAY_OF_MONTH);
		
	}
	public int getHours(){
		return this.getUserFild(Calendar.HOUR_OF_DAY);
		
	}
	public int getMins(){
		return this.getUserFild(Calendar.MINUTE);
		
	}
	public int getSecs(){
		return this.getUserFild(Calendar.SECOND);
	}
	
	public int getUserFild(int fild){
		int res = 0;
		int a = this.getBeginc().get(fild);
		int b = this.getEndc().get(fild);
		res = b-a;
		return res;
	}
	
	public long between(){
		long lbegin = this.getBeginc().getTimeInMillis();
		long lend = this.getEndc().getTimeInMillis();
		this.between = lend-lbegin;		
		return this.between;
	}
	public boolean isTheSameDay(){
		boolean tag = false;
		tag = this.getBeginc().get(Calendar.DAY_OF_YEAR)==this.getEndc().get(Calendar.DAY_OF_YEAR);		
		tag = tag&&this.getBeginc().get(Calendar.MONTH)==this.getEndc().get(Calendar.MONTH);
		tag = tag&&this.getBeginc().get(Calendar.YEAR)==this.getEndc().get(Calendar.YEAR);
		return tag;
	}
	public boolean isTheDifferentDay(){
		return !this.isTheSameDay();
	}
	
	public boolean isTheSameHour(){
		return this.getBeginc().get(Calendar.HOUR_OF_DAY)==this.getEndc().get(Calendar.HOUR_OF_DAY);
	}
	/**
	 * 得到相差 yyyy-MM-dd HH:mm:ss 形式的字符串
	 * */
	public String toString(){
		StringBuffer sb =  new StringBuffer();
		long be = Math.abs(this.between());
		int dd = (int)(be/SimpleDateUtilBetween.DateTimeUtil.DAY);
		int dd2hh = (int)(be%SimpleDateUtilBetween.DateTimeUtil.DAY);
	
		
		int hh = (int)(dd2hh/SimpleDateUtilBetween.DateTimeUtil.HOUR);
		int hh2mm = (int)(dd2hh%SimpleDateUtilBetween.DateTimeUtil.HOUR);
		
		int mm = (int)(hh2mm/SimpleDateUtilBetween.DateTimeUtil.MIN);
		int mm2ss = (int)(hh2mm%SimpleDateUtilBetween.DateTimeUtil.MIN);
		
		int ss = (int)(mm2ss/SimpleDateUtilBetween.DateTimeUtil.SEC);
		return sb.append(dd).append("-").append(hh).append("-").append(mm).append("-").append(ss).toString();
	}
	
	public static class DateTimeUtil{
		public static final long DAY = 1000*60*60*24l;
		public static final long HOUR = 1000*60*60l;
		public static final long MIN = 1000*60l;
		public static final long SEC = 1000l;
	}
}
