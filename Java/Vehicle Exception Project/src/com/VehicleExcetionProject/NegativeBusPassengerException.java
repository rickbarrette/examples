package com.VehicleExcetionProject;

public class NegativeBusPassengerException extends RuntimeException {

	private static final long serialVersionUID = 2864975327138368535L;

	public NegativeBusPassengerException() {

	}

	public NegativeBusPassengerException(String message) {
		super(message);
	}
}