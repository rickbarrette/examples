/**
 * @author Twenty Codes, LLC
 * @author ricky barrette
 * @date Nov 22, 2010
 */

/**
 * this will be the driver class to test the Ledger
 * @author ricky barrette
 */
public class Students {
	
	private int[] startingGrades = new int[] { 90, 75, 100, 60, 90, 92, 96, 100, 42, 100 };

	/**
	 * Creates a new Students
	 * @author ricky barrette
	 */
	public Students() {
		Ledger student1 = new Ledger("Student 1", startingGrades);
		
		
		System.out.println(student1.getAverage());
		
		student1.addGrade(100);
		System.out.println(student1.getAverage());
		
		int[] semester2 = new int[] { 90, 80, 70, 100, 101, 90, 90 };
		System.out.println(student1.addGrades(semester2).get(0));
		System.out.println(student1.getAverage() +"\n");
		
		for(int item : student1.getGrades()){
			System.out.print(item+", ");
		}
		
		System.out.println("\n"+student1.getAverage());
		
	}

	/**
	 * main method, called when the application starts
	 * @param args
	 * @author ricky barrette
	 */
	public static void main(String[] args) {
		new Students();
	}

}
