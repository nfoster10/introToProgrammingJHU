import java.util.*;

/**
* BlackjackStandardDeckOfCards defines a standard deck of cards for a game of blackjack. 
* A BlackjackStandardDeckOfCards consist of an array of 52 blackjack cards
* @author Nathaniel Foster
*/
public class BlackjackStandardDeckOfCards
{
	private BlackjackCard [] standardDeckOfCards;

	/**
	* The class concatenator
	*/
	BlackjackStandardDeckOfCards()
	{
		this.standardDeckOfCards = new BlackjackCard[52];

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

	/**
	* isEmpty() checks if the calling deck of cards has any cards in the deck
	* @return boolean true is returned if no cards are found in the deck, otherwise false
	*/
	public boolean isEmpty()
	{
		boolean isEmpty = true;

		for(int cardIterator = 0; cardIterator < standardDeckOfCards.length; cardIterator++)
		{
			if(standardDeckOfCards[cardIterator].isCardInDeck())
			{
				isEmpty = false;
				break;
			}
		}

		return isEmpty;
	}

	/**
	* getRandomCardFromDeck() returns a random card from the cards in the deck
	* @return BlackjackCard retreived is returned
	*/
	public BlackjackCard getRandomCardFromDeck()
	{
		ArrayList<BlackjackCard> currentCardsInDeck = this.getCurrentCardsInDeck();
		BlackjackCard cardRetreived = currentCardsInDeck.get((int)(currentCardsInDeck.size() * Math.random()));

		this.removeCardFromDeck(cardRetreived);

		return cardRetreived;
	}

	/**
	* removeCardFromDeck() removes an input card from the calling deck of cards
	* @param cardToRemove a card to remove from the deck
	*/
	private void removeCardFromDeck(BlackjackCard cardToRemove)
	{
		for(int cardIterator = 0; cardIterator < standardDeckOfCards.length; cardIterator++)
		{
			if(standardDeckOfCards[cardIterator].equals(cardToRemove))
				standardDeckOfCards[cardIterator].setIsInDeck(false);
		}
	}

	/**
	* getCurrentCardsInDeck() creates an array list of all the cards in the deck from the calling deck
	* @return a reference to an array list of BlackjackCards in the calling deck
	*/
	private ArrayList<BlackjackCard> getCurrentCardsInDeck()
	{
		ArrayList<BlackjackCard> currentCardsInDeck = new ArrayList<BlackjackCard>();

		for (BlackjackCard cardIterator : standardDeckOfCards)
			if (cardIterator.isCardInDeck())
				currentCardsInDeck.add(cardIterator);

		return currentCardsInDeck;
	}
}