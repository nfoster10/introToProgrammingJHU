import java.util.*;

abstract class BlackjackParticipant //implements ?
{
	private int currentScore;
	private ArrayList<BlackjackCard> hand;
	private boolean isWinner;
	private boolean blackjack;
	private boolean bust;

	BlackjackParticipant()
	{
		this.currentScore = 0;
		this.hand = new ArrayList<BlackjackCard>();
		this.isWinner = false;
		this.blackjack = false;
		this.bust = false;
	}

	public void updateHand(ArrayList<BlackjackCard> newCards)
	{
		newCards.forEach((newCard) -> this.hand.add(newCard));

		this.checkForBlackjack();
		this.checkForBust();
	}

	public void updateHand(BlackjackCard newCard)
	{
		this.hand.add(newCard);

		this.checkForWinner();
		this.checkForBust();
	}

	public String showHand(int numberOfCardsToShow)
	{
		StringBuilder handToDisplay = new StringBuilder("");

		if (numberOfCardsToShow !=0 & numberOfCardsToShow <= hand.size())
		{
			for (int cardIterator = 0; cardIterator < hand.size(); cardIterator++)
			{
				if(cardIterator < numberOfCardsToShow)
					handToDisplay.append(" | " + hand.get(cardIterator).toString());
				else
					handToDisplay.append(" | FACE DOWN");
			}
		}
		else
		{
			hand.forEach((card) -> handToDisplay.append(" | " + card.toString()));	
		}

		return handToDisplay.toString();
	}

	private void checkForBlackjack()
	{
		if(hand.size() == 2) //only perform check if after adding first two cards
		{
			this.currentScore = 0;

			if(!this.blackjack)
			{
				currentScore = this.calculateHighScore();

				if(currentScore == 21)
				{
					this.blackjack = true;
					this.isWinner = true;
				}
			}
		}
	}

	private void checkForBust()
	{
		int currentScoreHigh = 0;
		int currentScoreLow = 0;


		currentScoreLow = this.calculateLowScore();
		currentScoreHigh = this.calculateHighScore();

		this.currentScore = currentScoreHigh;

		if(currentScoreHigh > 21)
			this.currentScore = currentScoreLow;

		if (currentScoreLow > 21)
			this.bust = true;
	}

	private void checkForWinner()
	{
		int currentScoreHigh = 0;
		int currentScoreLow = 0;

		currentScoreLow = this.calculateLowScore();
		currentScoreHigh = this.calculateHighScore();

		if(currentScoreHigh == 21 || currentScoreLow == 21)
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
				//currentScoreHigh += hand.get(cardIterator).getCardValue();
				if(hand.get(cardIterator).getCardValue() > 10)
					currentScoreHigh += 10;
				else
					currentScoreHigh += hand.get(cardIterator).getCardValue();
			}
			else
			{
				currentScoreHigh += 11; //assume ACE is 11 for high score
			}
		}

		return currentScoreHigh;
	}
	private int calculateLowScore()
	{
		int currentScoreLow = 0;

		for (int cardIterator = 0; cardIterator < hand.size(); cardIterator++)
		{
			if(hand.get(cardIterator).getCardValue() > 10)
				currentScoreLow += 10;
			else
				currentScoreLow += hand.get(cardIterator).getCardValue();
		}

		return currentScoreLow;
	}
}