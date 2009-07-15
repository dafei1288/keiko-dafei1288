/**
 * net.fly78.dafei1288.util.math
 * 
 * @author dafei1288
 *
 * @version 2009/Jul 15, 2009/2:51:16 PM
 */
package net.fly78.dafei1288.util.math;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;


/**
 * 反射出给定对象的指定方法加固定属性(尚不完善)
 * 
 * @author dafei1288
 * @deprecated
 * */

public class ReflectPropertiesRandomUtil {
	public static Object simpleParamInvokeReflectRandomBean(Object object,String methodName,Class paramsClass,Object paramsObject) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		Method m1 = object.getClass().getMethod(methodName, paramsClass);
		Object r1 = m1.invoke(object, paramsObject);
		return object;
	}
	public static Object simpleParamInvokeReflectRandomBean(Object object,String methodName,Object paramsObject) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		Method m1 = object.getClass().getMethod(methodName, paramsObject.getClass());
		Object r1 = m1.invoke(object, paramsObject);
		return object;
	}
	public Object invokeReflectRandomBean(Object object, Class objectClass,String methodName,Class[] paramsClass,Object[] paramsObject) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		
//		Class ptypes[] = new Class[params.size()];
//		Object ptobject[] = new Object[params.size()];
//		
//		Set emkey = params.keySet();
//		int i=0;
//		Iterator it = emkey.iterator();
//		while(it.hasNext()){
//			Object o = it.next();
//			
//			ptypes[i] = (Class) o;
//			ptobject[i] = params.get(o);
//			i++;
//			
//		}
		//ptypes[0] = Class.forName("java.lang.String");
		Method m1 = object.getClass().getMethod(methodName, paramsClass);
		Object r1 = m1.invoke(object, paramsObject);
		
		return object;
	}
	public Object invokeReflectRandomBean(RandomBean rb) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException{
		return this.invokeReflectRandomBean(rb.getObject(), rb.getObjectClass(),rb.getMethodName(),rb.getParamsClass(),rb.getParamsObject() );	
	}
	public static class RandomBean{
		private Object object;
		private Class objectClass;
		private String methodName;
		private Class[] paramsClass;
		private Object[] paramsObject;
		private LinkedHashMap<Class,Object> params;
		
		public Object getObject() {
			return object;
		}
		public void setObject(Object object) {
			this.object = object;
		}
		public Class getObjectClass() {
			return objectClass;
		}
		public void setObjectClass(Class objectClass) {
			this.objectClass = objectClass;
		}
		public String getMethodName() {
			return methodName;
		}
		public void setMethodName(String methodName) {
			this.methodName = methodName;
		}
		public LinkedHashMap<Class, Object> getParams() {
			return params;
		}
		public void setParams(LinkedHashMap<Class, Object> params) {
			this.params = params;
		}
		public Class[] getParamsClass() {
			return paramsClass;
		}
		public void setParamsClass(Class[] paramsClass) {
			this.paramsClass = paramsClass;
		}
		public Object[] getParamsObject() {
			return paramsObject;
		}
		public void setParamsObject(Object[] paramsObject) {
			this.paramsObject = paramsObject;
		}
		
	}
	
	public static class User{
		private String username;
		private String password;
		private Integer age;
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public Integer getAge() {
			return age;
		}
		public void setAge(Integer age) {
			this.age = age;
		}
		
		public void setAaa(String user,String password,Integer i){
			this.username = user;
			this.password = password;
			this.age = i;
		}
		public String toString(){
			return "[ username="+this.username+" ,password="+this.password+" ,age="+this.age+" ]";
		}
	}
	
	
	public static void main(String[] arg){
		User u = new User();
		u.setAge(1);
		u.setUsername("dafei1288");
		u.setPassword("mali");
		
		ReflectPropertiesRandomUtil.RandomBean rb = new ReflectPropertiesRandomUtil.RandomBean();
		rb.setObject(u);
		rb.setObjectClass(u.getClass());
		rb.setMethodName("setAaa");
		//LinkedHashMap<Class, Object> hs = new LinkedHashMap<Class, Object>();
		Class[] c = new Class[3];
		Object[] oc = new Object[3];
		
		c[0] = java.lang.String.class;
		c[1] = java.lang.String.class;
		c[2] = java.lang.Integer.class;
		
		oc[0] = "isdkajhdfauisdhaisdhkasdj";
		oc[1] = "00000000000000";
		oc[2] = 22;
		
		rb.setParamsClass(c);
		rb.setParamsObject(oc);
		
		ReflectPropertiesRandomUtil rp = new ReflectPropertiesRandomUtil();
		try {
			Object o = rp.invokeReflectRandomBean(rb);
			System.out.println(o.toString());
			
			
			o = ReflectPropertiesRandomUtil.simpleParamInvokeReflectRandomBean(u, "setPassword", "ksdjf9839493");
			System.out.println(o.toString());
			
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		
	}
}
