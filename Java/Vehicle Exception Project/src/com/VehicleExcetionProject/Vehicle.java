/**
 * Vehicle class with subclasses
 *
 * @author Jonathan Warning
 * @version 10.20.10
 */

package com.VehicleExcetionProject;


public abstract class Vehicle implements Cloneable, Comparable<Vehicle> {
	protected String make;
	protected int year;
	protected double horsepower;
	protected double milesPerGal;

	/*
	 * constructs a vehicle object
	 */
	public Vehicle() {
		make = "";
		year = 0;
		horsepower = 0;

		if (make.length() == 0)
			throw new InvalidMakeException("Vehicle must parameters.");
		if (year <= 0)
			throw new InvalidYearException("Vehicle must parameters.");
		if (horsepower <= 0)
			throw new InvalidHorsepowerException("Vehicle must parameters.");
	}

	/*
	 * constructs a vehicle object
	 * 
	 * @param String aMake the make of the vehicle
	 * 
	 * @param int aYear the year of the vehicle
	 * 
	 * @param double aHorsepower the horsepower of the vehicle
	 */
	public Vehicle(String aMake, int aYear, double aHorsepower) {
		if (aMake.length() == 0)
			throw new InvalidMakeException("Vehicle must have a make.");
		else
			make = aMake;

		if (aYear <= 0)
			throw new InvalidYearException("Vehicle must have been made A.D.");
		else
			year = aYear;

		if (aHorsepower <= 0)
			throw new InvalidHorsepowerException(
					"Vehicle must have positive horsepower.");
		else
			horsepower = aHorsepower;
	}

	/*
	 * Sets the make of the vehicle
	 * 
	 * @param String aMake the make of the vehicle
	 */
	public void setMake(String aMake) {
		if (aMake.length() == 0)// (aMake.equalsIgnoreCase(""))
			throw new InvalidMakeException("Vehicle must have a make.");
		else
			make = aMake;
	}

	/*
	 * Sets the year of the vehicle
	 * 
	 * @param int aYear the year of the vehicle
	 */
	public void setYear(int aYear) {
		if (aYear <= 0)
			throw new InvalidYearException("Vehicle must have been made A.D.");
		else
			year = aYear;
	}

	/*
	 * Sets the horsepowers of the vehicle
	 * 
	 * @param double aHorsepower the horsepower of the vehicle
	 */
	public void setHorsepower(double aHorsepower) {
		if (aHorsepower <= 0)
			throw new InvalidHorsepowerException(
					"Vehicle must have positive horsepower.");
		else
			horsepower = aHorsepower;
	}

	/*
	 * gets the make of the vehicle
	 * 
	 * @return String make the make of the vehicle
	 */
	public String getMake() {
		return make;
	}

	/*
	 * gets the year of the vehicle
	 * 
	 * @return int year the year of the vehicle
	 */
	public int getYear() {
		return year;
	}

	/*
	 * gets the horsepower of the vehicle
	 * 
	 * @return double horsepower the horsepower of the vehicle
	 */
	public double getHorsepower() {
		return horsepower;
	}

	/*
	 * abstract method to calculate MPG classes that implement Vehicle must the
	 * calculateMPG method
	 */
	public abstract double calculateMPG();

	/*
	 * String with all of the parameters of the class
	 * 
	 * @return int year year of the Vehicle
	 * 
	 * @return String make make of the Vehicle
	 * 
	 * @return double horsepower horsepower of the Vehicle
	 */
	public String toString() {
		return "The " + year + " " + make + " has " + horsepower + " hp.";
	}

	/*
	 * Compares two Vehicles milesPerGal
	 * 
	 * @return boolean are the objects milesPerGal equal
	 */
	public boolean equals(Object otherObj) {
		Vehicle otherVehicle = (Vehicle) otherObj;
		return (this.milesPerGal == otherVehicle.milesPerGal);
	}

	/*
	 * makes a deep copy of a Vehicle object
	 * 
	 * @return Object a deep copy of the object
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
	/**
	 * compares vehicle by make
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Vehicle vehicle){
		return this.make.compareTo( vehicle.make );
	}
}
