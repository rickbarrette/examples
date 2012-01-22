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
 * this class will allow the user to enter a new vehicle into the database
 */
public class AddVehicleDialog extends JFrame implements ActionListener{

	private static final long serialVersionUID = 3165335189780349167L;
	private JButton ok;
	private JTextArea model;
	private JTextArea make;
	private JTextArea year;
	private JTextArea hp;
	private JTextArea cap;

	/**
	 * Creates a new AddVehicleDialog
	 */
	public AddVehicleDialog() {
		super();
		setTitle("Add Vehicle");
		setMinimumSize(new Dimension(590, 20));
		
		//create a JPanel to hold the text area and button
		JPanel panel = new JPanel();
		ok = new JButton("Ok");
		ok.addActionListener(this);
		model = new JTextArea();
		model.setEditable(true);
		model.setColumns(10);
		model.setRows(1);
		
		make = new JTextArea();
		make.setEditable(true);
		make.setColumns(10);
		make.setRows(1);
		
		year = new JTextArea();
		year.setEditable(true);
		year.setColumns(10);
		year.setRows(1);
		
		hp = new JTextArea();
		hp.setEditable(true);
		hp.setColumns(10);
		hp.setRows(1);
		
		cap = new JTextArea();
		cap.setEditable(true);
		cap.setColumns(10);
		cap.setRows(1);
		
		panel.add(new JLabel("Model: "));
		panel.add(model);
		panel.add(new JLabel("Make: "));
		panel.add(make);
		panel.add(new JLabel("Year: "));
		panel.add(year);
		panel.add(new JLabel("Horse Power: "));
		panel.add(hp);
		panel.add(new JLabel("Capacity: "));
		panel.add(cap);
		
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
			try{
				if(model.getText().equals("truck")){
					MainWindow.db.addVehicle(new Truck(make.getText(), Integer.parseInt(year.getText()), Double.parseDouble(hp.getText()), Double.parseDouble(cap.getText())));
				}
				if(model.getText().equals("bus")){
					MainWindow.db.addVehicle(new Bus(make.getText(), Integer.parseInt(year.getText()), Double.parseDouble(hp.getText()), Integer.parseInt(cap.getText())));;
				}
				setVisible(false);
			} catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}
}