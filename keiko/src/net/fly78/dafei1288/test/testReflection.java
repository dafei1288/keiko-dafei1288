package net.fly78.dafei1288.test;

import java.lang.reflect.InvocationTargetException;

import junit.framework.TestCase;
import net.fly78.dafei1288.util.reflection.*;
import net.fly78.dafei1288.util.string.*;

public class testReflection extends TestCase {
	public void testR(){
		ClassUtil cu = new ClassUtil();
		/*
		try {
			T t =(T)cu.invokeInstance("net.fly78.dafei1288.test.T");
			t.set();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			cu.invokeMethod("net.fly78.dafei1288.test.T", "set");
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Throwable ta){
			ta.printStackTrace();
		}
		*/
		
		try {
			String s = (String)cu.invokeMethod("net.fly78.dafei1288.test.T", "what","dafei1288",1,2);
			System.out.println(s);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Throwable ta){
			ta.printStackTrace();
		}
	}
}
