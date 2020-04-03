public class BlackjackCard
{
	private int cardValue;
	private String suit;
	private boolean isInDeck;

	BlackjackCard(int inputCardValue, String inputSuit)
	{
		this.cardValue = inputCardValue == 0 ? 13 : inputCardValue;
		//if inputCardValue is 0, assume this is a King

		this.isInDeck = true;

		if(inputSuit.equals("Diamonds") || inputSuit.equals("Clubs") ||
			inputSuit.equals("Hearts")|| inputSuit.equals("Spades"))
			this.suit = inputSuit;
		else
			this.suit = "INVALID INPUT TO CONCATENATOR";
	}

	public int getCardValue()
	{
		return cardValue;
	}
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

	public boolean isCardInDeck()
	{
		return this.isInDeck;
	}

	public void setIsInDeck(boolean inDeck)
	{
		this.isInDeck = inDeck;
	}
	public boolean equals(BlackjackCard comparisonCard)
	{
		boolean isSame = false;

		if (this.cardValue == comparisonCard.cardValue && this.suit.equals(comparisonCard.suit))
			isSame = true;

		return isSame;
	}
}