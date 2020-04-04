import java.util.*;

/**
* BlackjackParticipant implements the BlackjackParticipantInterface. BlackjackParticipant is the 
* parent class to BlackjackPlayer and BlackjackDealer.
*/
abstract class BlackjackParticipant implements BlackjackParticipantInterface
{
	private int currentScore;
	private ArrayList<BlackjackCard> hand;
	private boolean isWinner;
	private boolean blackjack;
	private boolean bust;
	/**
	* The class concatnator
	*/
	BlackjackParticipant()
	{
		this.currentScore = 0;
		this.hand = new ArrayList<BlackjackCard>();
		this.isWinner = false;
		this.blackjack = false;
		this.bust = false;
	}

	/**
	* updateHand() takes input newCards and adds the input newCards to the calling 
	* participant's hand. This is used for the initial deal to the players and the dealer so a 
	* blackjack is made. 
	* @param newCards the cards to be added to the hand
	* @return N/A
	*/
	public void updateHand(ArrayList<BlackjackCard> newCards)
	{
		newCards.forEach((newCard) -> this.hand.add(newCard));

		this.checkForBlackjack();
	}

	/**
	* updateHand() takes input newCard and adds the input newCard to the calling 
	* participant's hand. This is used for hits so checkForWinner() and checkForBust()
	* is also made
	* @param newCard the cards to be added to the hand
	* @return N/A
	*/
	public void updateHand(BlackjackCard newCard)
	{
		this.hand.add(newCard);

		this.checkForWinner();
		this.checkForBust();
	}

	/**
	* showHand() returns a string representation of the participant's hand of an input 
	* number of cards to show. All cards are shown if input is 0 or input is greater than 
	* the length of 'hand'
	* @param numberOfCardsToShow the number of cards to show
	* @return a String representation of the player hand
	*/
	public String showHand(int numberOfCardsToShow)
	{
		StringBuilder handToDisplay = new StringBuilder("| ");

		if (numberOfCardsToShow !=0 & numberOfCardsToShow <= hand.size())
		{
			for (int cardIterator = 0; cardIterator < hand.size(); cardIterator++)
			{
				if(cardIterator < numberOfCardsToShow)
					handToDisplay.append(hand.get(cardIterator).toString() + " | ");
				else
					handToDisplay.append("FACE DOWN | ");
			}
		}
		else
		{
			hand.forEach((card) -> handToDisplay.append(" | " + card.toString()));	
		}

		return handToDisplay.toString();
	}

	/**
	* checkForBlackjack() updates 'this.blackjack' and 'this.isWinner' for the calling
	* participant. The check is only valid if being called after the first two cards in
	* in a participant's hand is dealt. Blackjack and isWinner is made true when score is 21
	* @return N/A 
	*/
	private void checkForBlackjack()
	{
		if(hand.size() == 2) //only perform check if after adding first two cards
		{
			this.currentScore = 0;

			if(!this.blackjack)
			{
				currentScore = this.calculateHighScore(); //not possible to acheive blackjack with lowScore

				if(currentScore == BLACKJACK_WINNER)
				{
					this.blackjack = true;
					this.isWinner = true;
				}
			}
		}
	}

	/**
	* checkForBust() updates 'this.bust' for the calling participant. This check is made on 
	* hand updates for hits. the highScore is used until the highScore is a bust and then the
	* lowScore is used. 'this.bust' is made true when the low score is a bust
	* @return N/A
	*/
	private void checkForBust()
	{
		int currentScoreHigh = 0;
		int currentScoreLow = 0;

		currentScoreLow = this.calculateLowScore();
		currentScoreHigh = this.calculateHighScore();

		this.currentScore = currentScoreHigh;

		if(currentScoreHigh > BLACKJACK_WINNER)
			this.currentScore = currentScoreLow;

		if (currentScoreLow > BLACKJACK_WINNER)
			this.bust = true;
	}

	private void checkForWinner()
	{
		int currentScoreHigh = 0;
		int currentScoreLow = 0;

		currentScoreLow = this.calculateLowScore();
		currentScoreHigh = this.calculateHighScore();

		if(currentScoreHigh == BLACKJACK_WINNER || currentScoreLow == BLACKJACK_WINNER)
			this.isWinner = true;
	}

	public boolean getIsWinner()
	{
		return this.isWinner;
	}

	public boolean getIsBust()
	{
		return this.bust;
	}

	public boolean getIsBlackjack()
	{
		return this.blackjack;
	}

	public int getCurrentScore()
	{
		return this.currentScore;
	}

	public void reset()
	{
		this.currentScore = 0;
		this.hand = new ArrayList<BlackjackCard>();
		this.isWinner = false;
		this.blackjack = false;
		this.bust = false;
	}

	private int calculateHighScore()
	{
		int currentScoreHigh = 0;

		for (int cardIterator = 0; cardIterator < hand.size(); cardIterator++)
		{
			if(hand.get(cardIterator).getCardValue() != 1)
			{
				if(hand.get(cardIterator).getCardValue() > FACE_CARD_VALUE)
					currentScoreHigh += FACE_CARD_VALUE;
				else
					currentScoreHigh += hand.get(cardIterator).getCardValue();
			}
			else
			{
				currentScoreHigh += ACE_HI_VALUE;
			}
		}
		return currentScoreHigh;
	}

	private int calculateLowScore()
	{
		int currentScoreLow = 0;

		for (int cardIterator = 0; cardIterator < hand.size(); cardIterator++)
		{
			if(hand.get(cardIterator).getCardValue() > FACE_CARD_VALUE)
				currentScoreLow += FACE_CARD_VALUE;
			else
				currentScoreLow += hand.get(cardIterator).getCardValue();
		}

		return currentScoreLow;
	}
}