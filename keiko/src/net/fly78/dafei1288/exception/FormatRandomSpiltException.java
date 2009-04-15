package net.fly78.dafei1288.exception;

public class FormatRandomSpiltException extends Exception {
	public FormatRandomSpiltException(Throwable e) {
		super("string in not like $num - $num",e);
	}
	
	public FormatRandomSpiltException(){
		super("string in not like $num - $num");
	}
}
