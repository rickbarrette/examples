package com.VehicleExcetionProject;

public class InvalidYearException extends RuntimeException {

	private static final long serialVersionUID = 7185150702544438062L;

	public InvalidYearException() {

	}

	public InvalidYearException(String message) {
		super(message);
	}
}
