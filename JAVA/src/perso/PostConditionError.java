package perso;

public class PostConditionError extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PostConditionError(String string) {
		// TODO Auto-generated constructor stub
		super("Failed at postcondition : "+string);
	}

}
