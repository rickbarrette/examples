package com.VehicleExcetionProject;

public class InvalidHorsepowerException extends RuntimeException {

	private static final long serialVersionUID = -3775197702871511450L;

	public InvalidHorsepowerException() {

	}

	public InvalidHorsepowerException(String message) {
		super(message);
	}

}