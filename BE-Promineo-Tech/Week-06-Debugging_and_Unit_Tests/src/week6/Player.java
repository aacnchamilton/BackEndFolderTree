package week6;

import java.util.ArrayList;

public class Player {
	
	ArrayList<String> hand = new ArrayList<String>();
	int score = 0;
	String name = null;
	
	public Player() {
		// TODO Auto-generated constructor stub
	}
	
	public void describe() {
		System.out.println("Player Name: " + name);
		System.out.println("card " + hand);
	}
	
	public String flip() {
		
		return this.hand.get(0);
	}
	
	public String draw(Deck deck);{
		retun deck.draw(deck);
	}
	
	public void incrementScore() {
		this.score += 1;
	}

}
