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
			for(int newPlayerIterator = 0; newPlayerIterator < newPlayers; newPlayerIterator++)
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

	public void initialDealToAllParticipants()
	{
		BlackjackParticipant participant;

		for(int participantIterator = 0; participantIterator < participants.size(); participantIterator++)
		{
			participant = participants.get(participantIterator);

			participant.updateHand(
				((BlackjackDealer)participants.get(0)).dealCardsToParticipant(cardDeck, 2));
		}
	}

	public void hit(BlackjackParticipant inputParticipant)
	{
		inputParticipant.updateHand(
				((BlackjackDealer)participants.get(0)).dealCardToParticipant(cardDeck));
	}

	public String payoutAll()
	{
		StringBuilder payoutSummary = new StringBuilder();
		BlackjackPlayer player;
		String result;

		for(int playerIterator = 1; playerIterator < participants.size(); playerIterator++)
		{
			player = (BlackjackPlayer) participants.get(playerIterator);

			if(player.getIsBlackjack())
			{	
				player.win();
				result = "wins";
			}
			else if(participants.get(0).getIsBlackjack())
			{
				player.lose();
				result = "loses";
			}
			else if(player.getIsBust())
			{
				player.lose();
				result = "loses";
			}
			else if(participants.get(0).getIsBust())
			{
				player.win();
				result = "wins";
			}
			else
			{
				if(player.getCurrentScore() > participants.get(0).getCurrentScore())
				{	
					player.win();
					result = "wins";
				}
				else if(player.getCurrentScore() < participants.get(0).getCurrentScore())
				{
					player.lose();
					result = "loses";
				}
				else
				{	player.tie();
					result = "tie";
				}
			}

			payoutSummary.append(String.format("\n\tPlayer #%d %s, new total: $%.2f\n", playerIterator, result, player.getPlayerMoney()));
		}

		return payoutSummary.toString();
	}

	public void resetForAnotherRound()
	{
		this.cardDeck = new BlackjackStandardDeckOfCards();

		BlackjackPlayer player;

		for(int participantIterator = 0; participantIterator < participants.size(); participantIterator++)
		{
			participants.get(participantIterator).reset();
		}
	}

	public void removePlayer(int playerToRemove)
	{
		this.participants.remove(playerToRemove);
	}
}