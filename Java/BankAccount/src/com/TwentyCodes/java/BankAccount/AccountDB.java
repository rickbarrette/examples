/**
 * @author Twenty Codess, LLC
 * @author ricky barrette
 * @data Dec 18, 2010
 */

package com.TwentyCodes.java.BankAccount;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * This class will be a account database
 */
public class AccountDB {

	private ArrayList<Account> array;

	/**
	 * Creates a new AccountDB
	 */
	public AccountDB() {
		array = new ArrayList<Account>(0);
	}

	/**
	 * returns a human readable string (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (Account item : array)
			sb.append(item.toString() + "\n");
		return sb.toString();
	}
	
	/**
	 * saves the database to a text file
	 * @param file to be saved to
	 * @author ricky barrette
	 * @throws IOException 
	 */
	public void save(File file) throws IOException{
		StringBuffer sb = new StringBuffer();
		for(Account item : array)
			sb.append(item.getBalance()+","+item.getOwner()+","+item.getAccount()+"\n");
		FileOutputStream theFile = new FileOutputStream(file);
		theFile.write(sb.toString().getBytes());
		theFile.flush();
		theFile.close();
	}
	
	public void load(File file) throws FileNotFoundException{
		Scanner scan = new Scanner(file);
		String line = null;
		String [] lineParts;
		do{
			line = scan.nextLine();
			lineParts = line.split(",");
			try {
				addAccount(new Account(Double.parseDouble(lineParts[0]), lineParts[1], Long.parseLong(lineParts[2])));
			} catch (AccountExistsException e) {
				e.printStackTrace();
			}
		}while(scan.hasNextLine());
	}

	/**
	 * added the account to the database
	 * 
	 * @param account
	 * @throws AccountExistsException 
	 */
	public void addAccount(Account account) throws AccountExistsException {
		boolean isExisting = getAccount(account.getAccount()) != null ? true : false;
		if(! isExisting){
			array.add(account);
			Collections.sort(array);
		} else
			throw new AccountExistsException("Account "+ account.getAccount()+" Already Exists");
	}

	/**
	 * finds the all occurrences of an account with the owner
	 * 
	 * @param owner
	 * @return a list containing all the accounts with the provided owner
	 */
	public ArrayList<Account> findAccount(String owner) {
		ArrayList<Account> temp = new ArrayList<Account>(0);
		for (Account item : array)
			if (item.getOwner().equals(owner))
				temp.add(item);
		return temp;
	}

	/**
	 * 
	 * @param search
	 * @return arraylist containing all the
	 * @author ricky barrette
	 */
	public ArrayList<Account> searchForAccount(String search) {
		long account = -1;
		try {
			account = Long.parseLong(search);
		} catch (Exception e) {
			// TO NOTHING
		}
		ArrayList<Account> temp = new ArrayList<Account>(0);
		for (Account item : array) {
			if (item.getOwner().contains(search))
				temp.add(item);
			if (account > 0 && item.getAccount() == account)
				temp.add(item);
		}
		return temp;
	}

	/**
	 * removes the all occurrences of an account with the owner
	 * 
	 * @param owner
	 */
	public void deleteAccounts(String owner) {
		long account = -1;
		try {
			account = Long.parseLong(owner);
		} catch (Exception e) {
			// TO NOTHING
		}
		Object[] temp = array.toArray();
		for (int index = 0; index < temp.length; index++) {
			if (((Account) temp[index]).getOwner().equals(owner))
				temp[index] = null;
			if (account > 0 && ((Account) temp[index]).getAccount() == account)
				temp[index] = null;
		}

		array.removeAll(array);

		for (Object item : temp)
			if (item != null)
				array.add((Account) item);
	}

	/**
	 * returns the specified account
	 * 
	 * @param accountNumber
	 * @return account or null if account doesnt exist
	 * @author ricky barrette
	 */
	public Account getAccount(long accountNumber) {
		for (Account item : array)
			if (item.getAccount() == accountNumber)
				return item;
		return null;
	}

	/**
	 * deposits money into the specified account
	 * @param accountNumber
	 * @param amount
	 * @return true if successful
	 * @author ricky barrette
	 */
	public boolean deposit(long accountNumber, double amount) {
		for (Account item : array)
			if (item.getAccount() == accountNumber) {
				item.deposit(amount);
				return true;
			}
		return false;
	}

	/**
	 * charges a fee to the specified account
	 * @param accountNumber
	 * @return true if successful
	 * @author ricky barrette
	 */
	public boolean chargeFee(long accountNumber) {
		for (Account item : array)
			if (item.getAccount() == accountNumber) {
				item.chargeFee();
				return true;
			}
		return false;
	}

	/**
	 * withdraws money from the specified account
	 * @param accountNumber
	 * @param amount
	 * @return true if successful
	 * @author ricky barrette
	 */
	public boolean withdraw(long accountNumber, double amount) {
		for (Account item : array)
			if (item.getAccount() == accountNumber) {
				item.withdraw(amount);
				return true;
			}
		return false;
	}

}