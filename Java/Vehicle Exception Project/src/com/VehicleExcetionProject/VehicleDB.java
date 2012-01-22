package com.VehicleExcetionProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * This class will be a vehicle database
 */
public class VehicleDB{

	private ArrayList<Vehicle> array;
	
	/**
	 * Creates a new VehicleDB
	 */
	public VehicleDB(){
		array = new ArrayList<Vehicle>(0);
	}
	
	/**
	 * returns a human readable string
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		StringBuffer sb = new StringBuffer();
		for(Vehicle item : array)
			sb.append(item.toString() +"\n");
		return sb.toString();
	}
	
	/**
	 * added the vehicle to the database
	 * @param aVehicle
	 */
	public void addVehicle(Vehicle aVehicle){
		array.add(aVehicle);
		Collections.sort(array);
	}
	
	/**
	 * finds the all occurrences of a vehicle with the make 
	 * @param make
	 * @return ta list containing all the vehicles with the provided make
	 */
	public ArrayList<Vehicle> findVehicle(String make){
		ArrayList<Vehicle> temp = new ArrayList<Vehicle>(0);
		for(Vehicle item : array)
			if(item.getMake().equals(make))
				temp.add(item);
		return temp;
	}
	
	/**
	 * removes the all occurrences of a vehicle with the make 
	 * @param make
	 */
	public void deleteVehicle(String make){
		Object[] temp = array.toArray();
		for(int index = 0; index < temp.length; index++)
			if(((Vehicle)temp[index]).getMake().equals(make)){
					temp[index] = null;
			}
		
		array.removeAll(array);
		
		for(Object item : temp)
			if(item != null)
				array.add((Vehicle)item);
	}

	/**
	 * process the file into the VehicleDB
	 * @param selectedFile
	 */
	public void processFile(File selectedFile) {
		Scanner scan = null;
		try {
			scan = new Scanner(selectedFile);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		if(scan != null){
			String model;
			while(scan.hasNextLine()){
				model = scan.next();
				if(model.toCharArray()[0] != '#'){
					try {
						if(model.equals("truck")){
							addVehicle(new Truck(scan.next(), scan.nextInt(), scan.nextDouble(), scan.nextDouble()));
						}
						if(model.equals("bus")){
							addVehicle(new Bus(scan.next(), scan.nextInt(), scan.nextDouble(), scan.nextInt()));
						}
					} catch (Exception e) {
//						e.printStackTrace();
					}
				}
			}
		}
		
	}

}