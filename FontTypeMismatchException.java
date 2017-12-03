package exception;

public class FontTypeMismatchException extends RuntimeException {
	public FontTypeMismatchException(String msg){
		System.out.println(msg);
	}

}
