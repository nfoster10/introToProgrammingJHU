/**
* BlackjackCard defines the behaviors and attributes of a blackjack card.
* A blackjack card has a value, a suit and a status of being in or out of a deck
* @author Nathaniel Foster
*/
public class BlackjackCard
{
	private int cardValue;
	private String suit;
	private boolean isInDeck;

	/**
	* The class concatenator
	*/
	BlackjackCard(int inputCardValue, String inputSuit)
	{
		this.cardValue = inputCardValue == 0 ? 13 : inputCardValue;
		//if inputCardValue is 0, assume this is a King

		this.isInDeck = true;

		if(inputSuit.equals("Diamonds") || inputSuit.equals("Clubs") ||
			inputSuit.equals("Hearts") || inputSuit.equals("Spades"))
			this.suit = inputSuit;
		else
			this.suit = "INVALID INPUT TO CONCATENATOR";
	}

	/**
	* getCardValue() is a getter for cardValue
	* @return this.cardValue for the calling BlackjackCard instance
	*/
	public int getCardValue()
	{
		return cardValue;
	}

	/**
	* toString() overides Object.toString()
	* @return String representation of a BlackjackCard instance
	*/
	public String toString()
	{
		String cardName;

		switch(this.cardValue)
		{
			case 1:
				cardName = "Ace of " + suit;
				break;
			case 11:
			cardName = "Jack of " + suit;
				break;
			case 12:
				cardName = "Queen of " + suit;
				break;
			case 13:
				cardName = "King of " + suit;
				break;
			default:
				cardName = cardValue + " of " + suit;
				break;
		}
		return cardName;
	}

	/**
	* isCardInDeck() is a getter for this.isInDeck for the calling object
	* @return boolean this.isInDeck
	*/
	public boolean isCardInDeck()
	{
		return this.isInDeck;
	}

	/**
	* setIsInDeck() is a setter for this.isInDeck for the calling object
	* @param inDeck boolean value to which to set this.isInDeck
	*/
	public void setIsInDeck(boolean inDeck)
	{
		this.isInDeck = inDeck;
	}

	/**
	* equals() overides Object.equals for BlackjackCards. It compares card suits and values
	* @param comparisonCard card to be compared to calling BlackjackCard object
	* @return boolean true if cards are the same or false if they do not match
	*/
	public boolean equals(BlackjackCard comparisonCard)
	{
		boolean isSame = false;

		if (this.cardValue == comparisonCard.cardValue && this.suit.equals(comparisonCard.suit))
			isSame = true;

		return isSame;
	}
}