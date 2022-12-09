package week6;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	List<Card> hand = new ArrayList<Card>();
	int score = 0;
	String name = null;
	
	public Player() {
	}
	
	public void describe(Card card) {
		System.out.println(this.name + " flips " + card.getCardName());
	}
	
	public Card flip() {
		Card card = this.hand.get(0);
		this.hand.remove(0);
		return card;
	}
	
	public Card draw(Deck deck){
		return deck.draw();
	}
	
	public void incrementScore() {
		this.score += 1;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

}
