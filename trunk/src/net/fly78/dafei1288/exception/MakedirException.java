package net.fly78.dafei1288.exception;

public class MakedirException extends Exception {
	public MakedirException(Throwable e) {
		super("Can't create the dir...",e);
	}
	
	public MakedirException(){
		super("Can't create the dir...");
	}
}
