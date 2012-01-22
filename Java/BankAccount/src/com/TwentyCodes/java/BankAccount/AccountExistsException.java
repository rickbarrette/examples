/**
 * @author Twenty Codes, LLC
 * @author ricky barrette
 * @date Dec 24, 2010
 */

package com.TwentyCodes.java.BankAccount;

/**
 * 
 * @author ricky barrette
 */
public class AccountExistsException extends Exception {

	/**
	 * @author ricky barrette
	 */
	private static final long serialVersionUID = 4605163237489852355L;

	/**
	 * Creates a new AccountExistsException
	 * @author ricky barrette
	 */
	public AccountExistsException() {
		super();
	}

	/**
	 * Creates a new AccountExistsException
	 * @param arg0
	 * @author ricky barrette
	 */
	public AccountExistsException(String arg0) {
		super(arg0);
	}

	/**
	 * Creates a new AccountExistsException
	 * @param arg0
	 * @author ricky barrette
	 */
	public AccountExistsException(Throwable arg0) {
		super(arg0);
	}

	/**
	 * Creates a new AccountExistsException
	 * @param arg0
	 * @param arg1
	 * @author ricky barrette
	 */
	public AccountExistsException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
