import java.util.*;

public class BlackjackGame
{
	private BlackjackStandardDeckOfCards cardDeck;
	private ArrayList<BlackjackParticipant> participants;

	BlackjackGame()
	{
		this.cardDeck = new BlackjackStandardDeckOfCards();

		this.participants = new ArrayList<BlackjackParticipant>();
		this.participants.add(new BlackjackDealer());
	}

	public void addPlayer(double buyIn)
	{
		this.participants.add(new BlackjackPlayer(buyIn));
	}

	public ArrayList<BlackjackParticipant> getParticipants()
	{
		return this.participants;
	}

	public BlackjackStandardDeckOfCards getCardDeck()
	{
		return this.cardDeck;
	}

	/*public void removePlayerFromGame(int playerNumberToRemove)
	{
		participants.forEach( (BlackjackParticipant) -> 
			if()
	}*/
}