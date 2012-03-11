/**
 * Main.java
 * @date Mar 10, 2012
 * @author ricky barrette
 * @author Twenty Codes, LLC
 */
package com.HelloWolrd;

/**
 * A sime hello world class
 * @author ricky barrette
 */
public class Main {
	
	private final static String hello;
	
	static{
		hello = "Hello, "+System.getProperties().getProperty("user.name");
	}

	/**
	 * Creates a new Main
	 * @author ricky barrette
	 */
	public Main() {
		assert hello != null;
		System.out.print(hello);
	}

	/**
	 * @param args
	 * @author ricky barrette
	 */
	public static void main(String[] args) {
		new Main();
	}

}
