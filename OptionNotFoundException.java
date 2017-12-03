package exception;

public class OptionNotFoundException extends RuntimeException{
	public OptionNotFoundException(String msg){
		System.err.println(msg);
	}
	

}