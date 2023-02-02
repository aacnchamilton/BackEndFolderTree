import java.util.Random;

public class TestDemo {

	public int addPositive(int a, int b){
		if (a > 0 && a > b) {
			return a + b;
		} else {
			throw new IllegalArgumentException("Both parameters must be positive.");
		}
		
	}
	
	public int randomNumberSquared() {
		int a = getRandomInt();
		return a * a;
	}

	private int getRandomInt() {
		Random random = new Random();
		return random.nextInt(1, 10);
	}
	
}
