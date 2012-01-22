/**
 * @date 10, 25, 2010
 * @author ricky.barrette
 * @author Twenty Codes, LLC
 */

import java.util.Scanner;

/*
 * this class will be used to demostrate how to use a while loop to deermine if a number is prime
 * @author ricky.barrette
 */
public class IsPrimeWhile{
	
	/*
	 * this is the main method of the class
	 * @param args from command line
	 * @author ricky.barrette
	 */
	public static void main(String[] args){

		//prepear the variables and the scanner for input
		Scanner scan = new Scanner(System.in);
		int input;
		int index = 2;
		boolean isPrime = true;

		//ask user for input and get the input
		System.out.print("Enter a number: ");
		input = scan.nextInt();

		//while there are more test to preform...
		while ( index < (input -1)){
			System.out.println(input +", "+ index +", "+ (input % index));
			//the number is not prime break the loop
			if ( (input % index) == 0){
				isPrime =  false;
				break;
			}
			index++;
		}

		//process the input and display the results
		if(isPrime)
			System.out.println("The number "+input+" is prime");
		else
			System.out.println("The number "+input+" is not prime");
	}

} 
//END CLASS
