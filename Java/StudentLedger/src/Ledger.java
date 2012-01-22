/**
 * @author Twenty Codes, LLC
 * @author ricky barrette
 * @date Nov 21, 2010
 */

import java.util.ArrayList;

/**
 * this will be a student ledger for grading students
 * @author ricky barrette
 */
public class Ledger {

	private ArrayList<Integer> mGradeList;
	private String mStudentName;

	/**
	 * 
	 * Creates a new Ledger
	 * @param studentName
	 * @author ricky barrette
	 */
	public Ledger(String studentName) {
		mGradeList = new ArrayList<Integer>();
		mStudentName = studentName;
	}

	/**
	 * Creates a new Ledger
	 * @param studentName
	 * @param gradeList
	 * @author ricky barrette
	 */
	public Ledger(String studentName, ArrayList<Integer> gradeList) {
		mGradeList = new ArrayList<Integer>();
		addGrades(gradeList);
		mStudentName = studentName;
	}
	
	/**
	 * Creates a new Ledger
	 * @param studentName
	 * @param gradeList
	 * @author ricky barrette
	 */
	public Ledger(String studentName, int[] gradeList) {
		mGradeList = new ArrayList<Integer>();
		addGrades(gradeList);
		mStudentName = studentName;
	}
	
	/**
	 * Adds grades from an array
	 * @param gradeList
	 * @return the list of invalid grades, or null
	 * @author ricky barrette
	 */
	public ArrayList<Integer> addGrades (int[] gradeList){
		ArrayList<Integer> badList = new ArrayList<Integer>();
		for(int item : gradeList){
			if(! addGrade(item)){
				badList.add(item);
			}
		}
		if(badList.size() != 0)
			return badList;
		return null;
	}
	
	/**
	 * adds grades from a list
	 * @param gradeList
	 * @return the list of inValid grades, or null
	 * @author ricky barrette
	 */
	public ArrayList<Integer> addGrades (ArrayList<Integer> gradeList){
		ArrayList<Integer> badList = new ArrayList<Integer>();
		for(int item : gradeList){
			if(! addGrade(item)){
				badList.add(item);
			}
		}
		if(badList.size() != 0)
			return badList;
		return null;
	}
	
	/**
	 * adds a new grade to the grade list if valid
	 * @param newGrade
	 * @return true if the grade was added
	 * @author ricky barrette
	 */
	public boolean addGrade(int newGrade){
		if(newGrade >= 0 && newGrade <= 100){
			mGradeList.add(newGrade);
			return true;
		}
		System.out.println(newGrade +" is an invalid grade");
		return false;
	}
	
	/**
	 * gets all the grades for this student
	 * @return an array containing all the grades
	 * @author ricky barrette
	 */
	public ArrayList<Integer> getGrades(){
		return mGradeList;
	}
	
	/**
	 * returns the name of the student
	 * @return student's name
	 * @author ricky barrette
	 */
	public String getStudentName(){
		return mStudentName;
	}
	
	/**
	 * computes the average grade of the student
	 * @return the students current average
	 * @author ricky barrette
	 */
	public int getAverage(){
		int total = 0;
		int count;
		for(count = 0; count < mGradeList.size(); count++){
			total = total + mGradeList.get(count);
		}
		return total / count;
	}
}