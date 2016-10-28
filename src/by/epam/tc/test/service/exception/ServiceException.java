package by.epam.tc.test.service.exception;

public class ServiceException extends Exception {
	/**
	 * Created by Aliaksei Boltak on 25/10/2016.
	 */
	
	private static final long serialVersionUID = 1L;

	public ServiceException(){
		super();
	}
	
	public ServiceException(String message){
		super(message);
	}
	
	public ServiceException(Exception e){
		super(e);
	}
	
	public ServiceException(String message, Exception e){
		super(message, e);
	}
}
