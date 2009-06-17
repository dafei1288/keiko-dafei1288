/**
 * net.fly78.dafei1288.test
 * 
 * @author dafei1288
 *
 * @version 2009/Jun 17, 2009/4:25:49 PM
 */
package net.fly78.dafei1288.test;

import java.io.FileNotFoundException;
import java.io.IOException;

import net.fly78.dafei1288.util.io.ObjectClone;


public class testClone {
	public static void main(String[] args){
		ObjectClone c = new ObjectClone();
		long cm = System.currentTimeMillis();
		for(int i=0;i<1000;i++){
			try {
				ObjectClone.CloneObject(c);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		System.out.println(System.currentTimeMillis()-cm);
		
	}
}
