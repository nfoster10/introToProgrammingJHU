import java.util.*;

abstract class BlackjackParticipant //implements ?
{
	private int currentScore;
	private ArrayList<BlackjackCard> hand;
	private boolean isWinner;

	BlackjackParticipant()
	{
		this.currentScore = 0;
		this.hand = new ArrayList<BlackjackCard>();
		this.isWinner = false;
	}

	public boolean hit()
	{
		return true;
	}

	public boolean updateHand(BlackjackCard newCard)
	{
		this.hand.add(newCard);

		hand.forEach((card) -> this.currentScore += card.getCardValue());

		if(currentScore == 21){
			isWinner = true;
		}

		return isWinner;
	}

	public boolean updateHand(ArrayList<BlackjackCard> newCards)
	{
		newCards.forEach((newCard) -> this.hand.add(newCard));

		hand.forEach((card) -> this.currentScore += card.getCardValue());

		if(currentScore == 21){
			isWinner = true;
		}

		return isWinner;
	}

	public String showCurrentHand()
	{
		StringBuilder handToDisplay = new StringBuilder("");

		hand.forEach((card) -> handToDisplay.append(" | " + card.toString()));

		return handToDisplay.toString();
	}

	public boolean checkIfTooHigh()
	{
		boolean tooHigh = false;

		if(currentScore > 21) tooHigh = true;

		return tooHigh; 
	}
}