/**
 * @author Twenty Codes, LLC
 * @author ricky barrette
 * @date Nov 21, 2010
 */

package com.TwentyCodes.java.BankAccount;

/**
 * This is an account class
 * @author ricky barrette
 */
public class Account implements Comparable<Account>{

	private double mBalance;
	private String mOwner;
	private long mAccountNumber;

	/**
	 * Creates a new Account
	 * @param balance starting balance
	 * @param owner
	 * @param accountNumber
	 * @author ricky barrette
	 */
	public Account(double balance, String owner, long accountNumber) {
		mBalance = balance;
		mOwner = owner;
		mAccountNumber = accountNumber;
	}
	
	/**
	 * withdraws money from the account
	 * @param amount to withdraw
	 * @return new balance
	 * @author ricky barrette
	 */
	public double withdraw(double amount){
		mBalance = mBalance - amount;
		return mBalance;
	}
	
	/**
	 * deposits money into the account
	 * @param amount to deposit
	 * @return new balance
	 * @author ricky barrette
	 */
	public double deposit(double amount){
		mBalance = mBalance + amount;
		return amount;
	}
	
	/**
	 * getter method for the account balance
	 * @return current balance
	 * @author ricky barrette
	 */
	public double getBalance(){
		return mBalance;
	}
	
	/**
	 * getter method for the owner name
	 * @return owners name
	 * @author ricky barrette
	 */
	public String getOwner(){
		return mOwner;
	}
	
	/**
	 * returns a human readable string
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * @return human readable string
	 * @author ricky barrette
	 */
	@Override
	public String toString(){
		return "Owner: "+ mOwner +"; Acount: "+ mAccountNumber +"; Banace: "+ mBalance;
	}
	
	/**
	 * changes the owners name
	 * @param name
	 * @author ricky barrette
	 */
	public void changeOwnerName(String name){
		mOwner = name;
	}
	
	/**
	 * charges a $10 to the account
	 * @return new balance
	 * @author ricky barrette
	 */
	public double chargeFee(){
		mBalance = mBalance - 10;
		return mBalance;
	}

	/**
	 * compares accounts by owners names
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 * @author ricky barrette
	 */
	@Override
	public int compareTo(Account account) {
		return this.mOwner.compareTo(account.getOwner());
	}

	/**
	 * gets the account number
	 * @return account number
	 * @author ricky barrette
	 */
	public long getAccount() {
		return mAccountNumber;
	}

}