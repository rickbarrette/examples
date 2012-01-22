package com.VehicleExcetionProject;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * This panel will be used to display all Vehicles in the VechicleDB
 */
public class ShowAllDialog extends JFrame {

	private static final long serialVersionUID = -8416144493079733535L;
	private JButton ok;
	private JTextArea results;

	/**
	 * Creates a new ShowAllDialog
	 */
	public ShowAllDialog(String list){
		super();
		setTitle("Show All Vehicles");
		setMinimumSize(new Dimension(590, 460));
		
		//create a JPanel to hold the text area and button
		JPanel panel = new JPanel();
		ok = new JButton("Ok");
		results = new JTextArea();
		ButtonListener listener = new ButtonListener();
		ok.addActionListener(listener);
		results.setEditable(false);
		results.setText(list);
		results.setColumns(50);
		results.setRows(25);
		JScrollPane scrollPane = new JScrollPane(results);
		setPreferredSize(new Dimension(450, 110));
		add(scrollPane, BorderLayout.CENTER);
		panel.add(scrollPane);
		panel.add(ok);
		
		//add the JPanel to the frame, and display
		getContentPane().add(panel);
		pack();
		setVisible(true);
	}
	
	/**
	 * Listener class for this JPanel
	 */
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			ShowAllDialog.this.setVisible(false);	
		}
		
	}
	
}
