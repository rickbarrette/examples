/**
 * This class is the Main class that will drive the Maze class
 */
public class MazeTester {

	/**
	 * Called when the application first starts
	 * @param args
	 */
	public static void main(String[] args) {
		char[][] m = {

		{ '*', ' ', '*', '*', '*', '*', '*', '*', '*' },

		{ '*', ' ', ' ', ' ', ' ', ' ', '*', ' ', '*' },

		{ '*', ' ', '*', '*', '*', '*', '*', ' ', '*' },

		{ '*', ' ', '*', ' ', '*', ' ', ' ', ' ', '*' },

		{ '*', ' ', '*', ' ', '*', '*', '*', ' ', '*' },

		{ '*', ' ', ' ', ' ', '*', ' ', ' ', ' ', '*' },

		{ '*', '*', '*', ' ', '*', ' ', '*', '*', '*' },

		{ '*', ' ', ' ', ' ', '*', ' ', '*', ' ', '*' },

		{ '*', '*', '*', '*', '*', '*', '*', ' ', '*' } };

		Maze maze = new Maze(m);

		System.out.println("**********The Maze**********");
		System.out.println(maze.toString());

		
		System.out.println("**********The Tests:*********\n" +
				"Walls are '*'\n" +
				"Paths are ' '\n" +
				"The Starting point is marked with 'S'\n" +
				"The Soultion Path are '.'");
		
		System.out.print("\nStarting Point:"+ 4+", "+3);
		System.out.println("escape possiable: "+ maze.escape(4, 3));

		System.out.print("\nStarting Point:"+ 5+", "+5);
		System.out.println("escape possiable: "+ maze.escape(5, 5));

		System.out.print("\nStarting Point:"+ 7+", "+1);
		System.out.println("escape possiable: "+ maze.escape(7, 1));

		// It may be necessary to test each call to "escape" independent of the
		// other calls - by commenting out the other lines
		// Do this if the maze is altered while finding an escape route
		// Please remove these last 3 comment lines in your submitted code
	}
}
