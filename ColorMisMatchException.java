package exception;

public class ColorMisMatchException extends RuntimeException{
	public ColorMisMatchException(String msg){
		System.err.println(msg);
	}
	

}
