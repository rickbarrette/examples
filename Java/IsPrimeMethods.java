/**
 * @date 10, 25, 2010
 * @author ricky.barrette
 * @author Twenty Codes, LLC
 */

import java.util.Scanner;

/*
 * this class will be used to demostrate how to use methods, to replace a loop
 * please note that this is not a good method to use, 
 * as it is very memory intesive, and is prone to stack overflow
 * @author ricky.barrette
 */
public class IsPrimeMethods{
	
	/*
	 * this is the main method of the class
	 * @param args from command line
	 * @author ricky.barrette
	 */
	public static void main(String[] args){

		//prepear the variables and the scanner for input
		Scanner scan = new Scanner(System.in);
		int input;

		//ask user for input and get the input
		System.out.print("Enter a number: ");
		input = scan.nextInt();

		//process the input and display the results
		if(isPrime(input))
			System.out.println("The number "+input+" is prime");
		else
			System.out.println("The number "+input+" is not prime");
	}

	/**
	 * tests id the number is prime
	 * @param number being tested
	 * @return true if the number is prime
	 * @author ricky.barrette
	 */
	private static boolean isPrime(int number){
		System.out.println("number, index, mod");
		return isPrime(number, 2);
	}

	/**
	 * test if the number provided is prime
	 * @param number being tested
	 * @param index of the test
	 * @return true if the number is prime
	 * @author ricky.barrette
	 */
	private static boolean isPrime(int number, int index){
		System.out.println(number +", "+ index +", "+ (number % index));
		//the number is not prime
		if ( (number % index) == 0)
			return false;

		// if there is another test, lets run it
		if( index < (number -1))
			return isPrime(number,  (index  +1) );

		//if we get to this point, the number is prime
		return true;
	}
} 
//END CLASS
