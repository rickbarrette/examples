/**
 * @author Twenty Codes, LLC
 * @author ricky barrette
 * @date Dec 18, 2010
 */

package com.TwentyCodes.java.BankAccount.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This class will be the delete vehicle dialog
 */
public class RemoveAccounteDialog extends JFrame implements ActionListener {

	private static final long serialVersionUID = -36245710370532319L;
	private JButton ok;
	private JTextField textField;

	/**
	 * Creates a new RemoveVehicleDialog
	 */
	public RemoveAccounteDialog(){
		super();
		setTitle("Delete Accounts");
		
		//create a JPanel to hold the text area and button
		JPanel panel = new JPanel();
		ok = new JButton("Ok");
		JLabel label = new JLabel("Enter Account Owner or Number");
		ok.addActionListener(this);
		
		panel.add(label);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
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
				MainWindow.db.deleteAccounts(textField.getText());
				setVisible(false);
		}
	}

}
