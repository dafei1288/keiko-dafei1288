/**
 * net.fly78.dafei1288.dynamicannotation
 * 
 * @author dafei1288
 *
 * @version 2009/Apr 3, 2009/11:41:19 AM
 */
package net.fly78.dafei1288.dynamicannotation;

public class Test {

	/*
	 * 执行顺序： 

javac Student.java 
javac -cp .;lib/asm-all-3.1.jar PreCompileProcess.java 
java -cp .;lib/asm-all-3.1.jar PreCompileProcess 
javac Test.java 
java Test 

在 Student.java 没有修改的情况下，PreCompileProcess 只需要执行一次就可以了。
	 * 
	 * */
	
//    public static void main(String[] args) {
//        Student stu = new Student();
//        stu.setAge(10);
//        stu.setName("Tom");
//        stu.address = "Beijing";    // 新增加的 address 字段
//        stu.tel = 56;               // 新增加的 tel 字段
//        System.out.println("Name:    " + stu.getName());
//        System.out.println("Age:     " + stu.getAge());
//        System.out.println("Address: " + stu.address);
//        System.out.println("Tel:     " + stu.tel);
//    }
}