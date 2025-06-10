/**
 * Represents one playing card from a standard 52-card deck
 * (https://en.wikipedia.org/wiki/Playing_card)
 *
 * Class Invariant:
 * - Card value represents the number/letter printed on the card,
 * usually in the corners (A, 2, 3, ..., 9, 10, J, Q, K)
 * - Card value is stored as an integer to make error checking/validation
 * easier,
 * but must be outputted appropriately (1 is A, 11 is J, 12 is Q, 13 is K) for
 * user
 * - Card suit represents one of 4 suits (heart, diamond, club, spade)
 * - Card suit is stored as the unicode char representing the suit,
 * constant variables will be used throughout code for consistency
 * - Whenever value/suit is changed, it must be within the valid values
 *
 * @author Ford Culallad
 * @version v1.0
 */

/*
 * UML CLASS DIAGRAM:
 * -------------------------------------------------------
 *   Card
 * -------------------------------------------------------
 * - value : int
 * - suit : char
 * + HEART : char			//static constant with value ♥
 * + DIAMOND : char			//static constant with value ♦
 * + CLUB : char			//static constant with value ♣
 * + SPADE : char			//static constant with value ♠
 * + DEFAULT_VALUE : int	//static constant with value 1
 * + DEFAULT_SUIT : char	//static constant with value ♥
 * -------------------------------------------------------
 * + Card()
 * + Card(value : int, suit : char)
 * + Card(original : Card)
 * + setValue(value : int) : boolean
 * + setSuit(suit : char) : boolean
 * + setAll(value : int, suit : char) : boolean
 * + getSuit() : char
 * + getValue() : int
 * + getPrintValue() : String
 * + getPrintCard() : String
 * + toString() : String
 * + equals(otherCard : Card) : boolean
 * + printCard() : void
 * -------------------------------------------------------
 */

public class Card {

	/*** CONSTANT VARIABLES ***/
	public static final int DEFAULT_VALUE = 1;
	public static final char DEFAULT_SUIT = '♥';

	public static final char HEART = '♥';
	public static final char DIAMOND = '♦';
	public static final char CLUB = '♣';
	public static final char SPADE = '♠';

	/*** INSTANCE VARIABLES ***/
	private int value_ = 0;
	private char suit_ = ' ';

	/*** CONSTRUCTOR METHODS ***/
	/**
	 * Default constructor, builds default card object as: A ♥
	 */

	public Card()
	{
		this.value_ = DEFAULT_VALUE;
		this.suit_ = DEFAULT_SUIT;
	}

	/**
	 * Full constructor builds object with all data for instance variables provided.
	 * If arguments are not valid, program shuts down with error message
	 *
	 * @param value numerical value of card (1-13), not what shows on card (A, 2-10,
	 *              J, Q, K)
	 * @param suit  one of four suit values (unicode value for heart, diamond,
	 *              spade, or club)
	 */

	public Card(int value, char suit)
	{
		boolean init = setAll(value, suit);

		if (!init)
		{
			System.out.println("ERROR : Invalid Constructor Arguments.");
			System.exit(1);
		}
	}

	/**
	 * Copy constructor builds object with all data from Card object provided. No
	 * changes made to original object, no shallow copying
	 *
	 * @param original Card object to be copied
	 */

	public Card(Card otherCard)
	{
		if (otherCard == null)
		{
			System.out.println("ERROR : Arugment NULL.");
			System.exit(1);
		}

		this.suit_ = otherCard.suit_;
		this.value_ = otherCard.value_;
	}

	/*** MUTATOR METHODS (SETTERS) ***/
	/**
	 * Sets value for card only if valid, otherwise will not change instance
	 * variable. Returns boolean representing whether error occured (false) or
	 * operation completed successfully (true)
	 *
	 * @param value numerical value of card (1-13), not what shows on card (A, 2-10,
	 *              J, Q, K)
	 *
	 * @return true if card value is between 1 and 13 (inclusive), false otherwise
	 */

	public boolean setValue(int value)
	{
		if (value >= 1 && value <= 13)
		{
			value_ = value;
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Sets suit for card only if valid, otherwise will not change instance
	 * variable. Returns boolean representing whether error occured (false) or
	 * operation completed successfully (true)
	 *
	 * @param suit one of four suit values (unicode value for heart, diamond, spade,
	 *             or club)
	 *
	 * @return true if card suit is unicode value for heart, diamond, club or spade.
	 *         false otherwise
	 */

	// * + setSuit(suit : char) : boolean
	public boolean setSuit(char suit)
	{
		switch (suit)
		{
			case '♥':
				this.suit_ = suit;
				break;
			case '♦':
				this.suit_ = suit;
				break;
			case '♣':
				this.suit_ = suit;
				break;
			case '♠':
				this.suit_ = suit;
				break;
			default:
				return false;
		}

		return true;
	}

	/**
	 * Sets suit and value for card only if valid, returns boolean representing
	 * whether error occured (false) or operation completed successfully (true)
	 *
	 * @param suit  one of four suit values (unicode value for heart, diamond,
	 *              spade, or club)
	 * @param value numerical value of card (1-13), not what shows on card (A, 2-10,
	 *              J, Q, K)
	 *
	 * @return true if card suit AND value are valid, false otherwise
	 */

	public boolean setAll(int value, char suit)
	{
		return (setValue(value) && setSuit(suit));
	}

	/*** ACCESSOR METHODS (GETTERS) ***/
	/**
	 * Access unicode character representing suit of card
	 *
	 * @return suit as unicode character for heart, spade, diamond, or club
	 */

	public char getSuit()
	{
		return suit_;
	}

	/**
	 * Access numerical value of card (1-13)
	 *
	 * @return value as raw integer 1-13 (not what player sees as A, 2-10, J, Q, K;
	 *         see {@link #getPrintValue()})
	 */

	public int getValue()
	{
		return value_;
	}

	/**
	 * Access value of card as seen by user (A, 2-10, J, Q, K) that would be printed
	 * on card
	 *
	 * @return value as String user sees on card (A, 2-10, J, Q, K), not numerical
	 *         value 1-13 (see {@link #getValue()})
	 */

	public String getPrintValue()
	{
		switch (value_)
		{
			case 1:
				return "A";
			case 11:
				return "J";
			case 12:
				return "Q";
			case 13:
				return "K";
			default:
				return Integer.toString(value_);
		}
	}

	/**
	 * Access ASCII art version of card data, each line separated by newline
	 * character, no newline character at end of String
	 *
	 * @return String containing ASCII art with card suit and card print value
	 */

	public String getPrintCard()
	{
		String art = "";

		art += "--------\n";
		art += "| " + this.suit_ + "  " + this.suit_ + " |\n";
		if (value_ < 10)
		{
			art += "|  " + Integer.toString(value_) + " " + "  |\n";
		}
		else
		{
			art += "|  " + Integer.toString(value_) + " " + " |\n";
		}
		art += "| " + this.suit_ + "  " + this.suit_ + " |\n";
		art += "--------";

		return art;
	}

	/*** OTHER REQUIRED METHODS ***/
	/**
	 * String of all instance variables, no newline character at end of String.
	 * Using print value to use as "condensed" version of printed card (ex: A ♥)
	 * 
	 * @return String containing (print) value and suit, separated by a space
	 */

	public String toString()
	{
		if (value_ == 0 && suit_ == ' ')
		{
			return "0 ";
		}
		else if (value_ == 1)
		{
			return "A" + suit_;
		}
		else
		{
			return Integer.toString(value_) + suit_;
		}
	}

	/**
	 * Checking for equality of Card objects, all instance variables exactly equal
	 * to each other (case-sensitive). Argument object not changed
	 * 
	 * @param other Card object to compare for equality
	 * 
	 * @return boolean representing equality between both objects, all data is
	 *         exactly equal to each other
	 */

	public boolean equals(Card otherCard)
	{
		if (otherCard == null)
		{
			return false;
		}

		return this.value_ == otherCard.value_ && this.suit_ == otherCard.suit_;
	}

	/*** EXTRA METHODS ***/
	/**
	 * Prints card ASCII art to console (see {@link #getPrintCard()})
	 */

	public void printCard()
	{
		System.out.print(getPrintCard());
	}
}
