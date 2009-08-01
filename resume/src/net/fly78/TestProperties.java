package net.fly78;

import java.util.Locale;
import java.util.ResourceBundle;

public class TestProperties {

	public static void main(String[] args) {
		Locale local = new Locale("");
		ResourceBundle resource = ResourceBundle.getBundle("messages",local);   
		 
		   System.out.print(resource.getString("k1")   
		     + "!");   
		   System.out   
		     .println(resource.getString("k2") + "!");   

	}

}
