/**
 * @author Twenty Codes, LLC
 * @author ricky barrette
 * @date Nov 21, 2010
 */

/**
 * this class will be used to demonstrate an enhanced for loop that is discussed here
 * http://download.oracle.com/javase/tutorial/java/nutsandbolts/for.html
 * We recommend using this form of the for statement instead of the general form whenever possible
 * @author ricky barrette
 */
public class Main {

	static int[] array = new int[] { 1, 2, 3, 4, 5, 6, 6, 6, 7, 8, 9, 10};
	static char[] helloWorld = new char[] { 'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd', '!'};
	
	/**
	 * called when the application is first started
	 * @param args
	 * @author ricky barrette
	 */
	public static void main(String[] args) {
		
		/*
		 * the way this works is that you provide 2 arguments for the for loop.
		 * 
		 * the first is the object to hold an item in the array, and the second is the array it self.
		 * 
		 * the to are separated by a colon.
		 * 
		 * the output for this for loop will be:
		 * 1
		 * 2
		 * 3
		 * 4
		 * 5
		 * 6
		 * 6
		 * 6
		 * 7
		 * 8
		 * 9
		 * 10
		 */
		for(int item : array){
			System.out.println(item);
		}
		
		/*
		 * here is another example, this time with a char array 
		 */
		for(char character : helloWorld){
			System.out.print(character);
		}
	}

}