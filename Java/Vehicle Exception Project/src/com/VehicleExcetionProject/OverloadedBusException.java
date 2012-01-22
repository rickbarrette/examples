package com.VehicleExcetionProject;

public class OverloadedBusException extends RuntimeException {

	private static final long serialVersionUID = -1979540068583138964L;

	public OverloadedBusException() {

	}

	public OverloadedBusException(String message) {
		super(message);
	}
}
