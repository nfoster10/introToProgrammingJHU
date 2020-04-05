import java.util.*;

/**
* BlackjackParticipantInterface defines the interface to be used
* by all Blackjack participants as well as common constants
* @author Nathaniel Foster
*/
public interface BlackjackParticipantInterface
{
	int FACE_CARD_VALUE = 10;
	int ACE_HI_VALUE = 11;
	int BLACKJACK_WINNER = 21;
	
	/**
	* updateHand() takes input newCards and adds the input newCards to the calling 
	* participant's hand. This is used for the initial deal to the players and the dealer so a 
	* blackjack is made. 
	* @param newCards the cards to be added to the hand
	*/
	void updateHand(ArrayList<BlackjackCard> newCards);

	/**
	* updateHand() takes input newCard and adds the input newCard to the calling 
	* participant's hand. This is used for hits so checkForWinner() and checkForBust()
	* is also made
	* @param newCard the cards to be added to the hand
	*/
	void updateHand(BlackjackCard newCard);
	
	/**
	* showHand() returns a string representation of the participant's hand of an input 
	* number of cards to show. All cards are shown if input is 0 or input is greater than 
	* the length of 'hand'
	* @param numberOfCardsToShow the number of cards to show
	* @return a String representation of the player hand
	*/
	String showHand(int numberOfCardsToShow);
	
	/**
	* getIsWinner() is a getter for this.isWinner
	* @return this.isWinner for the calling BlackjackParticipant object
	*/
	boolean getIsWinner();
	
	/**
	* getIsBust() is a getter for this.bust
	* @return this.bust for the calling BlackjackParticipant object
	*/
	boolean getIsBust();

	/**
	* getIsBlackjack() is a getter for this.blackjack
	* @return this.blackjack for the calling BlackjackParticipant object
	*/
	boolean getIsBlackjack();

	/**
	* getCurrentScore() is a getter for this.currentScore
	* @return this.currentScore for the calling BlackjackParticipant object
	*/
	int getCurrentScore();

	/**
	* reset() resets all the attributes of a BlackjackParticipant
	*/
	void reset();
}