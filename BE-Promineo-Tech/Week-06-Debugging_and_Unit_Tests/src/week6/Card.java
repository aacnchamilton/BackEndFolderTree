package week6;

public class Card {

	private int value = 0;
	private String name = null;
	
	public Card() {
		// TODO Auto-generated constructor stub
	}

	public int getCardValue() {
		return value;
		
	}
	
	public String getCardName() {
		return name;
	}
	
	public void setCardValue(int value) {
		this.value = value;
	}
	
	public void setCardName(String name) {
		this.name = name;
	}
	
	public void describe() {
		System.out.println("Card Name: " + this.name + " Card Value: " + this.value);
	}

}
