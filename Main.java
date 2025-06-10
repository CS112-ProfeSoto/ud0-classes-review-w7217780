/**
 * Driver program that creates standard 52-card deck (as Card array)
 * and prints out each card in deck.
 *
 * @author Ford Culallad
 * @version v1.0
 */

public class Main {

	/* ALGORITHM
	*
	1. Generate 52 card deck into Card array
	- ???
	2. Print deck (simple)
	- ???
	*
	*/
	public static void main(String[] args) {
		/*** RUNNING TESTER ***/
		//uncomment line below to run CardTester:
		//CardTester.main(null);

		/*** DRIVER PROGRAM ***/
		//1. Generate 52 card deck into Card array
		Card[] deck = new Card[52];

		int index = 0;
		char[] suits = { ' ', '♥', '♦', '♣', '♠' };

		for (int suit = 1; suit <= 4; suit++)
		{
			for (int value = 1; value <= 13; value++)
			{
				deck[index] = new Card(value, suits[suit]);
				index++;
			}
		}

		//2. Print deck
		for(Card card : deck)
		{
			card.printCard();
			System.out.print("\n\n");
		}
	}
}