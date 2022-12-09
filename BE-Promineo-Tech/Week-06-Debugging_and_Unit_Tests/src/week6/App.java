package week6;

public class App {



	public static void main(String[] args) {
		int numberOfPlayers = 2;
		Deck deck = new Deck();
		int sizeOfHand = deck.getDeckOfCards().size()/numberOfPlayers;
		deck.shuffle();
		//deck.describe();
		Player player1 = new Player();
		Player player2 = new Player();
		player1.setName("Aaron Hamilton");
		player2.setName("Matt Pezzelle");
		
		for (int i=0;i<sizeOfHand;i++) {  //Deal the cards
			player1.hand.add(player1.draw(deck));
			player2.hand.add(player1.draw(deck));
		}
		Card player1Card = null;
		Card player2Card = null;
		
		System.out.println("****************************************");
		System.out.println("LET'S GET READY TO RUMBLE!!!!!");
		System.out.println("****************************************");
		
		
		for (int i=0;i<sizeOfHand;i++) {
			
			player1Card = player1.flip();
			player1.describe(player1Card);
			player2Card = player2.flip();
			player2.describe(player2Card);
			
			if ( player1Card.getCardValue() > player2Card.getCardValue()) {
				player1.incrementScore();
				System.out.println(player1.getName() + " wins the battle.");				
			} else if (player1Card.getCardValue() < player2Card.getCardValue()) {
				player2.incrementScore();
				System.out.println(player2.getName() + " wins the battle.");	
			} else {
				System.out.println("Players tie");
			}
			System.out.println("****************************************");
		}
		
		System.out.println(player1.getName() + " has a final score of " + player1.getScore() + " and " + player2.getName() + " has a final score of " + player2.getScore());
		if (player1.getScore() > player2.getScore()) {
			System.out.println(player1.getName() + " wins the war!!!");
		} else if (player1.getScore() < player2.getScore()) {
			System.out.println(player2.getName() + " wins the war!!!");
		} else {
			System.out.println("Players tie");
		}
	}
}
