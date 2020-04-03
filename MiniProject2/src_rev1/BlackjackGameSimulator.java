import java.util.*;
import java.io.*; 


public class BlackjackGameSimulator
{
	public static void main (String [] elmo)
	{
		Scanner input = new Scanner(System.in);
		String continueGame = "yes";
		ArrayList<BlackjackGame> games = new ArrayList<BlackjackGame>();

		int numberOfPlayers = 0;
		boolean gameIsOver = false;

		int currentGameNumber = 0;
		BlackjackGame currentGame;
		BlackjackStandardDeckOfCards currentDeck;
		ArrayList<BlackjackParticipant> currentParticipants;
		char hitOrStay = 0;

		System.out.printf("\n\nStarting BlackjackGameSimulator!");
		System.out.printf("\n\nNow creating a Blackjack Game...");
		

		while(continueGame.equals("yes"))
		{
			games.add(new BlackjackGame());
			currentGame = games.get(currentGameNumber);
			currentDeck = games.get(currentGameNumber).getCardDeck();

			System.out.printf("\nEnter number of players excluding the dealer: ");
			numberOfPlayers = input.nextInt();
			//this must be less than limit determined by the total amount of cards to make inital deals

			for(int playerIterator = numberOfPlayers; playerIterator > 0; playerIterator--)
			{
				System.out.printf("\n\tEnter 'buyIn' for player %d: $", (playerIterator));
				currentGame.addPlayer(input.nextDouble());
			}

			while(!gameIsOver)
			{
				System.out.printf("\nStarting a new round...players go first one at a time!");

				/* this deals two cards to each participant including dealer
				games.get(currentGameNumber).getParticipants().forEach(participant -> 
					participant.updateHand(((BlackjackDealer) games.get(currentGameNumber).getParticipants()
						.get(0)).dealCardsToPlayer(games.get(currentGameNumber).getCardDeck(),2)));
				*/

				currentParticipants = currentGame.getParticipants();

				for(int participantIterator = currentParticipants.size() - 1; participantIterator > 0; participantIterator--)
				{
					if(currentParticipants.get(participantIterator) instanceof BlackjackPlayer)
					{
						System.out.printf("\n\tEnter bet for player %d or $0 to cash out: $", (currentParticipants.size() - participantIterator + 1));
						
						if(!((BlackjackPlayer)currentParticipants.get(participantIterator))
							.setCurrentBet(input.nextDouble()))
						{
							gameIsOver = true;
							System.out.printf("\n\tGame will now reset. Invalid bet or out of cash!");
							System.out.printf("\n\tDeception will not be tolerated!");
							break;
						}

						//deal two cards to player
						if(currentParticipants.get(participantIterator).updateHand(
							((BlackjackDealer)currentParticipants.get(0)).
							dealCardsToPlayer(currentDeck,2)))
						{
							System.out.printf("\n\tPlayer %d WINS!", currentParticipants.size() - participantIterator + 1);
							((BlackjackPlayer)currentParticipants.get(participantIterator)).updatePlayerMoney();
						}

						System.out.printf("\n\tHand for player %d is : ", currentParticipants.size() - participantIterator + 1);
						System.out.printf("\n\t" + currentParticipants.get(participantIterator).showCurrentHand());

						hitOrStay = 'h';
						input.nextLine(); //need this to move cursor to correct spot for next input

						while(hitOrStay == 'h')
						{
							System.out.printf("\n\tHit 'h' or Stay 's': ");
							hitOrStay = input.nextLine().charAt(0);	

							if(hitOrStay == 's') break;
							else if(hitOrStay != 'h') continue;

							if(currentParticipants.get(participantIterator).updateHand(
								((BlackjackDealer)currentParticipants.get(0)).
								dealCardToPlayer(currentDeck)))
							{
								System.out.printf("\n\tHand for player %d is : ", currentParticipants.size() - participantIterator + 1);
								System.out.printf("\n\t" + currentParticipants.get(participantIterator).showCurrentHand());
								System.out.printf("\n\tWinner");
								break;
							}

							System.out.printf("\n\tHand for player %d is : ", currentParticipants.size() - participantIterator + 1);
							System.out.printf("\n\t" + currentParticipants.get(participantIterator).showCurrentHand());

							//check for too high
							if(currentParticipants.get(participantIterator).checkIfTooHigh())
							{
								System.out.printf("\n\tPlayer ## LOSES");
								break;
							}
						}
					
					}
					else //dealer is playing now
					{
						System.out.printf("\n\tDealer's turn!");

					}
				}
			}

			System.out.printf("\nEnter 'yes' to create a new Blackjack Game or 'no' to end program: ");
			continueGame = input.nextLine();
			currentGameNumber++;
		}

		System.out.printf("\n\nEnding BlackjackGameSimulator!");
	}
}