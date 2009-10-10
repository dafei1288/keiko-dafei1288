package net.fly78.dafei1288.jndi.client;

import java.util.Date;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Client {

	public static void main(String[] args) {
		try {
			InitialContext ctx = new InitialContext();
			Date d = (Date) ctx.lookup("java:comp/env/systemTime");
			
			System.out.println(d);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

}
