package net.fly78.dafei1288.exception;

public class ProcessingReq_and_ResException extends Exception {
	private static final long serialVersionUID = -2954888023550402051L;
	
		
	public ProcessingReq_and_ResException(Throwable e){
		super("Wrong args in ! like (requestKey,request,responseKey,response) or (request,response)",e);
	}
	public ProcessingReq_and_ResException(){
		super("Wrong args in ! like (requestKey,request,responseKey,response) or (request,response)");
	}
}
