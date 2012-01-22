/**
 * @author Twenty Codes, LLC
 * @author ricky barrette
 * @date Nov 26, 2010
 */

/**
 * this is a simple class to demonstrate java's recursive ability
 * @author ricky barrette
 */
public class Main {

	/**
	 * Creates a new Main
	 * @author ricky barrette
	 */
	public Main() {
		System.out.println(factorial(5));
	}

	/**
	 * this method will calculate the factorial of an integer
	 * @param i
	 * @return the factorial of the supplied number
	 * @author ricky barrette
	 */
	private long factorial(int i) {
		/*
		 * if the number is greater than 1, then we continue
		 * else we return our results
		 */
		if(i > 1)
			return factorial(i -1) * i;
		return i;
	}

	/**
	 * main method, called when the application starts
	 * @param args
	 * @author ricky barrette
	 */
	public static void main(String[] args) {
		new Main();
	}

}
