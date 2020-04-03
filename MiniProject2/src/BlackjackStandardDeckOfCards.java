import java.util.*;

public class BlackjackStandardDeckOfCards
{
	private BlackjackCard [] standardDeckOfCards;

	BlackjackStandardDeckOfCards()
	{
		this.standardDeckOfCards = new BlackjackCard[52];

		//TODO make deck of cards
		for (int cardIterator = 0; cardIterator < this.standardDeckOfCards.length; cardIterator++)
		{	
			if(cardIterator < 13)
				this.standardDeckOfCards[cardIterator] = new BlackjackCard((cardIterator + 1) % 13, "Diamonds");
			else if (cardIterator < 26)
				this.standardDeckOfCards[cardIterator] = new BlackjackCard((cardIterator + 1) % 13, "Hearts");
			else if (cardIterator < 39)
				this.standardDeckOfCards[cardIterator] = new BlackjackCard((cardIterator + 1) % 13, "Spades");
			else if (cardIterator < 52)
				this.standardDeckOfCards[cardIterator] = new BlackjackCard((cardIterator + 1) % 13, "Clubs");
		}
	}

	public BlackjackCard getRandomCardFromDeck()
	{
		ArrayList<BlackjackCard> currentCardsInDeck = this.getCurrentCardsInDeck();
		BlackjackCard cardRetreived = currentCardsInDeck.get((int)(currentCardsInDeck.size() * Math.random()));

		this.removeCardFromDeck(cardRetreived);

		return cardRetreived;
	}

	private ArrayList<BlackjackCard> getCurrentCardsInDeck()
	{
		ArrayList<BlackjackCard> currentCardsInDeck = new ArrayList<BlackjackCard>();

		for (BlackjackCard cardIterator : standardDeckOfCards)
			if (cardIterator.isCardInDeck())
				currentCardsInDeck.add(cardIterator);

		return currentCardsInDeck;
	}
	private void removeCardFromDeck(BlackjackCard cardToRemove)
	{
		for(int cardIterator = 0; cardIterator < standardDeckOfCards.length; cardIterator++)
		{
			if(standardDeckOfCards[cardIterator].equals(cardToRemove))
				standardDeckOfCards[cardIterator].setIsInDeck(false);
		}
	}
}