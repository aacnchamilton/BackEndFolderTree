package week3;

public class ArrayStringLetters {
	/*
2.	Create an array of String called names that contains the following values: “Sam”, “Tommy”, “Tim”, “Sally”, “Buck”, “Bob”.
	a.	Use a loop to iterate through the array and calculate the average number of letters per name. Print the result to the console.
	b.	Use a loop to iterate through the array again and concatenate all the names together, separated by spaces, and print the result to the console.
3.	How do you access the last element of any array? =>  Use the array.length-1 to get to the last element such as array[array.length-1]
4.	How do you access the first element of any array? => The first element of the array will always be accessed by using the index of 0 (zero) such 
as array[0]
5.	Create a new array of int called nameLengths. Write a loop to iterate over the previously created names array and add the length of each name 
to the nameLengths array.
6.	Write a loop to iterate over the nameLengths array and calculate the sum of all the elements in the array. Print the result to the console.

	 */
	public static void main(String[] args) {
		String[] names = {"Sam", "Tommy", "Tim", "Sally", "Buck", "Bob"};
		int nameLengths = 0;
		
		for (String i : names) {
			nameLengths += i.length(); //sum up all of the name lengths
		}
		
		System.out.println("Sum of the length of all the names: " + nameLengths);
		
		double avgNameLength = (double) nameLengths/names.length; //calculate the average
		
		System.out.println("Average length of the names: " + avgNameLength);
	}

}
