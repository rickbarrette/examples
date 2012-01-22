/**
 * ThousandToOne.c 
 * This program will display the numbers 1000 to 1 in the terminal
 * 
 * Note: compile option: -std=c99
 * @author ricky barrette
 * @date Oct, 24 2011
 */

#include "stdio.h"

void main(){
  for (int i = 1000; i > 0; i--){
    printf("%d\n",i);
  }
}
