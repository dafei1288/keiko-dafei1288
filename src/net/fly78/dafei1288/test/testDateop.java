package net.fly78.dafei1288.test;
import java.util.Date;

import junit.framework.TestCase;

import net.fly78.dafei1288.util.date.*;
public class testDateop extends TestCase{
	public void testda(){
		/*
		System.out.println(DateOption.Add(new Date(), 12).toString());
		//System.out.println(DateOption.isBefore(new Date(), new Date()));
		Date start = new Date();
		System.out.println(start.toString());
		for(long i =0;i<10000000000l;i++){}
		Date end = new Date();
		System.out.println(end.toString());
		
		System.out.println(DateOption.isBefore(start, end));
		*/
		//System.out.println(DateOption.isTheSameDate(new Date(), new Date(1212121)));
		//isTimeLater
		/*
		System.out.println(DateOption.isHoursin(new Date(2008,11,12,4,5,6), new Date(2005,11,12,4,5,6),1));
		System.out.println(DateOption.isHoursin(new Date(2008,11,12,4,5,6), new Date(2008,12,12,4,5,6),1));
		System.out.println(DateOption.isHoursin(new Date(2008,11,12,4,5,6), new Date(2008,11,13,4,5,6),1));
		System.out.println(DateOption.isHoursin(new Date(2008,11,12,4,5,6), new Date(2008,11,12,4,5,6),1));
		System.out.println(DateOption.isHoursin(new Date(2008,11,12,4,5,6), new Date(2008,11,12,4,4,6),1));
		
		System.out.println(DateOption.isHoursin(new Date(2008,11,12,4,5,6), new Date(2008,11,12,5,4,6),1));
		System.out.println(DateOption.isHoursin(new Date(2008,11,12,4,5,6), new Date(2008,11,12,6,4,6),1));
		System.out.println(DateOption.isHoursin(new Date(2008,11,12,4,5,6), new Date(2008,11,12,7,4,6),4));
		System.out.println(DateOption.isHoursin(new Date(2008,11,12,4,5,6), new Date(2008,11,12,9,4,6),1));
		;
		
		
		
		Date date  = DateOption.str2Date("1998-11-22 11:33:44");
		
		System.out.println(DateOption.data2String(new Date()));
		
		System.out.println(DateOption.data2String(date));
		*/
		//System.out.println(DateOption.Add(new Date(), 4*24*60));
		//System.out.println(DateOption.Add(new Date(), 4*60));
		System.out.println(DateOption.AddDayWithTime(new Date(),-3));
		System.out.println(DateOption.AddDayWithTime(new Date(),1));
		System.out.println(DateOption.AddDayWithTime(new Date(),2));
		;
		
	}
}
