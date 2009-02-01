package net.fly78.dafei1288.util.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassUtil {
	
	public Class<?> getClassByString(String name) throws ClassNotFoundException{
		return Class.forName(name);		
	}
	
	public Object invokeInstance(String name) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		Class c = Class.forName(name);
		return c.newInstance();
	}
	
	public Object invokeMethod(String classname,String methodname,Object...  arg) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException{
		Class c = Class.forName(classname);
		Object o = c.newInstance();
		Class[] classt = new Class[arg.length];
		for (int i = 0, j = arg.length; i < j; i++) {    
			classt[i] = arg[i].getClass(); 
        } 
		Method m = null;
		Method[] s= c.getMethods();
		m = c.getMethod(methodname, classt);
		return m.invoke(o, arg);
	}
	
}
