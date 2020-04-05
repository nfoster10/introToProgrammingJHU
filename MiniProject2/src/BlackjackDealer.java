import java.util.*;

/**
* BlackjackDealer is a child of the BlackjackPaticipant class. It defines actions
* specific to a blackjack dealer that players do not perform.
*/
public class BlackjackDealer extends BlackjackParticipant
{
	public BlackjackCard dealCardToParticipant(BlackjackStandardDeckOfCards currentDeck)
	{
		return currentDeck.getRandomCardFromDeck();
	}

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