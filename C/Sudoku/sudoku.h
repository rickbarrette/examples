/**
 * sudoku.h
 * @date Oct 25, 2011
 * @author ricky barrette
 */

#define DEBUG 		false
#define PUZZLE_SIZE	9
#define BOX_SIZE	(PUZZLE_SIZE / 3)

int main();
int checkRow(int n, int r, int puzzle[PUZZLE_SIZE][PUZZLE_SIZE]);
int checkColumn(int n, int c, int puzzle[PUZZLE_SIZE][PUZZLE_SIZE]);
int checkBox(int n, int r, int c, int puzzle[PUZZLE_SIZE][PUZZLE_SIZE]);
int solve(int puzzle[PUZZLE_SIZE][PUZZLE_SIZE]);
int solve(int r, int c, int puzzle[PUZZLE_SIZE][PUZZLE_SIZE]);
void printPuzzle(int puzzle[PUZZLE_SIZE][PUZZLE_SIZE]);
int legal(int n, int r, int c, int puzzle[PUZZLE_SIZE][PUZZLE_SIZE]);