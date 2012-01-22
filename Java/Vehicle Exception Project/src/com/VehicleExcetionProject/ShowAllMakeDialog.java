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
 * This class will be the dialog that will ask the user for a specific make to show
 */
public class ShowAllMakeDialog extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1750326106927701404L;
	private JButton ok;
	private JTextArea editText;

	/**
	 * Creates a new ShowAllMakeDialog
	 */
	public ShowAllMakeDialog() {
		super();
		setTitle("Search");
		setMinimumSize(new Dimension(590, 20));
		
		//create a JPanel to hold the text area and button
		JPanel panel = new JPanel();
		ok = new JButton("Ok");
		editText = new JTextArea();
		JLabel label = new JLabel("Enter Vehicle Make To Show");
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
			StringBuilder sb = new StringBuilder();
			for(Vehicle item : MainWindow.db.findVehicle(editText.getText()))
				sb.append(item.toString()+"\n");
				new ShowAllDialog(sb.toString());
				setVisible(false);
		}
	}

}
