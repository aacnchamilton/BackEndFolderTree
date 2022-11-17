package week3;

public class ArrayStringLetters {
	/*
	 * 2.	Create an array of String called names that contains the following values: “Sam”, “Tommy”, “Tim”, “Sally”, “Buck”, “Bob”.
a.	Use a loop to iterate through the array and calculate the average number of letters per name. Print the result to the console.
b.	Use a loop to iterate through the array again and concatenate all the names together, separated by spaces, and print the result to the console.

	 */
	public static void main(String[] args) {
		String[] names = {"Sam", "Tommy", "Tim", "Sally", "Buck", "Bob"};
		int sumNameLength = 0;
		
		for (String i : names) {
			sumNameLength += i.length();
		}
		
		double avgNameLength = (double) sumNameLength/names.length;
		
		System.out.println("Average length of the names: " + avgNameLength);
	}

}
