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

	public boolean addPlayers(int newPlayers)
	{
		boolean validData = false;

		if(newPlayers > 0 && newPlayers < 25) //(25 + 1)*2 = 52, will not have enough cards to deal if >25 players	
		{
			for(int newPlayerIterator; newPlayerIterator < newPlayers; newPlayerIterator++)
			{
				this.participants.add(new BlackjackPlayer());
			}
			validData = true;
		}

		return validData;
	}

	public ArrayList<BlackjackParticipant> getParticipants()
	{
		return this.participants;
	}





	public void addPlayer(double buyIn)
	{
		this.participants.add(new BlackjackPlayer(buyIn));
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