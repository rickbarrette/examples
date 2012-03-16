/**
 * Main.java
 * @date Mar 16, 2012
 * @author ricky barrette
 * @author Twenty Codes, LLC
 * 
 * Copyright 2012 Richard Barrette 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0 
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License
 */
package com.test;

/**
 * This class will be used to drive a class that uses bit fields
 * @author ricky barrette
 */
public class Main {

	/**
	 * Creates a new Main instance
	 * @author ricky barrette
	 */
	public Main() {
		/*
		 * Create a new bit field with the 8th bit set
		 */
		BitField b = new BitField(BitField.FLAG_EIGHT);
		System.out.println(b.toString());
		
		/*
		 * set the 4th and 7th bits
		 */
		b.setFlags(BitField.FLAG_FOUR | BitField.FLAG_SEVEN);
		System.out.println(b.toString());
		
		/*
		 * un-set the 8th bit
		 */
		b.removeFlags(BitField.FLAG_EIGHT);
		System.out.println(b.toString());
		
		/*
		 * set the first abd second bits
		 */
		b.setFlags(BitField.FLAG_ONE | BitField.FLAG_TWO);
		System.out.println(b.toString());
		
		/*
		 * unset the fourth and sencond bit
		 */
		b.removeFlags(BitField.FLAG_FOUR | BitField.FLAG_TWO);;
		System.out.println(b.toString());
	}

	/**
	 * This is the main method
	 * @param args
	 * @author ricky barrette
	 */
	public static void main(String[] args) {
		new Main();
	}
}