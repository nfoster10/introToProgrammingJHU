import java.util.*;
/**
* BlackjackGame represents a single game of Blackjack. A game of blackjack has a deck of cards 
* and a list of the participants in the game which includes the dealer and all the players in 
* the game.
* assumptions:
* 	 1. new deck for each round 
*	 2. only use one deck of cards
*	 3. dealer will stay at a soft 17 (soft 17 is ACE + 6)
*	 4. cards are never reused
* @author Nathaniel Foster
*/
public class BlackjackGame
{
	private BlackjackStandardDeckOfCards cardDeck;
	private ArrayList<BlackjackParticipant> participants;

	/**
	* The class concatenator
	*/
	BlackjackGame()
	{
		this.cardDeck = new BlackjackStandardDeckOfCards();

		this.participants = new ArrayList<BlackjackParticipant>();
		this.participants.add(new BlackjackDealer());
	}
	
	/**
	* addPlayers() adds new players to the game paritipant list but the players are added without any money.
	* the amount of players added must be greater than 0
	* @param newPlayers the amount of new players to be added to the game
	* @return boolean validData is returned true if greater than 0 and less than 25
	*/
	public boolean addPlayers(int newPlayers)
	{
		boolean validData = false;

		if(newPlayers > 0)
		{
			for(int newPlayerIterator = 0; newPlayerIterator < newPlayers; newPlayerIterator++)
			{
				this.participants.add(new BlackjackPlayer());
			}
			validData = true;
		}
		return validData;
	}

	/**
	* getParticipants() is a getter for BLackjackGame.participants
	* @return an ArrayList<BlackjackParticipant> reference to the participants
	*/
	public ArrayList<BlackjackParticipant> getParticipants()
	{
		return this.participants;
	}

	/**
	* initialDealToAllParticipants() has the dealer deal two cards to all participants including the dealer
	* itself. If the dealer runs out of cards, a new deck is retreived.
	* @return N/A
	*/
	public void initialDealToAllParticipants()
	{
		BlackjackParticipant participant;

		for(int participantIterator = 0; participantIterator < participants.size(); participantIterator++)
		{
			participant = participants.get(participantIterator);

			if(!this.cardDeck.isEmpty())
				this.cardDeck = new BlackjackStandardDeckOfCards();

			participant.updateHand(
				((BlackjackDealer)participants.get(0)).dealCardsToParticipant(cardDeck, 2));
		}
	}

	/**
	* hit() has the dealer deal one card to the inputParticiapnt. If the dealer runs out of cards,
	* a new deck is retreived.
	* @param inputParticipant the participant to receive one card from the dealer
	* @return N/A
	*/
	public void hit(BlackjackParticipant inputParticipant)
	{
		if(!this.cardDeck.isEmpty())
			this.cardDeck = new BlackjackStandardDeckOfCards();
		inputParticipant.updateHand(
				((BlackjackDealer)participants.get(0)).dealCardToParticipant(cardDeck));
	}

	/**
	* payoutAll() iterates through all the players in the game to designate wins/loses/ties 
	* @return a String summary of the results
	*/
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

	/**
	* resetForAnotherRound() resets all the participants in a game for another round
	* @return N/A
	*/
	public void resetForAnotherRound()
	{
		this.cardDeck = new BlackjackStandardDeckOfCards();

		BlackjackPlayer player;

		for(int participantIterator = 0; participantIterator < participants.size(); participantIterator++)
		{
			participants.get(participantIterator).reset();
		}
	}

	/**
	* removePlayer() removes a given player from the game
	* @param playerToRemove indicates the player to be removed
	* @return N/A
	*/
	public void removePlayer(int playerToRemove)
	{
		this.participants.remove(playerToRemove);
	}
}