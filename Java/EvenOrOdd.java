/**
 * @date 10, 24, 2010
 * @author ricky.barrette
 * @author Twenty Codes, LLC
 */

import java.util.Scanner;

/*
 * this class will be used to demostrate how to use an if/else block
 * @author ricky.barrette
 */
public class EvenOrOdd{
	
	/*
	 * this is the main method of the class
	 * @param args from command line
	 * @author ricky.barrette
	 */
	public static void main(String[] args){
		//prepear the variables and the sccanner for input
		Scanner scan = new Scanner(System.in);
		int input;
		//ask user for input and get the input
		System.out.print("Enter a number: ");
		input = scan.nextInt();
		//process the input and print the results
		if ( (input % 2) == 0){
			System.out.println("The number is even");
		} else {
			System.out.println("The number is odd");
		}
	}
} 
//END CLASS
