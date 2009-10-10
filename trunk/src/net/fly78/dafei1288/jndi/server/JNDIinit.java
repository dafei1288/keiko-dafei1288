package net.fly78.dafei1288.jndi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JNDIinit {
	
	public static void init(){
		try {
			LocateRegistry.createRegistry(12222);
			
			System.setProperty(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory");
			System.setProperty(Context.PROVIDER_URL, "rmi://localhost:12222");
			
			InitialContext ctx = new InitialContext();
			
			class RemoteDate extends Date implements Remote{};
			
			ctx.bind("java:comp/env/systemTime", new RemoteDate());
			//ctx.close();
			
			
			ctx = new InitialContext();
			Date d = (Date) ctx.lookup("java:comp/env/systemTime");
			
			System.out.println(d);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
			JNDIinit.init();
		
	}

}
