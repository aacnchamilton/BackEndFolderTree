package Classwork;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*Create a List of integers using endNum: Given the value stored in the variable endNum, do the following:

-- Create a List of integers that contains the numbers from 1 to endNum.

-- Print the first element from the List using "The first number in the List is "

-- Print the last element of the List (without using the hard-coded index -- someList.get(190) is not what we want here), 
to the console using "The last number in the List is "

-- Don't forget to check if endNum is greater than zero (0), otherwise print "Your List cannot be created with a number less than one."*/

public class CodingQuestion {

	static void createList(int endNum) {
		// Write your code in this method
		if (endNum > 0) {
			List<Integer> listOfInt = new ArrayList<Integer>();
			for (int i=1;i<=endNum;i++) {
				listOfInt.add(i);
			}
			System.out.println("The first number in the List is " + listOfInt.get(0));
			System.out.println("The last number in the list is " + listOfInt.get(listOfInt.size()-1));
		} else {
			System.out.println("Your List cannot be created with a number less than one.");
		}
		
		
		
		
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int endNum = in.nextInt();
		
		createList(endNum);
	}
}
