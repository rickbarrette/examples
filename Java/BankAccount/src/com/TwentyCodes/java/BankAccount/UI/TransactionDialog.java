/**
 * @author Twenty Codes, LLC
 * @author ricky barrette
 * @date Dec 22, 2010
 */
package com.TwentyCodes.java.BankAccount.UI;

import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import com.TwentyCodes.java.BankAccount.Account;
import com.TwentyCodes.java.BankAccount.TransactionType;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TransactionDialog extends JFrame implements ActionListener {

	private static final long serialVersionUID = -6130586697078071325L;
	private JPanel mContentPane;
	private JTextField mAmount;
	private JTextField mAccountNumber;
	private JRadioButton mDeposit;
	private JRadioButton mWithdraw;
	private JRadioButton mChargeFee;
	private JButton mBtnFind;
	private JButton mBtnOk;
	private TransactionType mType = TransactionType.DEPOSIT;
	private JLabel mErrorMsg;
	private JLabel mAccountInfoLabel;

	/**
	 * Create the frame.
	 */
	public TransactionDialog() {
		setTitle("Add Transaction");
		setBounds(100, 100, 495, 181);
		mContentPane = new JPanel();
		mContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		mContentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(mContentPane);

		JPanel panel = new JPanel();
		mContentPane.add(panel, BorderLayout.WEST);

		// create radio buttons and group them
		ButtonGroup group = new ButtonGroup();

		mDeposit = new JRadioButton("Deposit");
		mDeposit.setSelected(true);
		mWithdraw = new JRadioButton("Withdraw");
		mChargeFee = new JRadioButton("Charge Fee");
		group.add(mDeposit);
		group.add(mWithdraw);
		group.add(mChargeFee);

		// radio button action listeners
		mDeposit.addActionListener(this);
		mWithdraw.addActionListener(this);
		mChargeFee.addActionListener(this);

		JLabel lblTransationType = new JLabel("Transation Type");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addGroup(
														gl_panel.createSequentialGroup()
																.addContainerGap()
																.addComponent(
																		mDeposit))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addContainerGap()
																.addComponent(
																		lblTransationType))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addContainerGap()
																.addComponent(
																		mWithdraw))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addContainerGap()
																.addComponent(
																		mChargeFee)))
								.addContainerGap(GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel.createSequentialGroup().addContainerGap()
						.addComponent(lblTransationType)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(mDeposit)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(mWithdraw)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(mChargeFee)
						.addContainerGap(156, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		mContentPane.add(panel_1, BorderLayout.CENTER);

		JLabel lblTransationAmount = new JLabel("Transation Amount");

		mAmount = new JTextField();
		mAmount.setColumns(10);

		JLabel lblAccountNumber = new JLabel("Account Number");

		mAccountNumber = new JTextField();
		mAccountNumber.setColumns(10);

		mBtnFind = new JButton("Find");
		mBtnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		mBtnOk = new JButton("Ok");
		mBtnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1
				.setHorizontalGroup(gl_panel_1
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_1
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.TRAILING)
														.addGroup(
																Alignment.LEADING,
																gl_panel_1
																		.createSequentialGroup()
																		.addComponent(
																				lblTransationAmount)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				mAmount,
																				GroupLayout.DEFAULT_SIZE,
																				164,
																				Short.MAX_VALUE))
														.addComponent(
																mBtnOk,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addGroup(
																Alignment.LEADING,
																gl_panel_1
																		.createSequentialGroup()
																		.addComponent(
																				lblAccountNumber)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				mAccountNumber,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				mBtnFind)))
										.addGap(94)));
		gl_panel_1
				.setVerticalGroup(gl_panel_1
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_1
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblAccountNumber)
														.addComponent(
																mAccountNumber,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(mBtnFind))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblTransationAmount)
														.addComponent(
																mAmount,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(mBtnOk).addGap(41)));
		panel_1.setLayout(gl_panel_1);

		mErrorMsg = new JLabel("");
		mContentPane.add(mErrorMsg, BorderLayout.SOUTH);

		mAccountInfoLabel = new JLabel("");
		mContentPane.add(mAccountInfoLabel, BorderLayout.NORTH);

		// Action listners for ok and find buttons
		mBtnOk.addActionListener(this);
		mBtnFind.addActionListener(this);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mDeposit) {
			mType = TransactionType.DEPOSIT;
			mAmount.setEnabled(true);
		}
		if (e.getSource() == mWithdraw) {
			mType = TransactionType.WITHDRAW;
			mAmount.setEnabled(true);
		}
		if (e.getSource() == mChargeFee) {
			mType = TransactionType.CHARGE_FEE;
			mAmount.setEnabled(false);
			mAmount.setText("10.00");
		}
		if (e.getSource() == mBtnFind) {
			try {
				Account account = MainWindow.db.getAccount(Long.parseLong(mAccountNumber.getText()));
				if(account != null){
					mAccountInfoLabel.setText(account.toString());
					mErrorMsg.setText("");
				} else {
					mAccountInfoLabel.setText(""); 
					mErrorMsg.setText("No Such Account");
				}
			} catch (NumberFormatException e1) {
				mAccountInfoLabel.setText(""); 
				mErrorMsg.setText("Invalid Account Entry");
			} 
		}
		if (e.getSource() == mBtnOk) {
			try{
				switch(mType){
					case DEPOSIT:
						if(MainWindow.db.deposit(Long.parseLong(mAccountNumber.getText()), Double.parseDouble(mAmount.getText())))
							setVisible(false);
						else
							mErrorMsg.setText("No Such Account");
						break;
					case WITHDRAW:
						if(MainWindow.db.withdraw(Long.parseLong(mAccountNumber.getText()), Double.parseDouble(mAmount.getText())))
							setVisible(false);
						else
							mErrorMsg.setText("No Such Account");
						break;
					case CHARGE_FEE:
						if(MainWindow.db.chargeFee(Long.parseLong(mAccountNumber.getText())))
							setVisible(false);
						else
							mErrorMsg.setText("No Such Account");
						break;
				}
			} catch(Exception ex){
				mErrorMsg.setText("Invalid Entry, Check Input");
			}
		}
	}
}
