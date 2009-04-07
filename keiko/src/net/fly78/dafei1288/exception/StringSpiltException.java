package net.fly78.dafei1288.exception;

public class StringSpiltException extends Exception {
	public StringSpiltException(Throwable e) {
		super("Warning non word spiled!",e);
	}
	
	public StringSpiltException(){
		super("Warning non word spiled!");
	}
}
