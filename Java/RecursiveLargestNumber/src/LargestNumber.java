import java.util.Arrays;

/**
 * @author Twenty Codes, LLC
 * @author ricky barrette
 * @date Dec 5, 2010
 */

/**
 * 
 * @author ricky barrette
 */
public class LargestNumber {

	private int[] mNumbers;

	/**
	 * Creates a new LargestNumber
	 * @author ricky barrette
	 */
	public LargestNumber(int[] numbers) {
		mNumbers = numbers;
		sortArray();
	}
	
	/**
	 * sorts the array
	 * 
	 * @author ricky barrette
	 */
	private void sortArray() {
		Arrays.sort(mNumbers);
//		for(int item : mNumbers)
//			System.out.print(item+" ");
//		System.out.println();
	}

	/**
	 * returns the largest number
	 * @return
	 * @author ricky barrette
	 */
	public int getLargestNumber(){
		return mNumbers[mNumbers.length-1];
//		return getLargestNumber(0, 0);
	}

	/**
	 * returns the largest number in the array
	 * @param i
	 * @param index
	 * @return the largest number in the array
	 * @deprecated since we started sorting the array
	 * @author ricky barrette
	 */
	private int getLargestNumber(int i, int index) {
		try{
			if (mNumbers[index] > i)
				i = mNumbers[index];
		} catch (ArrayIndexOutOfBoundsException e){
			return i;
		} finally {
			index++;
		}
		return getLargestNumber(i, index);
	}
	
	
	/**
	 * finds a number in a sorted array
	 * @param number to find
	 * @return true if the number exist
	 * @author ricky barrette
	 */
	public boolean find(int number){
		int min= 0, max = mNumbers.length - 1;
		return find(number, min, min + ((max - min) / 2), max) != -1 ? true : false;
	}

	/**
	 * Recursively finds a number in the array
	 * @param number
	 * @param min
	 * @param mid
	 * @param max
	 * @return the index of the value, or -1 if it doesn't exist
	 * @author ricky barrette
	 */
	private int find(int number, int min, int mid, int max) {
//		System.out.println(min+", "+mid+", "+max);
		
		/*
		 * if the min, mid, max is what were looking for, then
		 * lets return the designated index
		 */
		if (mNumbers[min] == number) {
			return min;
		}
		if (mNumbers[mid] == number) {
			return mid;
		}
		if (mNumbers[max] == number) {
			return max;
		}
		
		/*
		 * if we get to this point, lets prep our values for the next round 
		 */
		if (mNumbers[mid] < number) {
			min = mid;
		}
		if (mNumbers[mid] > number) {
			max = mid;
		}
		mid =  min + ((max - min) / 2);
		
		/*
		 * if the mid is == max -1 then we will exit, or we will loop indefinitely
		 */
		if(mid == max-1)
			return -1;
		
		return find( number, min, mid, max);
	}

}