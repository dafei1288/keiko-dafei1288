/**
 * net.fly78.dafei1288.util
 * 
 * @author dafei1288
 *
 * @version 2009/Apr 7, 2009/12:12:16 PM
 */
package net.fly78.dafei1288.util;

public class UnsupportedException extends RuntimeException {

	public UnsupportedException() {
		super("this object is unsupported this method!");
	}

	public UnsupportedException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnsupportedException(String message) {
		super(message);
	}

	public UnsupportedException(Throwable cause) {
		super(cause);
	}
	
}
