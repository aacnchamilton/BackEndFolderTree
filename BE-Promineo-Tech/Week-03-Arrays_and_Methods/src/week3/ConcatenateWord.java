package week3;

import java.util.Scanner;

public class ConcatenateWord {
/*
 * 7.	Write a method that takes a String, word, and an int, n, as arguments and returns the word concatenated to itself n number of times. 
 * (i.e. if I pass in “Hello” and 3, I expect the method to return “HelloHelloHello”).
 */
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			System.out.println("Enter a word: ");
			String word = in.nextLine();
			
			System.out.println("Enter the number of times to concatenate the word: ");
			int n = in.nextInt();
			
			String concatenatedWord = concatenateWord(word, n);
			System.out.println(word + " concatenated " + n + " number of times is " + concatenatedWord);
		}
	}

private static String concatenateWord(String word, int n) {
	
	String concatenatedWord = word;
	for (int i=0;i < n-1;i++) {
		concatenatedWord += word;
	}

	return concatenatedWord;
}

}
