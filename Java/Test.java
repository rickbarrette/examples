/*
* this is my test class that will test a number ented to see if it is even/odd,  and if it is prime or not
* this class demonstrates how to handle:
 * arguments passed from the starting command
 * if/else blocks, for loops
 *  and how to use simple methods 
 * how to parse a String to an int
 * try/catch blocks for error checking
* @author ricky.barrette
*/
import java.util.Scanner;

public class Test{

	/*
	 * this is the main method of this program
	 * @param args from the command
	 * @author ricky.barrette
	 */
	public static void main(String args[]){
		
		long number;

		/*
		 * if the user provided input then try to parse that,
		 * if we can not parse it, then we notify the user
		 */
		if (args.length > 0){
			try{
				number = Long.parseLong(args[0]); 			
			} catch(Exception e){
				System.out.println("Sorry that was not a number, please try again");
				System.out.println(e.toString());
				number = getUserInput();
			}
		} else
			number = getUserInput();

		//output results
		System.out.println(number+" is "+ evenOrOdd(number));
		System.out.println(number+" is "+ isNumberPrime(number));		
	}

	/*
	 * returns whether or not the number is even
	 * @param number in question
	 * @author ricky.barrette
	 */
	public static String evenOrOdd(long number){
		//tell me if the number is even or odd
		if ( (number % 2) == 0 )
			return "even";
		 else 
			return "odd";
	}

	/*
	 * asks for users input
	 * @return users input
	 * @author ricky.barrette
	 */
	private static long getUserInput(){
		boolean isNumber = false;
		long number = 0;
		//retive data
		while(! isNumber){	
			try{
				// create a scanner to except user input via keyboard
				Scanner scan = new Scanner(System.in);
				//ask for users input 
				System.out.print("Enter a number:");
				number =  scan.nextLong(); 	
				isNumber = true;		
			} catch(Exception e){
				System.out.println("Sorry that was not a number, please try again");
				System.out.println(e.toString());
			}
		} 
		return number;
	}

	/*
	 * returns whether or not the number is prime
	 * @param number in question
	 * @author ricky.barrette
	 */
	public static String isNumberPrime(long number){
		//tell me if the number is prime or not
		for (long i = 2; i < number; i++){
			if ( (number % i) == 0)
				return "not prime";
		}
		return "prime";
	}
}
