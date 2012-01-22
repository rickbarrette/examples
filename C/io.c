/**
 * io.c
 * This program will demonstrate basic I\O
 * @author ricky barrette
 * @date Oct 24, 2011
 */

#include <iostream>
using namespace std;

void main ()
{
  int i;
  cout << "Please enter an integer value: ";
  cin >> i;
  cout << "The value you entered is " << i;
  cout << " and its double is " << i*2 << ".\n";
}
