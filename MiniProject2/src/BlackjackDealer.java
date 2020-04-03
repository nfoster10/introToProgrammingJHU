import java.util.*;

public class BlackjackDealer extends BlackjackParticipant
{
	public BlackjackCard dealCardToPlayer(BlackjackStandardDeckOfCards currentDeck)
	{
		return currentDeck.getRandomCardFromDeck();
	}

	public ArrayList<BlackjackCard> dealCardsToPlayer(BlackjackStandardDeckOfCards currentDeck, int numberOfCardsToDeal)
	{
		ArrayList<BlackjackCard> hand = new ArrayList<BlackjackCard>();

		for (int i = 0; i < numberOfCardsToDeal; i++)
		{
			hand.add(currentDeck.getRandomCardFromDeck());
		}

		return hand;
	}
}