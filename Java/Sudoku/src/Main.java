/**
 * @author Twenty Codes, LLC
 * @author ricky barrette
 * @date Dec 7, 2010
 */

/**
 * Driver class to test my sudoku class
 * @author ricky barrette
 */
public class Main {
	
	int[][] puzzle = new int[][] {
			{0, 8, 0, 4, 0, 2, 0, 6, 0},
			{0, 3, 4, 0, 0, 0, 9, 1, 0},
			{9, 6, 0, 0, 0, 0, 0, 8, 4},
			{0, 0, 0, 2, 1, 6, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 3, 5, 7, 0, 0, 0},
			{8, 4, 0, 0, 0, 0, 0, 7, 5},
			{0, 2, 6, 0, 0, 0, 1, 3, 0},
			{0, 9, 0, 7, 0, 1, 0, 4, 0},
	};
	
	int[][] puzzle2 = new int[][] {
			{0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0},
	};
	
	public Main(){
		Sudoku s = new Sudoku(puzzle2);
		System.out.println(s.solve());
		System.out.println(s.toString());
		
	}
	
	/**
	 * 
	 * @param args
	 * @author ricky barrette
	 */
	public static void main (String[] args){
		new Main();
	}

}