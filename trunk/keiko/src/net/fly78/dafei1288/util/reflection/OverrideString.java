package net.fly78.dafei1288.util.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class OverrideString {
	public static String getString(Class c,Object o){
		StringBuilder sb = new StringBuilder(c.getName()+":");
		Class clazz = c;// 获取集合中的对象类型
        Field[] fds = clazz.getDeclaredFields();// 获取他的字段数组
        Method[] ms = clazz.getDeclaredMethods();
        
        for(Method method : ms){
        	try{
	        	if(method.getName().contains("get")){
	        		Object name = method.invoke(c, null);
	        		sb.append(method.getName()).append("@").append(name==null?"":name).append(",");
	        	}
        	}catch(Exception e){
        		e.printStackTrace();
        	}
        }
        
        /*
        for (Field field : fds) {// 遍历该数组
              String fdname = field.getName();// 得到字段名，
              Method metd;
				try {
					
	               	metd = clazz.getMethod("get" + change(fdname), null);
	               	
	               	Object name = metd.invoke(c, null);// 调用该字段的get方法
	               	sb.append(fdname).append("@").append(name==null?"":name).append(",");
				} catch (SecurityException e) {
					//e.printStackTrace();
				} catch (NoSuchMethodException e) {
					//e.printStackTrace();
				}catch (IllegalArgumentException e) {
					//e.printStackTrace();
				} catch (IllegalAccessException e) {
					//e.printStackTrace();
				} catch (InvocationTargetException e) {
					//e.printStackTrace();
				}

             
         }
         */
         sb.setLength(sb.length()-1);
         sb.append(";");
         return sb.toString();
	}
	public static String change(String src) {
        if (src != null) {
            StringBuffer sb = new StringBuffer(src);
            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
            return sb.toString();
        } else {
            return null;
        }
    }
}
