package by.epam.tc.test.command.exception;
/**
 * Created by Aliaksei Boltak on 25/10/2016.
 */

public class CommandException extends Exception{
	private static final long serialVersionUID = 1L;

	public CommandException(){
		super();
	}
	
	public CommandException(String message){
		super(message);
	}
	
	public CommandException(Exception e){
		super(e);
	}
	
	public CommandException(String message, Exception e){
		super(message, e);
	}

}
