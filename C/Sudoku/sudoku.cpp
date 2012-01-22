 
/**
 * sudoku.cpp
 * 
 * This program will be used to solve sudoku puzzles
 * 
 * @date oct, 25, 2011
 * @author ricky barrette
 */

#include <iostream>
#include "sudoku.h"

int mPuzzle[PUZZLE_SIZE][PUZZLE_SIZE] = {	{6,0,0, 8,3,0, 0,4,0},
						{0,8,5, 1,0,0, 0,0,0},
						{0,0,0, 0,0,0, 0,0,0},
		    
						{4,0,0, 0,6,0, 0,8,0},
						{0,0,0, 0,0,8, 0,0,3},
						{1,6,0, 0,0,2, 0,0,0},
					    
						{0,0,9, 0,0,3, 0,1,0},
						{0,5,0, 6,0,0, 0,0,0},
						{0,1,0, 0,4,0, 2,9,0}	};

int mCount = 0;

/**
 * Main function
 */
int main(){
  std::cout << "\nHello World, Sudoku!\n\n\n";
  
  printPuzzle(mPuzzle);
  
  if(solve(mPuzzle) == 0) {
    std::cout << "NO SOLUTION\n";
    std::cout << mCount;
   std::cout << " trys\n\n";
  } else {
   std::cout << "\nSolved in ";
   std::cout << mCount;
   std::cout << " trys\n\n";
   
   printPuzzle(mPuzzle);
  }
  return 1;
}

/**
 * Checks the Row
 * @returns 1 if legal, 0 if illegal
 * @author ricky barrette
 */
int checkRow(int n, int r, int puzzle[PUZZLE_SIZE][PUZZLE_SIZE]){
  for(int index = 0; index < PUZZLE_SIZE; index++)
      if(n == puzzle[r][index])
	return 0;
   return 1;
}

/**
 * Checks the  Column
 * @returns 1 if legal, 0 if illegal
 * @author ricky barrette
 */
int checkColumn(int n, int c, int puzzle[PUZZLE_SIZE][PUZZLE_SIZE]){
  for(int index = 0; index < PUZZLE_SIZE; index++)
      if(n == puzzle[index][c])
	return 0;
   return 1;
}

/**
 * Checks the "Box"
 * @returns 1 if legal, 0 if illegal
 * @author ricky barrette
 */
int checkBox(int n, int r, int c, int puzzle[PUZZLE_SIZE][PUZZLE_SIZE]){
  r = (r/BOX_SIZE)*BOX_SIZE;
  c = (c/BOX_SIZE)*BOX_SIZE;
  
  for(int ri = 0; ri < BOX_SIZE; ri++)
    for(int ci = 0; ci < BOX_SIZE; ci++)
	if(n == puzzle[r+ri][c+ci])
	  return 0;
  
  //no violations
  return 1;
}

/**
 * Solves a sudoku puzzle
 * @returns 1 if solvable, 0 if not
 * @author ricky barrette
 */
int solve(int puzzle[PUZZLE_SIZE][PUZZLE_SIZE]){
  return solve(0,0, puzzle);
}

/**
 * Solves a sudoku puzzle
 * @returns 1 if solvable, 0 if not
 * @author ricky barrette
 */
int solve(int r, int c, int puzzle[PUZZLE_SIZE][PUZZLE_SIZE]){
  
  if(DEBUG){
    sleep(1);
    printPuzzle(puzzle);
  }
  
  mCount++;
   
  if (r == PUZZLE_SIZE) {
    r = 0;
    if (++c == PUZZLE_SIZE)
      return 1;
  }
  //skip filled cells
  if (puzzle[r][c] != 0)
    return solve(r+1,c,puzzle);

  for (int n = 1; n <= PUZZLE_SIZE; n++) {
    if (legal(n,r,c,puzzle) == 1) {
      puzzle[r][c] = n;
      if (solve(r+1,c,puzzle) == 1)
	return 1;
    }
  }
  //reset on backtrack
  puzzle[r][c] = 0;
  return 0;
}

/**
 * Prints the puzzle onto the screen
 * @author ricky barrette
 */
void printPuzzle(int puzzle[PUZZLE_SIZE][PUZZLE_SIZE]){
  
  for(int ri = 0; ri < PUZZLE_SIZE; ri++){
    for(int ci = 0; ci < PUZZLE_SIZE; ci++){ 
      std::cout << puzzle[ri][ci];
      //format: break for groups of BOX_SIZE
      if(ci % BOX_SIZE == 2)
	std::cout <<"  ";
    }
    //format: break columns of BOX_SIZE
    if(ri % BOX_SIZE == 2)
	std::cout <<"\n";
    //format: break for new row
    std::cout << "\n";
  }
  std::cout <<"\n-------------\n";
}

/**
 * Checks the puzzle if it is legal
 * @returns 1 if legal; 0 if not
 * @author ricky barrette
 */
int legal(int n, int r, int c, int puzzle[PUZZLE_SIZE][PUZZLE_SIZE]){
  if(checkRow(n, r, puzzle) == 1)
    if(checkColumn(n, c, puzzle) == 1)
      if(checkBox(n, r, c, puzzle) == 1)
	return 1;
  return 0;
}
