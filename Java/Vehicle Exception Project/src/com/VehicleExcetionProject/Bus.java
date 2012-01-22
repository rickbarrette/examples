/**
 * Bus class with super class
 *
 * @author Jonathan Warning
 * @version 11.01.10
 */
package com.VehicleExcetionProject;


public class Bus extends Vehicle {
	public final int MAXPASSENGERS = 50;
	private int numOfPassengers;

	/*
	 * constructs a Bus object
	 */
	public Bus() {
		super();
		numOfPassengers = 0;
	}

	/*
	 * constructs a Bus object
	 * 
	 * @param String aMake the make of the vehicle
	 * 
	 * @param int aYear the year of the vehicle
	 * 
	 * @param double aHorsepower the horsepower of the vehicle
	 * 
	 * @param int aNumOfPassengers the number of passsengers
	 */
	public Bus(String aMake, int aYear, double aHorsepower, int aNumOfPassengers) {
		super(aMake, aYear, aHorsepower);
		if (aNumOfPassengers > MAXPASSENGERS)
			throw new OverloadedBusException(
					"Number of passengers cannot exceed " + MAXPASSENGERS);
		else if (aNumOfPassengers < 0)
			throw new NegativeBusPassengerException(
					"Number of passegers cannot be less than 0.");
		else
			numOfPassengers = aNumOfPassengers;
	}

	/*
	 * sets the number of passengers on the Bus
	 * 
	 * @param int numOfPassengers the number of passengers on the Bus
	 */
	public void setPassengers(int aNumOfPassengers) {
		if (aNumOfPassengers > MAXPASSENGERS)
			throw new OverloadedBusException(
					"Number of passengers cannot exceed " + MAXPASSENGERS);
		else if (aNumOfPassengers < 0)
			throw new NegativeBusPassengerException(
					"Number of passegers cannot be less than 0.");
		else
			numOfPassengers = aNumOfPassengers;
	}

	/*
	 * gets the number of passengers on the Bus
	 * 
	 * @return int numOfPassengers the number of passengers on the Bus
	 */
	public int getPassengers() {
		return numOfPassengers;
	}

	/*
	 * calculates miles per gallon
	 * 
	 * @return double milesPerGal the miles per gallon of the Bus
	 */
	public double calculateMPG() {
		return milesPerGal = 10000 / numOfPassengers / horsepower;
	}

	/*
	 * String with all of the parameters of the Bus
	 * 
	 * @return int year year of the Bus
	 * 
	 * @return String make make of the Bus
	 * 
	 * @return double horsepower horsepower of the Bus
	 * 
	 * @return int numOfPassengers number of passengers in Bus
	 */
	@Override
	public String toString() {
		return "The " + super.year + ", " + super.horsepower + " horsepower "
				+ super.make + " is carrying " + numOfPassengers + " people.";
	}

	/*
	 * Compares two Busses number of passengers
	 * 
	 * @return boolean are the busses number of passengers equal
	 */
	@Override
	public boolean equals(Object otherObj) {
		if (otherObj instanceof Bus) {
			Bus otherBus = (Bus) otherObj;
			return (numOfPassengers == otherBus.numOfPassengers);
		} else
			return false;
	}
}