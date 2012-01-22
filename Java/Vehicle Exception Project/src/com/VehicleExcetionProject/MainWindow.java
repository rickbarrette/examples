package com.VehicleExcetionProject;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * this is the main window and class of this application
 */
public class MainWindow extends JFrame implements ActionListener{

	private JButton search;
	private JButton addVehicle;
	private JButton addFromFile;
	private JButton removeVehicle;
	private JButton showAllVehicles;
	private JFileChooser fc;
	public static VehicleDB db;
	
	/**
	 * Generated Serial Version ID
	 */
	private static final long serialVersionUID = 1841715561053331517L;

	public MainWindow() {
		setTitle("Vehicle Database");
		JPanel panel = new JPanel();
		search = new JButton("Search");
		addVehicle = new JButton("Add Vehicle");
		addFromFile = new JButton("Add From File");
		removeVehicle = new JButton("Remove Vehicle");
		showAllVehicles = new JButton("Show All Vehicles");
		
		search.addActionListener(this);
		addVehicle.addActionListener(this);
		addFromFile.addActionListener(this);
		removeVehicle.addActionListener(this);
		showAllVehicles.addActionListener(this);
		
		panel.add(search);
		panel.add(addVehicle);
		panel.add(addFromFile);
		panel.add(removeVehicle);
		panel.add(showAllVehicles);
		
		add(panel);
		setVisible(true);
		this.setMinimumSize(new Dimension(680,70));
		
        fc = new JFileChooser();

        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        
        db = new VehicleDB();
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
			new ShowAllMakeDialog();
		}
		if (e.getSource() == addVehicle) {
			new AddVehicleDialog();
		}
		if (e.getSource() == addFromFile) {
			if(fc.showOpenDialog(MainWindow.this) == JFileChooser.APPROVE_OPTION){
				db.processFile(fc.getSelectedFile());
			}
		}
		if (e.getSource() == removeVehicle) {
			new RemoveVehicleDialog();
		}
		if (e.getSource() == showAllVehicles) {
			new ShowAllDialog(db.toString());
		}
	}			

}