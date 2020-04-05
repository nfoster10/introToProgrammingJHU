import java.util.*;

/**
* BlackjackDealer is a child of the BlackjackPaticipant class. It defines actions
* specific to a blackjack dealer that players do not perform.
* @author Nathaniel Foster
*/
public class BlackjackDealer extends BlackjackParticipant
{
	/**
	* dealCardToParticipant() deals one card from an input deck of cards
	* @param currentDeck a reference to a deck of cards
	* @return a reference to one BlackjackCard
	*/
	public BlackjackCard dealCardToParticipant(BlackjackStandardDeckOfCards currentDeck)
	{
		return currentDeck.getRandomCardFromDeck();
	}

	/**
	* dealCardsToParticipant() deals an input number of cards from an input deck of cards
	* @param currentDeck a reference to a deck of cards
	* @param numberOfCardsToDeal the amount of cards to be returned to the caller
	* @return a reference to an ArrayList of BlackjackCard instances
	*/
	public ArrayList<BlackjackCard> dealCardsToParticipant(BlackjackStandardDeckOfCards currentDeck, int numberOfCardsToDeal)
	{
		ArrayList<BlackjackCard> hand = new ArrayList<BlackjackCard>();

		for (int i = 0; i < numberOfCardsToDeal; i++)
		{
			hand.add(currentDeck.getRandomCardFromDeck());
		}

		return hand;
	}
}