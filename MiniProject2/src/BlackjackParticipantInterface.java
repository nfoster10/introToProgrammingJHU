	import java.util.*;

	/**
	* BlackjackParticipantInterface defines the interface to be used
	* by all Blackjack participants as well as common constants
	*/
	public interface BlackjackParticipantInterface
	{
		int FACE_CARD_VALUE = 10;
		int ACE_HI_VALUE = 11;
		int BLACKJACK_WINNER = 21;

		void updateHand(ArrayList<BlackjackCard> newCards);
		void updateHand(BlackjackCard newCard);
		String showHand(int numberOfCardsToShow);
		boolean getIsWinner();
		boolean getIsBust();
		boolean getIsBlackjack();
		int getCurrentScore();
		void reset();
	}