package exceptions;

public class PreconditionError extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PreconditionError(String string) {
		super("Failed at precondition : "+string);
		// TODO Auto-generated constructor stub
	}

}
