package exceptions;

public class PreconditionError extends ContractError {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PreconditionError(String string) {
		super("Failed at precondition : "+string);
		// TODO Auto-generated constructor stub
	}

}
