import java.util.*;
import java.io.*; 


public class BlackjackGameSimulator
{
	public static void main (String [] elmo)
	{
		//assumptions:
			//new deck for each round
			//only use one deck of cards
			//dealer will stay at a soft 17 (soft 17 is ACE + 6)
		Scanner input = new Scanner(System.in);
		boolean playAnotherBlackjackGame = true;
		char userInputPlayAnotherBlackjackGame;

		ArrayList<BlackjackGame> games = new ArrayList<BlackjackGame>();
		BlackjackGame game;
		int gameNumber = 0;
		ArrayList<BlackjackParticipant> participants;

		//start game - Let's Develop a gambling problem
		System.out.printf("\n\nStarting BlackjackGameSimulator! - A fully developed gambling problem!");
		System.out.printf("\n\nNow creating a Blackjack Game...");

		//while would like to play a blackjack game
		while(playAnotherBlackjackGame)
		{
			games.add(new BlackjackGame());
			game = games.get(gameNumber);

			//enter number of players in the game with amount of money they are playing with
			while(true)
			{
				System.out.printf("\n\tEnter number of players excluding the dealer: ");
				if(game.addPlayers(input.nextInt()))
					break;
			}

			participants = games.getParticipants();

			//update money for each player, start with one since first participant at index 0 is always the dealer
			for(int participantIterator = 1; participantIterator < participants.size(); participantIterator++)
			{	
				System.out.printf("\n\tEnter cash amount for Player #%d: $", participantIterator);
				((BlackjackPlayer)participants.get(participantIterator)).setPlayerMoney(input.nextDouble());
			}

			//time to start playing
				//for all participants
					//deal two cards
				//show dealer's first card to all and all player cards
				//for each player
					//take bet
						//bet must be less than player total money
					//check for blackjack and terminate if blackjack
						//ACE is whatever to win
					//hit or stay
						//hit
							//check for regular winner (dealer can still tie)
								//ACE is whatever to win
								//if winner, force stop and terminate
							//check for loser
								//ACE is whatever to not lose
								//if not loser, continue to top of hit or stay
								//if loser, terminate
						//stay
							//terminate
						//invalid
							//ask for another input (continue)
				//dealer's turn
					//dealer shows second card
					//while dealer score less than 17 //soft 17 stay
						//hit
							//check for regular winner
								//ACE is whatever to win
								//if winner, break
							//check for loser (score exceeds 21)
								//ACE is whatever to not lose
								//if not loser, continue to see if anohter hit
								//if loser, say loser and break
				//update players for winners and losers and cash amounts

			//check if want to play another game
			while(true)
			{	
				System.out.printf("\nEnter 'y' to create a new Blackjack Game or 'n' to end program: ");
				userInputPlayAnotherBlackjackGame = input.nextLine().charAt(0);
				if(userInputPlayAnotherBlackjackGame == 'y')
				{
					playAnotherBlackjackGame = true;
					break;
				}
				else if (userInputPlayAnotherBlackjackGame == 'n')
				{
					playAnotherBlackjackGame = false;
					break;
				}
			}
			gameNumber++;
		}				
/*--------------------------------------------------------------------------------------------

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
							System.out.printf("\n\tPlayer %d WINS! - Blackjack!", currentParticipants.size() - participantIterator + 1);
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

		System.out.printf("\n\nEnding BlackjackGameSimulator!");*/
	}
}