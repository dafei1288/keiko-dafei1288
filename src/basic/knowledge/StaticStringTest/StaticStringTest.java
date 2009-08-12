package basic.knowledge.StaticStringTest;

import basic.knowledge.StaticStringTest.other.Other;

public class StaticStringTest {
	public static void main(String[] args) {
		String hello = "Hello", lo = "lo";
		
		
		/***************自己测试*****************/
		System.out.println();
		String helloo = "Hello";
		String hellon = new String("Hello");
		System.out.println((hello == helloo) + " ");
		System.out.println((hello == hellon) + " ");
		System.out.println((hellon == helloo) + " ");
		System.out.println();
		/***************自己测试*****************/
		
		
		System.out.print((hello == "Hello") + " ");
		System.out.print((Other.hello == hello) + " ");
		System.out.print((basic.knowledge.StaticStringTest.other.Other.hello == hello) + " ");
		System.out.print((hello == ("Hel"+"lo")) + " ");
		System.out.print((hello == ("Hel"+lo)) + " ");
		System.out.println(hello == ("Hel"+lo).intern());
		}

}
