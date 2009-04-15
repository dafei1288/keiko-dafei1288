package net.fly78.dafei1288.exception;

public class StringSpiltRuntimeException extends RuntimeException {
	public StringSpiltRuntimeException(Throwable e) {
		super("Warning non word spiled!",e);
	}
	
	public StringSpiltRuntimeException(){
		super("Warning non word spiled!");
	}
}
