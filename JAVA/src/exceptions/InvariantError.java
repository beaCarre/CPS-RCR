package exceptions;

public class InvariantError extends ContractError {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvariantError(String string) {
		// TODO Auto-generated constructor stub
		super("Failed at invariant : "+string);
	}

}
