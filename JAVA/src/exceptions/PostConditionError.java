package exceptions;

public class PostConditionError extends ContractError {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PostConditionError(String string) {
		// TODO Auto-generated constructor stub
		super("Failed at postcondition : "+string);
	}

}
