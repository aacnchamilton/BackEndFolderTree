package week6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	
	List<Card> deckOfCards = new ArrayList<Card>();
	
	public Deck() {
		// populate 52 card deck
		String[] suitOfCards = {"Hearts", "Clubs", "Spades", "Diamonds"};
		String[] nameOfCards = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
		int indexOfDeck = 0;  //Used for the index value while putting a new card instance into the deck of cards
		for (int i=0;i<4;i++) {
			for (int j=0;j<13;j++) {
				Card cardInstance = new Card();
				cardInstance.setCardName(nameOfCards[j] + " of " + suitOfCards[i]);
				//System.out.println(nameOfCards[j] + " of " + suitOfCards[i] + " with a value of " + j);
				cardInstance.setCardValue(j);
				//System.out.println(indexOfDeck);
				deckOfCards.add(indexOfDeck,cardInstance);
				indexOfDeck += 1;
			}
		}
//		for (Card card : deckOfCards) {
//			card.describe();
//		}
	}
	
	public void shuffle() {
		Collections.shuffle(this.deckOfCards);
	}
	
	public Card draw() {
		return this.deckOfCards.get(0);
	}
	
	public void describe() {
		for (Card card : this.deckOfCards) {
			card.describe();
		}
	}

}
