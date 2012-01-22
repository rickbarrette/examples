/**
 * @author Twenty Codes, LLC
 * @author ricky barrette
 * @date Dec 5, 2010
 */

/**
 * This is the main driver class
 * @author ricky barrette
 */
public class Main {

	int[] mNumber = new int[]{ 1, 2, 3, 5, 45, 7, 9, 10, 16, 2, 100, 42, 23, 9, 0 };
	
	
	/**
	 * Creates a new Main
	 * @author ricky barrette
	 */
	private Main(){
		LargestNumber ln = new LargestNumber(mNumber);
		System.out.println(ln.getLargestNumber());
		System.out.println(ln.find(5));
		System.out.println(ln.find(34));
	}
	
	/**
	 * main method, this is called when the application is first started
	 * @param args
	 * @author ricky barrette
	 */
	public static void main(String[] args) {
		new Main();
	}

}