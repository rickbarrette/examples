package com.VehicleExcetionProject;

public class InvalidMakeException extends RuntimeException {

	private static final long serialVersionUID = -7536710583729590772L;

	public InvalidMakeException() {

	}

	public InvalidMakeException(String message) {
		super(message);
	}

}