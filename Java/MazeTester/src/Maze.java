/**
 * This Maze Object is a maze made up of paths ' ' and walls '*'
 */
public class Maze {

	private char[][] mMaze;
	private char[][] mLastMaze;
	
	/*
	 * XXX this is for testing, comment out all dependencies
	 * i use this to see how the maze is being transverse'd
	 */
//	private final boolean DEBUG = true;

	/**
	 * Creates a new Maze
	 * @author ricky barrette
	 * @param m 
	 */
	public Maze(char[][] m) {
		mMaze = m;
	}
	
	/**
	 * cleans the markings from mLastMaze. leaving only the solution path, and walls
	 */
	private void cleanMaze(){
		char[][] m = new char[mLastMaze.length][mLastMaze[0].length];
		for (int i = 0; i < m.length; i++) {
			for (int index = 0; index < m[0].length; index++) {
				if(mLastMaze[i][index] == 'X')
					mLastMaze[i][index] = ' ';
				// XXX for testing only, comment out for production code
//				if (DEBUG) {
//					if (mLastMaze[i][index] == 'B')
//						mLastMaze[i][index] = ' ';
//					if (mLastMaze[i][index] == 'W')
//						mLastMaze[i][index] = '*';
//				}
				
			}
		}
	}
	
	/**
	 * checks if the current point is a path on the maze
	 * @param row
	 * @param column
	 * @param maze
	 * @return true if the point is a path
	 */
	private boolean isPath(int row, int column, char[][] maze){
		
		// XXX this if for testing, comment out for production
//		if (DEBUG) {
//			//i use this if block to see walls are encountered within the maze while being transverse'd
//			if (maze[row][column] == '*')
//				maze[row][column] = 'W';
//			//this will show me where i backtrack
//			if (maze[row][column] == 'X')
//				maze[row][column] = 'B';
//		}
		
		if(maze[row][column] == ' ')
			return true;
		return false;
	}
	
	/**
	 * finds out if you can escape this maze from the supplied starting point
	 * @param row
	 * @param coloumn
	 * @return true if the maze is escapable
	 */
	public boolean escape(int row, int column){
		mLastMaze = null;
		boolean isEscapable = escape(row, column, makeTempMaze());
		cleanMaze();
		//here we will mark the starting point with a 'S'
		mLastMaze[row][column] = 'S';
		System.out.print(mazeToString(mLastMaze));
		return isEscapable;
	}

	/**
	 * finds out if you can escape this maze from the supplied point
	 * 19 (< 20) lines of code (including }'s )
	 * @param row
	 * @param column
	 * @param tempMaze that we can mark up
	 * @return true if you can escape, false otherwise
	 */
	private boolean escape(int row, int column, char[][] tempMaze) {
		boolean done = false;

		/*
		 * if the current point is a point is a part of the path
		 * then mark it, and move forward
		 */
		if (isPath(row, column, tempMaze)) {
			tempMaze[row][column] = 'X';

			try {
				done = escape(row + 1, column, tempMaze); // down
				if (!done)
					done = escape(row, column + 1, tempMaze); // right
				if (!done)
					done = escape(row - 1, column, tempMaze); // up
				if (!done)
					done = escape(row, column - 1, tempMaze); // left
			} catch (ArrayIndexOutOfBoundsException e) {
				/*
				 * if we get this, that mean we can escape the maze...
				 * so We escaped the maze! yay!
				 */
				done = true;
			}
			
			/*
			 * if done, then mark the point as part of the final escape path
			 */
			if (done) 
				tempMaze[row][column] = '.';
		}
		
		/*
		 * XXX This is only for testing comment out for production
		 * this allows us to watch the maze being solved
		 */
//		if (DEBUG) {
//			try {
//				Thread.sleep(50);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			System.out.println(mazeToString(tempMaze));
//		}
		
		//pass the tempMaze to mLastMaze
		mLastMaze = tempMaze;
		
		return done;
	}
	
	/**
	 * creates a copy of the maze that we can modify and discard
	 * @return a copy of the maze
	 */
	private char[][] makeTempMaze() {
		char[][] m = new char[mMaze.length][mMaze[0].length];
		for (int i = 0; i < m.length; i++) {
			for (int index = 0; index < m[0].length; index++) {
				m[i][index] = mMaze[i][index];
			}
		}
		return m;
	}

	/**
	 * converts the maze into a human readable string
	 * @param maze
	 * @return string for of the maze
	 */
	private String mazeToString(char[][] maze){
		StringBuffer s = new StringBuffer();
		s.append("\n");
		for (int i = 0; i < maze.length; i++) {
			for (int index = 0; index < maze[0].length; index++) {
				s.append(maze[i][index] + " ");
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
		return mazeToString(mMaze);
	}
}