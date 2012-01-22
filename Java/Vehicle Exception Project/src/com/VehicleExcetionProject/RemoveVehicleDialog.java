package com.VehicleExcetionProject;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * This class will be the delete vehicle dialog
 */
public class RemoveVehicleDialog extends JFrame implements ActionListener {

	private static final long serialVersionUID = -36245710370532319L;
	private JButton ok;
	private JTextArea editText;

	/**
	 * Creates a new RemoveVehicleDialog
	 */
	public RemoveVehicleDialog(){
		super();
		setTitle("Delete Vehicles");
		setMinimumSize(new Dimension(590, 20));
		
		//create a JPanel to hold the text area and button
		JPanel panel = new JPanel();
		ok = new JButton("Ok");
		editText = new JTextArea();
		JLabel label = new JLabel("Enter Vehicle Make To Remove");
		ok.addActionListener(this);
		editText.setEditable(true);
		editText.setColumns(25);
		editText.setRows(1);
		
		panel.add(label);
		panel.add(editText);
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
				MainWindow.db.deleteVehicle(editText.getText());
				setVisible(false);
		}
	}

}
