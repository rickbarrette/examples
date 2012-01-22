/**
 * @author Twenty Codes, LLC
 * @author ricky barrette
 * @date Oct 31, 2010
 */

import java.util.Scanner;

/**
 * this is my example class for is prime
 * @author ricky barrette
 */
public class IsPrime {

	/*
	 * this is the main method of the class
	 * 
	 * @param args from command line
	 * 
	 * @author ricky.barrette
	 */
	public static void main(String[] args) {

		int input = 0;
		boolean isPrime = true;
		boolean isNumber;

		/*
		 * we ask the user for input
		 * if they don't enter an int, ask for input again
		 */
		do{
			Scanner scan = new Scanner(System.in);
			System.out.print("Enter an Integer: ");
			isNumber = true;
			try {
				input = scan.nextInt();
			} catch (Exception e) {
				System.out.println("Please try agian");
				isNumber = false;
			}
		}while(! isNumber);

		System.out.println("number, index, mod");
		
		// process the input
		for (int i = 2; i < input; i++) {
			System.out.println(input +", "+ i +", "+ (input % i));
			if ((input % i) == 0) {
				isPrime = false;
				// there is not point of continuing, break the loop (aka stop)
				break;
			}
		}

		// display the results
		if (isPrime)
			System.out.println("The number is prime");
		else
			System.out.println("The number is not prime");
	}

}