import java.util.Scanner;

/**
 * @author Twenty Codes, LLC
 * @author ricky barrette
 * @date Nov 18, 2010
 */

/**
 * This is a simple temp converter application
 * 
 * @author ricky barrette
 */
public class TempConverter {

	/**
	 * This is the main method of this application
	 * 
	 * @param args
	 * @author ricky barrette
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Scanner scanInput;
		String input;
		boolean isValid = false;
		boolean isNumber;
		double value = 0;
		double answer = 0;

		/*
		 * the following code will be used for units: 
		 * 0 F 
		 * 1 C 
		 * 2 R 
		 * 3 K
		 */
		int startingUnit = -1;
		int endingUnit = -1;

		System.out.println("*****************************************************************\n"
				+ "This is ricky's temp converter\n" +
				  "The format used here will be <value> <values unit> <desired unit>\n" +
				  "example: 32.0 F C\n" +
				  "The output will be: 0 °C\n" +
				  "Supported units are °F, °C, °R, °K\n"
				+ "*****************************************************************");
		
		/*
		 * here we will get the users input and process it
		 */
		do {
			isValid = true;
			System.out.print("please enter the desired temp conversion:");
			input = scan.nextLine();
			
			scanInput = new Scanner(input);
			
			/*
			 * here we will get the first token from the provided string
			 */
			try {
				value = scanInput.nextFloat();
				isNumber = true;
			} catch (Exception e) {
				System.out.print("Sorry that was not a valid entry, please try again");
				isNumber = false;
				isValid = false;
			}
			
			/*
			 * if the first token was a valid entry, then lets check the next token
			 */
			if (isNumber) {
				String unit = null;
				try {
					unit = scanInput.next();
					if (unit.equalsIgnoreCase("f")) {
						startingUnit = 0;
					} else if (unit.equalsIgnoreCase("c")) {
						startingUnit = 1;
					} else if (unit.equalsIgnoreCase("r")) {
						startingUnit = 2;
					} else if (unit.equalsIgnoreCase("k")) {
						startingUnit = 3;
					} else {
						isValid = false;
					}
				} catch (Exception e1) {
					isValid = false;
				}
					
				/*
				 * now the last token
				 */
				String newUnit = null;
				try {
					newUnit = scanInput.next();
					if (newUnit.equalsIgnoreCase("f")) {
						endingUnit = 0;
					} else if (newUnit.equalsIgnoreCase("c")) {
						endingUnit = 1;
					} else if (newUnit.equalsIgnoreCase("r")) {
						endingUnit = 2;
					} else if (newUnit.equalsIgnoreCase("k")) {
						endingUnit = 3;
					} else {
						isValid = false;
					}
				} catch (Exception e) {
					isValid = false;
				}
				
				
			}
		} while (!isValid);
		
		/*
		 * This switch block will handle figuring out which equation to use
		 * now that we have a valid entry, its time for some math!
		 * Remember:
		 * 0 F 
		 * 1 C 
		 * 2 R 
		 * 3 K
		 */
		switch(startingUnit){
			case 0:
				switch(endingUnit){
					case 0:
						answer = value;
						break;
					case 1:
						answer = ((5.0/9.0) * (value - 32));
						break;
					case 2:
						answer = value + 460;
						break;
					case 3:
						answer = (5.0/9.0) * (value - 32);
						answer = answer + 273;
						break;
				}
				break;
				
			case 1:
				switch(endingUnit){
					case 0:
						answer = ((9.0/5.0) * value) + 32;
						break;
					case 1:
						answer = value;
						break;
					case 2:
						answer = ((9.0/5.0) * value) + 32;
						answer = answer + 460;
						break;
					case 3:
						answer  = value + 273;
						break;
				}
				break;
				
			case 2:
				switch(endingUnit){
					case 0:
						answer = value - 460;
						break;
					case 1:
						answer = value - 460;
						answer = (5.0/9.0) * (answer - 32);
						break;
					case 2:
						answer = value;
						break;
					case 3:
						answer = value - 460;
						answer = ((5.0/9.0) * (answer - 32));
						answer = answer + 273;
						break;
				}
				break;
				
			case 3:
				switch(endingUnit){
					case 0:
						answer = value - 273;
						answer = ((9.0/5.0) * answer) + 32;
						break;
					case 1:
						answer = value - 273;
						break;
					case 2:
						answer = value - 293;
						answer = ((9.0/5.0) * answer) + 32;
						answer = answer + 460;
						break;
					case 3:
						answer = value;
						break;
				}
				break;
		}
		
		switch(endingUnit){
			case 0:
				System.out.println(answer +"°F");
				break;
			case 1:
				System.out.println(answer +"°C");
				break;
			case 2:
				System.out.println(answer +"°R");
				break;
			case 3:
				System.out.println(answer+"°K");
				break;
		}
	}
}