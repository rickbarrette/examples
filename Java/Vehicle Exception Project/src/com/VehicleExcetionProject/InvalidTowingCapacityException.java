package com.VehicleExcetionProject;

public class InvalidTowingCapacityException extends RuntimeException {

	private static final long serialVersionUID = -3525837906090455018L;

	public InvalidTowingCapacityException() {

	}

	public InvalidTowingCapacityException(String message) {
		super(message);
	}
}
