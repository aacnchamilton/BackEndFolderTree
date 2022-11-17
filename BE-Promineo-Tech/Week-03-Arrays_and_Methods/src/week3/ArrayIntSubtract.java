package week3;

public class ArrayIntSubtract {
/*  
 * 1.	Create an array of int called ages that contains the following values: 3, 9, 23, 64, 2, 8, 28, 93.
a.	Programmatically subtract the value of the first element in the array from the value in the last element of the array (i.e. do not use ages[7] 
in your code). Print the result to the console.  
b.	Add a new age to your array and repeat the step above to ensure it is dynamic (works for arrays of different lengths).
c.	Use a loop to iterate through the array and calculate the average age. Print the result to the console.

 */
	public static void main(String[] args) {
		int[] ages = {3, 9, 23, 64, 2, 8, 28, 93};
		int firstFromLast = ages[ages.length-1]-ages[0];
		System.out.println("Subtract the first array value from the last array value: " + firstFromLast);
		int sumAgesArray = 0;
		
//		for (int i=0;i<ages.length;i++) {
//			sumAgesArray += ages[i];
//		}
		
		for (int i : ages) {
			sumAgesArray += i;
		}
		
		double avgAge = (double) sumAgesArray/ages.length;  //use a double to capture the fraction of the age average
		
		System.out.println("The average age in the array is " + avgAge);
		

	}

}
