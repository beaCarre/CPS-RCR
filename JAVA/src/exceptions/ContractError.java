package exceptions;

public abstract class ContractError extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4152492314285414082L;

	public ContractError(String s){
		super(s);
	}
}
