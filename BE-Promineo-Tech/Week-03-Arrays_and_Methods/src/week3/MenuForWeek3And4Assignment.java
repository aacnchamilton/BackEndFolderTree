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
		int input = -1;
		
		while (input != 0) {
			System.out.println("Select a homework option to display results:");
			System.out.println("Type 1 to subtract the first integer of the array from the last, then calculate the average of the integers");
			System.out.println("Type 2 to calculate the avg number of letters from a list of names then print the names to the console");
			System.out.println("Type 3 to Show how to access the last element of an array");
			System.out.println("Type 4 to Show how to access the first element of an array");
			System.out.println("Type 6 to Display the sum of the lengths of all the names in a list");
			System.out.println("Type 7 to concatenate a word a specified number of times");
			System.out.println("Type 8 to return a persons full name");
			System.out.println("Type 9 to determine if the sum of a list of numbers is greater than 100");
			System.out.println("Type 10 to return an average of all numbers entered");
			System.out.println("Type 11 to determine if the avg of the first list of numbers is greater than the avg of the second list of numbers");
			System.out.println("Type 12 to determine if you will desire to buy a drink");
			System.out.println("Type 13 to determine if it is time to overseed the grass in Arizona");
			System.out.println("Type 0 (zero) to Exit");
			
			input = in.nextInt();
			in.nextLine();  //This is necessary to consume the \n that nextInt() does not
			
			switch (input) {
			case 1:
				int[] ages = returnArrayOfInts(in);
				int firstFromLast = ages[ages.length-1]-ages[0];
				System.out.println("Subtract the first array value from the last array value: " + firstFromLast);
				
				System.out.println("Try it with a different array of integers:");
				
				ages = returnArrayOfInts(in);
				firstFromLast = ages[ages.length-1]-ages[0];
				System.out.println("Subtract the first array value from the last array value: " + firstFromLast);
				
				int sumAgesArray = 0;
				for (int i : ages) {
					sumAgesArray += i;
				}
				
				double avgAge = (double) sumAgesArray/ages.length;  //use a double to capture the fraction of the age average
				
				System.out.println("The average age in the array is " + avgAge);
				break;
			case 2:
				String[] names = returnArrayOfNames(in);
				int sum = 0;			
				for (String i : names) {
					sum += i.length(); //sum up all of the name lengths
				}
				
				//System.out.println("Sum of the length of all the names: " + nameLengths);
				
				double avgNameLength = (double) sum/names.length; //calculate the average
				
				System.out.println("Average length of the names: " + avgNameLength);
				String concatenateNames = "";
				for (String i : names) {
					concatenateNames += i + " ";
				}
				System.out.println("Names concatenated together: " + concatenateNames);
				break;
			case 3:
				System.out.println("Use the array.length-1 to get to the last element such as array[array.length-1]");
				break;
			case 4:
				System.out.println("The first element of the array will always be accessed by using the index of 0 (zero) such as array[0]");
				break;
			case 6:
				String[] namesArray = returnArrayOfNames(in);
				int[] nameLengths = new int[namesArray.length];	
				int sumLengths = 0;
				for (int i=0;i<nameLengths.length;i++) {
					nameLengths[i] += namesArray[i].length(); //convert each length of the elements in a String array to an array of integers;
					sumLengths += nameLengths[i];					
				}

				System.out.println("The sum of the lengths of all the names is " + sumLengths);
				
				break;
			case 7:
				System.out.println("Enter a word: ");
				String word = in.nextLine();
					
				System.out.println("Enter the number of times to concatenate the word: ");
				int n = in.nextInt();
					
				System.out.println(word + " concatenated " + n + " number of times is " + concatenateWord(word, n));
				break;
			case 8:
				System.out.println("Enter your first name: ");
				String fName = in.nextLine();
				System.out.println("Enter your last name: ");
				String lName = in.nextLine();

				System.out.println("Full Name: " + retFullName(fName, lName));
				break;
			case 9:
				System.out.println("The statment that the sum of numbers you entered is greater than 100 is: " + sumNumbersGT100(returnArrayOfInts(in))); //debugging
	
				break;
			case 10:
				double[] arrayOfDoubles = returnArrayOfDoubles(in);
								
				System.out.println("Average of the list of numbers is: " + avgNumbers(arrayOfDoubles)); //debugging
				break;
			case 11:
				double[] firstDoubles = returnArrayOfDoubles(in);
				double[] secondDoubles = returnArrayOfDoubles(in);
								
				//avgNumbers(doubles);
				System.out.println("The statement that the average value of the first list of numbers is greater than the average of the second list of numbers is: " + compareAvgListDoubles(firstDoubles, secondDoubles)); //debugging
				break;
			case 12:
				System.out.println("Is it hot outside? true/false");
				boolean hotOutside = in.nextBoolean();

				System.out.println("How much money do you have in your pocket?");
				double moneyInPocket = in.nextDouble();
				
				System.out.println("Will you buy a drink? " + willBuyDrink(hotOutside, moneyInPocket));
				break;
			case 13:
				System.out.println("Is it time to overseed in Arizona?  Enter the number of the month to find out.");
				System.out.println(correctMonthToOverSeed(in.nextInt())); 
				break;
			case 0:
				//System.out.println("Are you sure you want to exit? Y/N");
				break;
			default:
				System.out.println("You have entered an invalid menu option");
				break;
			}
			
			System.out.println(" ");
			System.out.println("***********************************");
			System.out.println(" ");
		}
		
	}

private static String[] returnArrayOfNames(Scanner in) {
	System.out.println("Enter a comma separated list of names");
	String listOfNames = in.nextLine();
	listOfNames = listOfNames.replace(" ","");
	String[] namesString = listOfNames.split(",",0);

	return namesString;
}

private static String correctMonthToOverSeed(int nextInt) {
	if (nextInt == 10) {
		return "Yes";
	} else {
		return "No";
	}
}

private static boolean willBuyDrink(boolean isItHotOutside, double moneyInPocket) {
//	System.out.println("isItHotOutside: " + isItHotOutside);
//	System.out.println("moneyInPocket: " + moneyInPocket);
	if (isItHotOutside && moneyInPocket > 10.5) {
		return true;
	} else {
		return false;
	}
}

private static int[] returnArrayOfInts(Scanner in) {
	System.out.println("Enter a comma separated list of integers");
	String listOfIntegers = in.nextLine();
	listOfIntegers = listOfIntegers.replace(" ","");
	String[] integersString = listOfIntegers.split(",",0);
	
	//System.out.println(doublesString.length);  //just for debugging
	
	int[] integers = new int[integersString.length];
	for (int i = 0;i<integersString.length;i++) {
		integers[i] = Integer.parseInt(integersString[i]);
		//System.out.println(doubles[i]);  //debugging
	}
	return integers;
}

private static double[] returnArrayOfDoubles(Scanner in) {
	System.out.println("Enter a comma separated list of numbers (may include decimals)");
	String listOfDoubles = in.nextLine();
	String[] doublesString = listOfDoubles.split(",",0);
	
	//System.out.println(doublesString.length);  //just for debugging
	
	double[] doubles = new double[doublesString.length];
	for (int i = 0;i<doublesString.length;i++) {
		doubles[i] = Double.parseDouble(doublesString[i]);
		//System.out.println(doubles[i]);  //debugging
	}
	return doubles;
}

private static boolean compareAvgListDoubles(double[] firstDoubles, double[] secondDoubles) {
	double firstAvg = avgNumbers(firstDoubles);
	double secondAvg = avgNumbers(secondDoubles);
	if (firstAvg > secondAvg) {
		return true;
	} else {
		return false;
	}
}

private static double avgNumbers(double[] numbers) {
	double avg = 0;
	double sum = 0;
	for (int i=0;i<numbers.length;i++) {
		sum += numbers[i];
	}
	avg = sum/numbers.length;
	return avg;
}

private static boolean sumNumbersGT100(int[] numbers) {
	int sum = 0;
	for (int x=0;x<numbers.length;x++) {
		sum += numbers[x];
	}
	if (sum > 100) {
		return true;
	} else {
		return false;
	}
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
