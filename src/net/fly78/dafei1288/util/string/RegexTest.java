package net.fly78.dafei1288.util.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

	public static void main(String[] args) {
		String textString = new String ("\\\"");   
        
        Pattern pt=Pattern.compile("\\\\\"");   
           
        Matcher mc=pt.matcher(textString);   
           
        //mc.replaceAll("xx");   
           
        //textString.replaceAll("\\", "xx");   
           
        String bl=mc.replaceAll("xx");   
           
        System.out.println(textString);   
        System.out.println(bl);   

	}

}
