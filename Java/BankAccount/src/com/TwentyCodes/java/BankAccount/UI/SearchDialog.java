/**
 * @author Twenty Codes, LLC
 * @author ricky barrette
 * @data Dec 18, 2010
 */

package com.TwentyCodes.java.BankAccount.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.TwentyCodes.java.BankAccount.Account;

/**
 * This class will be the dialog that will ask the user for a specific make to show
 */
public class SearchDialog extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1750326106927701404L;
	private JButton ok;
	private JTextField editText;

	/**
	 * Creates a new ShowAllMakeDialog
	 */
	public SearchDialog() {
		super();
		setTitle("Search");
		
		//create a JPanel to hold the text area and button
		JPanel panel = new JPanel();
		ok = new JButton("Ok");
		JLabel label = new JLabel("Enter Acount Owner or Number:");
		ok.addActionListener(this);
		
		panel.add(label);
		
		editText = new JTextField();
		panel.add(editText);
		editText.setColumns(10);
		panel.add(ok);
		
		//add the JPanel to the frame, and display
		getContentPane().add(panel);
		pack();
		setVisible(true);
	}


	/**
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ok) {
			StringBuilder sb = new StringBuilder();
			for(Account item : MainWindow.db.searchForAccount(editText.getText()))
				sb.append(item.toString()+"\n");
				new ShowAllDialog(sb.toString());
				setVisible(false);
		}
	}

}
