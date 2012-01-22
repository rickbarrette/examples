/**
 * @author Twenty Codes, LLC
 * @author ricky barrette
 * @date Dec 18, 2010
 */

package com.TwentyCodes.java.BankAccount.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * This panel will be used to display all Vehicles in the VechicleDB
 */
public class ShowAllDialog extends JFrame implements ActionListener {

	private static final long serialVersionUID = -8416144493079733535L;

	/**
	 * Creates a new ShowAllDialog
	 */
	public ShowAllDialog(String list){
		super();
		setTitle("Show All Accounts");
		
		//create a JPanel to hold the text area and button
		JPanel panel = new JPanel();
		this.setSize(400, 540);
		
		//add the JPanel to the frame, and display
		getContentPane().add(panel);
		
		JButton ok = new JButton("Ok");
		ok.addActionListener(this);
		
		JTextArea results = new JTextArea();
		results.setEditable(false);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(results, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
						.addComponent(ok, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addComponent(results, GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(ok)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);

		
		results.setText(list);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		setVisible(false);		
	}
}
