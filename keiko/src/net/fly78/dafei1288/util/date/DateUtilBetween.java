package net.fly78.dafei1288.util.date;

import java.util.Calendar;
import java.util.Date;

public class DateUtilBetween {
	
	private Date begin;
	private Date end;
	private boolean reset = false;
	
	private boolean isNeedReMark(){
		return reset;
	}
	
	private void reMark(){
		this.setReset(false);
	}
	private void reUnMark(){
		this.setReset(true);
	}
	
	
	private boolean isReset() {
		return reset;
	}
	private void setReset(boolean reset) {
		this.reset = reset;
	}


	public Date getBegin() {
		return begin;
	}
	public void setBegin(Date begin) {
		
		this.begin = begin;
		this.reUnMark();
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		
		this.end = end;
		this.reUnMark();
	}
	
	
	
	protected  DateUtilBetween(){}
	
	
	private int _days = 0;
	private int _hours = 0;
	private int _mins = 0;
	private int _secs = 0;
	//private int _days = 0;
	
	private int get_days() {
		return _days;
	}

	private void set_days(int _days) {
		this._days = _days;
	}

	private int get_hour() {
		return _hours;
	}

	private void set_hour(int _hour) {
		this._hours = _hour;
	}

	private int get_min() {
		return _mins;
	}

	private void set_min(int _min) {
		this._mins = _min;
	}

	private int get_sec() {
		return _secs;
	}

	private void set_sec(int _sec) {
		this._secs = _sec;
	}
	
	
	
	public static DateUtilBetween getInstance(Date begin,Date end){
		return DateUtilBetween.flushData(begin, end);
	}

	
	private static DateUtilBetween flushData(Date begin,Date end){
		DateUtilBetween _dateutil = new DateUtilBetween();
		_dateutil.setBegin(begin);
		_dateutil.setEnd(end);
		_dateutil.reMark();
		Calendar cal = Calendar.getInstance();
		cal.setTime(begin);
		long lbegin = cal.getTimeInMillis();
		cal.setTime(end);
		long lend = cal.getTimeInMillis();
		long lbetween = lbegin-lend;
		
		int ss = (int)lbetween/1000;
		int mm = (int)ss/60;
		int hh = (int)mm/60;
		int dd = (int)hh/24;
		_dateutil.set_sec(ss);
		_dateutil.set_min(mm);
		_dateutil.set_hour(hh);
		_dateutil.set_days(dd);
		
		return _dateutil;	
	}	
	public int getDays(){
		return _days;		
	}
	public int getHours(){
		return _hours;
	}
	public int getMins(){
		return _mins;
	}
	public int getSecs(){
		return _secs;
	}
}
