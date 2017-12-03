package exception;

public class ListBoxNotSortedException  extends RuntimeException{
	public ListBoxNotSortedException(String msg){
		System.err.println(msg);
	}
}