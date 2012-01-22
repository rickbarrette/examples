/**
 * @author Twenty Codes, LLC
 * @author ricky barrette
 * @date Dec 18, 2010
 */

package com.TwentyCodes.java.BankAccount.UI;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.TwentyCodes.java.BankAccount.AccountDB;

/**
 * this is the main window and class of this application
 */
public class MainWindow extends JFrame implements ActionListener{

	private JButton search;
	private JButton addAccount;
	private JButton addTransaction;
	private JButton removeAccount;
	private JButton showAllAccount;
	private JButton saveToFile;
	private JButton loadFile;
	private JFileChooser fc;
	public static AccountDB db;
	
	/**
	 * Generated Serial Version ID
	 */
	private static final long serialVersionUID = 1841715561053331517L;

	public MainWindow() {
		setTitle("Account Database");
		JPanel panel = new JPanel();
		search = new JButton("Search");
		addAccount = new JButton("Add Account");
		addTransaction = new JButton("Add Transaction");
		removeAccount = new JButton("Remove Account");
		showAllAccount = new JButton("Show All Accounts");
		loadFile = new JButton("Load File");
		saveToFile = new JButton("Save");
		
		search.addActionListener(this);
		addAccount.addActionListener(this);
		addTransaction.addActionListener(this);
		removeAccount.addActionListener(this);
		showAllAccount.addActionListener(this);
		saveToFile.addActionListener(this);
		loadFile.addActionListener(this);
		
		panel.add(search);
		panel.add(addAccount);
		panel.add(addTransaction);
		panel.add(removeAccount);
		panel.add(showAllAccount);
		panel.add(loadFile);
		panel.add(saveToFile);
		
		add(panel);
		setVisible(true);
		pack();
        
        db = new AccountDB();
        
        fc = new JFileChooser();

        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
	}
	
	/**
	 * main method, called when the application starts
	 * @param args
	 */
	public static void main(String[] args){
		new MainWindow();
	}
	
	/**
	 * called when a button is clicked
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == search) {
			new SearchDialog();
		}
		if (e.getSource() == addAccount) {
			new AddAccountDialog();
		}
		if (e.getSource() == removeAccount) {
			new RemoveAccounteDialog();
		}
		if (e.getSource() == showAllAccount) {
			new ShowAllDialog(db.toString());
		}
		if(e.getSource() == addTransaction){
			new TransactionDialog();
		}
		if(e.getSource() == saveToFile){
			try {
				if(fc.showSaveDialog(MainWindow.this) == JFileChooser.APPROVE_OPTION)
					db.save(fc.getSelectedFile());
			} catch (HeadlessException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource() == loadFile){
			try {
				if(fc.showOpenDialog(MainWindow.this) == JFileChooser.APPROVE_OPTION)
					db.load(fc.getSelectedFile());
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}			

}