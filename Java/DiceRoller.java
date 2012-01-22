import java.util.Random;
import java.util.Scanner;

/*
 * This application is a simple dice roller. It will ask the user for two values:
 * 1. quantity of dice
 * 2. number of sides
 */

class DiceRoller {

	/*
	 * The main method. It all starts here
	 */

	public static void main(String[] args) {
		Random ran = new Random();
		int rolledValue = 1;
		/*
		 * Almost done. Time to roll them dice
		 */
		 while(rolledValue != 0){
		 	rolledValue = (ran.nextInt(7));
			 System.out.println("And the roll is: " + rolledValue);
	}
		
	} //end main method
} //end class
