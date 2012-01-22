/**
 * @author Twenty Codes, LLC
 * @author ricky barrette
 * @date Dec 7, 2010
 */

/**
 * This will be a sudoku puzzle
 * @author ricky barrette
 */
public class Sudoku {
	
	private int[][] mPuzzle;
	private final boolean DEBUG = true;

	/**
	 * Creates a new Sudoku
	 * @author ricky barrette
	 * @param puzzle 
	 */
	public Sudoku(int[][] puzzle) {
		mPuzzle = puzzle;
	}
	
	/**
	 * creates a copy of the maze that we can modify and discard
	 * @return a copy of the maze
	 */
	private int[][] makeTempMaze() {
		int[][] m = new int[mPuzzle.length][mPuzzle[0].length];
		for (int i = 0; i < m.length; i++) {
			for (int index = 0; index < m[0].length; index++) {
				m[i][index] = mPuzzle[i][index];
			}
		}
		return m;
	}
	
	/**
	 * solves the puzzle
	 * @return true if the puzzle is solvable
	 * @author ricky barrette
	 */
	public boolean solve(){
		return solve(0,0, mPuzzle);
	}
	
	/**
	 * Recursively solves a sudoku puzzle 
	 * @return true if the puzzle is solvable
	 * @author ricky barrette
	 */
	private boolean solve(int row, int column, int[][] temp){
		
		/*
		 * move on to the next row, if we have no more columns
		 */
		if (column == 9) {
            column = 0;
            if (++row == 9)
                return true;
        }
		
		/*
		 * if this spot is filled in, then lets move on
		 */
		if (temp[row][column] != 0)
			solve(row, column +1, temp);
		
		/*
		 * we are going to try every number, to find one that is valid.
		 */
		for(int i = 1; i <= 9; ++i){
			if(isValid(i, row, column, temp)){
				temp[row][column] =  i;
				if(solve(row, column +1, temp))
					return true;
			}
		}
		
		/*
		 * reset on backtrack
		 */
		temp[row][column] = 0;
	
		/*
		 * XXX This is only for testing comment out for production
		 * this allows us to watch the maze being solved
		 */
		if (DEBUG) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(puzzleToString(temp));
		}
		return false;
	}
	
	/**
	 * checks to see if the value is a valid answer for this location
	 * @param newValue in question
	 * @param row of newValue
	 * @param column of newValue
	 * @param temp puzzle
	 * @return true if the newValue is a valid answer
	 * @author ricky barrette
	 */
	private boolean isValid(int newValue, int row, int column, int[][] temp) {
		
		/*
		 * row
		 */
		for (int i = 0; i < 9; ++i)
            if (newValue == temp[i][column])
                return false;

		/*
		 * column
		 */
        for (int i = 0; i < 9; ++i)
            if (newValue == temp[row][i])
                return false;

        int boxRowOffset = (row / 3)*3;
        int boxColOffset = (column / 3)*3;
        
        /*
         * box
         */
        for (int i = 0; i < 3; ++i)
            for (int index = 0; index < 3; ++index)
                if (newValue == temp[boxRowOffset+i][boxColOffset+index])
                    return false;

        /*
         * no violations, so it's legal
         */
        return true;
	}

	/**
	 * converts the maze into a human readable string
	 * @param maze
	 * @return string for of the maze
	 */
	private String puzzleToString(int[][] puzzle){
		StringBuffer s = new StringBuffer();
		s.append("\n");
		for (int i = 0; i < puzzle.length; i++) {
			for (int index = 0; index < puzzle[0].length; index++) {
				s.append(puzzle[i][index] + " ");
			}
			s.append("\n");
		}
		return s.toString();
	}
	
	/**
	 * returns a human readable String of this maze
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		return puzzleToString(mPuzzle);
	}

}