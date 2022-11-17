package week3;

public class ArrayIntSubtract {

	public static void main(String[] args) {
		int[] ages = {3, 9, 23, 64, 2, 8, 28, 93};
		int firstFromLast = ages[ages.length-1]-ages[0];
		System.out.println("Subtract the first array value from the last array value: " + firstFromLast);
		int sumAgesArray = 0;
		
		for (int i=0;i<ages.length;i++) {
			sumAgesArray += ages[i];
		}
		
		double avgAge = (double) sumAgesArray/ages.length;  //use a double to capture the fraction of the age average
		
		System.out.println("The average age in the array is " + avgAge);
		

	}

}
