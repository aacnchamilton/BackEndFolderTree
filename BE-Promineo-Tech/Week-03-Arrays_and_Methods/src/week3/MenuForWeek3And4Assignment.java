package week3;

import java.util.Scanner;

public class MenuForWeek3And4Assignment {
/*
7.	Write a method that takes a String, word, and an int, n, as arguments and returns the word concatenated to itself n number of times. 
(i.e. if I pass in �Hello� and 3, I expect the method to return �HelloHelloHello�).
8.	Write a method that takes two Strings, firstName and lastName, and returns a full name (the full name should be the first and the last name 
as a String separated by a space).
9.	Write a method that takes an array of int and returns true if the sum of all the ints in the array is greater than 100.
10.	Write a method that takes an array of double and returns the average of all the elements in the array.
11.	Write a method that takes two arrays of double and returns true if the average of the elements in the first array is greater than the 
average of the elements in the second array.
12.	Write a method called willBuyDrink that takes a boolean isHotOutside, and a double moneyInPocket, and returns true if it is hot outside 
and if moneyInPocket is greater than 10.50.
13.	Create a method of your own that solves a problem. In comments, write what the method does and why you created it.

 */
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Select a homework option to display results:");
		System.out.println("Type 7 to concatenate a word a specified number of times");
		System.out.println("Type 8 to return a persons full name");
		System.out.println("Type 9 to determine if the sum of a list of numbers is greater than 100");
		System.out.println("Type 10 to return an average of all numbers entered");
		System.out.println("Type 11 to determine if the avg of the first list of numbers is greater than the avg of the second list of numbers");
		System.out.println("Type 12 to determine if you will desire to buy a drink");
		System.out.println("Type 13 to determine if it is time to overseed the grass in Arizona");
		
		int input = in.nextInt();
		switch (input) {
			case 7:
				in.nextLine();  //This is necessary to consume the \n that nextInt() does not
				System.out.println("Enter a word: ");
				String word = in.nextLine();
					
				System.out.println("Enter the number of times to concatenate the word: ");
				int n = in.nextInt();
					
				String concatenatedWord = concatenateWord(word, n);
				System.out.println(word + " concatenated " + n + " number of times is " + concatenatedWord);
				break;
			case 8:
				in.nextLine();  //This is necessary to consume the \n that nextInt() does not
				System.out.println("Enter your first name: ");
				String fName = in.nextLine();
				System.out.println("Enter your last name: ");
				String lName = in.nextLine();
				
				String fullName = retFullName(fName, lName);
				
				System.out.println("Full Name: " + fullName);
				break;
			case 9:
				in.nextLine();
				System.out.println("Enter a comma separated list of integers");
				String listOfIntegers = in.nextLine();
				String[] numbersString = listOfIntegers.split(",",0);
				
				//System.out.println(numbersString.length);  //just for debugging
				
				int[] numbers = new int[numbersString.length];
				for (int i = 0;i<numbersString.length;i++) {
					numbers[i] = Integer.parseInt(numbersString[i]);
					//System.out.println(numbers[i]);  //debugging
				}
				
				int sum = sumNumbers(numbers);
				//System.out.println("Sum of numbers is: " + sum); //debugging
				if (sum > 100) {
					System.out.println("true");
				} else {
					System.out.println("false");
				}
				
				break;
			case 10:
				break;
			case 11:
				break;
			case 12:
				break;
			case 13:
				break;
			default:
				System.out.println("You have entered an invalid menu option");
				break;
		}
	}

private static int sumNumbers(int[] numbers) {
	int sum = 0;
	for (int x=0;x<numbers.length;x++) {
		sum += numbers[x];
	}
	return sum;
}

private static String retFullName(String fName, String lName) {
		String fullName = fName + " " + lName;
		return fullName;
	}

private static String concatenateWord(String word, int n) {
	
	String concatenatedWord = word;
	for (int i=0;i < n-1;i++) {
		concatenatedWord += word;
	}

	return concatenatedWord;
}


}
