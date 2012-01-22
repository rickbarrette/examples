/**
 * @author Twenty Codes, LLC
 * @author ricky barrette
 * @date Dec 18, 2010
 */

package com.TwentyCodes.java.BankAccount.UI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.TwentyCodes.java.BankAccount.Account;

/**
 * this class will allow the user to enter a new vehicle into the database
 */
public class AddAccountDialog extends JFrame implements ActionListener{

	private static final long serialVersionUID = 3165335189780349167L;
	private JButton ok;
	private JLabel errorMsg;
	private JTextField owner;
	private JTextField account;
	private JTextField balance;

	/**
	 * Creates a new AddAccountDialog
	 */
	public AddAccountDialog() {
		super();
		setTitle("Add Account");
		this.setSize(744, 118);
		
		
		//create a JPanel to hold the text area and button
		JPanel panel = new JPanel();
		JLabel label_1 = new JLabel("Owner: ");
		
		owner = new JTextField();
		owner.setColumns(10);
		JLabel label_2 = new JLabel("Account Number: ");
		
		account = new JTextField();
		account.setColumns(10);
		JLabel label = new JLabel("Initial Banlance: ");
		
		balance = new JTextField();
		balance.setColumns(10);
		ok = new JButton("Ok");
		ok.addActionListener(this);
		
		//add the JPanel to the frame, and display
		getContentPane().add(panel, BorderLayout.SOUTH);
		errorMsg = new JLabel("Please verify the account information, and try again");
		errorMsg.setVisible(false);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(errorMsg)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(ok, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(owner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(account, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(balance, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(877, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(owner, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(account, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(balance, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(errorMsg, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(ok))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
//		pack();
		setVisible(true);
	}

	/**
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ok) {
			try{
				long accountNumber = Long.parseLong(account.getText());
				MainWindow.db.addAccount(new Account(Double.parseDouble(balance.getText()), owner.getText(), accountNumber));
				setVisible(false);
			} catch(Exception ex){
				errorMsg.setVisible(true);
			}
		}
	}
}