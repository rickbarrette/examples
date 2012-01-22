/**
 * Truck class with superclass
 *
 * @author Jonathan Warning
 * @version 11.01.10
 */

package com.VehicleExcetionProject;


public class Truck extends Vehicle {
	public final double MINCAPACITY = 0.5;

	private double towingCapacity;

	/*
	 * constructs a Truck object
	 */
	public Truck() {
		super();
		towingCapacity = 0;
	}

	/*
	 * constructs a Truck object
	 * 
	 * @param String aMake the make of the vehicle
	 * 
	 * @param int aYear the year of the vehicle
	 * 
	 * @param double aHorsepower the horsepower of the vehicle
	 * 
	 * @param double aTowingCapacity the towing capacity of the Truck
	 */
	public Truck(String aMake, int aYear, double aHorsepower,
			double aTowingCapacity) {
		super(aMake, aYear, aHorsepower);
		if (aTowingCapacity < MINCAPACITY)
			throw new InvalidTowingCapacityException(
					"Towing capacity cannot be less than " + MINCAPACITY);
		else
			towingCapacity = aTowingCapacity;
	}

	/*
	 * sets the towing capacity of the truck
	 * 
	 * @param double aTowingCapacity the towing capacity of the truck
	 */
	public void setTowingCapacity(double aTowingCapacity) {
		if (aTowingCapacity < MINCAPACITY)
			throw new InvalidTowingCapacityException("Towing capacity cannot be less than " + MINCAPACITY);
		else
			towingCapacity = aTowingCapacity;
	}

	/*
	 * gets the towing capacity of the truck
	 * 
	 * @return double aTowingCapacity the towing capacity of the Truck
	 */
	public double getTowingCapacity() {
		return towingCapacity;
	}

	/*
	 * calculates miles per gallon
	 * 
	 * @return double milesPerGal the miles per gallon of the Truck
	 */
	public double calculateMPG() {
		return milesPerGal = 5000 / towingCapacity / horsepower;
	}

	/*
	 * String with all of the parameters of the Truck
	 * 
	 * @return int year year of the Truck
	 * 
	 * @return String make make of the Truck
	 * 
	 * @return double horsepower horsepower of the Truck
	 * 
	 * @return double towingCapacity the towing capactiy of the truck
	 */
	@Override
	public String toString() {
		return "The towing capacity of the " + super.year + ", "
				+ super.horsepower + " horsepower " + super.make + " is "
				+ towingCapacity + " tons.";
	}

	/*
	 * Compares two trucks towing capacities
	 * 
	 * @return boolean are the trucks towing capacities equal
	 */
	@Override
	public boolean equals(Object otherObj) {
		if (otherObj instanceof Truck) {
			Truck otherTruck = (Truck) otherObj;
			return ((towingCapacity == otherTruck.towingCapacity));
		} else
			return false;
	}
}