import java.util.*;
import java.io.*; 

/**
* BlackjackGameSimulator simulates a game of blackjack until the user indicates to end the program
* @author Nathaniel Foster
*/
public class BlackjackGameSimulator
{
	public static void main (String [] elmo)
	{
		Scanner input = new Scanner(System.in);
		boolean playAnotherBlackjackGame = true;
		char userInputPlayAnotherBlackjackGame;
		char hitOrStay;
		char removePlayer;

		ArrayList<BlackjackGame> games = new ArrayList<BlackjackGame>();
		BlackjackGame game;
		int gameNumber = 0;
		ArrayList<BlackjackParticipant> participants;
		BlackjackPlayer player;

		//start game - Let's Develop a gambling problem
		System.out.printf("\n\nStarting BlackjackGameSimulator! - A fully developed gambling problem!");
		System.out.printf("\n\nNow creating a Blackjack Game...");
		games.add(new BlackjackGame());

		//while would like to play a blackjack game
		while(playAnotherBlackjackGame)
		{
			game = games.get(gameNumber);
			participants = game.getParticipants();

			//enter number of players in the game with amount of money they are playing with
			if(participants.size() == 1)
			{
				while(true)
				{
					System.out.printf("\n\tEnter number of players excluding the dealer: ");
					if(game.addPlayers(input.nextInt()))
						break;
				}
			

				//update money for each player, start with one since first participant at index 0 is always the dealer
				for(int participantIterator = 1; participantIterator < participants.size(); participantIterator++)
				{	
					System.out.printf("\n\tEnter cash amount for Player #%d: $", participantIterator);
					((BlackjackPlayer)participants.get(participantIterator)).setPlayerMoney(input.nextDouble());
				}
			}

			//time to start playing
			System.out.printf("\n\tThe game is Blackjack...the House always wins...good luck!");
			
			//for all participants
			//deal two cards
			game.initialDealToAllParticipants();

			//gather bets for each player
			for(int playerIterator = 1; playerIterator < participants.size(); playerIterator++)
			{
				player = (BlackjackPlayer)participants.get(playerIterator);

				//take bet
				//bet must be less than player total money
				while(true)
				{
					System.out.printf("\n\tEnter bet for Player #%d: $", playerIterator);
					if(player.setCurrentBet(input.nextDouble()))
						break;
				}
			}

			//show dealer's first card to all
			System.out.printf("\n\tDealer hand: " + participants.get(0).showHand(1));

			//show all player cards now that bets have been placed
			for(int playerIterator = 1; playerIterator < participants.size(); playerIterator++)
			{
				player = (BlackjackPlayer)participants.get(playerIterator);
				System.out.printf("\n\tPlayer #%d hand: " + player.showHand(0), playerIterator);
				
			}

			//for each player
			for(int playerIterator = 1; playerIterator < participants.size(); playerIterator++)
			{
				System.out.printf("\n\n\tLet the fun begin for Player #%d!", playerIterator);

				player = (BlackjackPlayer)participants.get(playerIterator);

				//show player hand and total score
				System.out.printf("\n\n\tPlayer #%d hand: " + player.showHand(0), playerIterator);
				System.out.printf("\n\tPlayer #%d score: %d", playerIterator, player.getCurrentScore());

				//check for blackjack and terminate if blackjack
				//ACE is whatever to win
				if(player.getIsBlackjack())
				{
					System.out.printf("\n\tBLACKJACK for Player#%d!", playerIterator);
				}
				else
				{	
					//hit or stay
					hitOrStay = 'h';
					System.out.println();
	

					while(hitOrStay == 'h' && !player.getIsBust())
					{
						//input.nextLine(); //correct cursor poisition
						System.out.printf("\n\tHit 'h' or Stay 's': ");
						hitOrStay = input.next().charAt(0);	

						if(hitOrStay == 's') break; //stay, move on to next player or dealer
						else if(hitOrStay != 'h')
						{
							hitOrStay = 'h';
							continue; //invalid, prompt user again
						}
						
						//hit
						game.hit(player);

						//show player hand and total score
						System.out.printf("\n\tPlayer #%d hand: " + player.showHand(0), playerIterator);
						System.out.printf("\n\tPlayer #%d score: %d\n", playerIterator, player.getCurrentScore());

						//check for if winner or loser to terminate
						if(player.getIsWinner())
						{	
							break;
						}
						else if(player.getIsBust())
						{
							System.out.printf("\n\n\tBUST");
							break;
						}
					}


				}
			}
			//dealer's turn
			System.out.printf("\n\n\tLet the fun begin for the Dealer!");
			//dealer shows second card
			System.out.printf("\n\n\tDealer hand: " + participants.get(0).showHand(0));
			System.out.printf("\n\tDealer score: %d\n", participants.get(0).getCurrentScore());

			if(participants.get(0).getIsBlackjack())
			{
				System.out.printf("\n\tBLACKJACK for Dealer!");
			}
			else
			{
				//while dealer score less than 17 //soft 17 stay
				while(participants.get(0).getCurrentScore() < 17)
				{
					//hit
					game.hit(participants.get(0));

					//show dealer hand and total score
					System.out.printf("\n\tDealer hand: " + participants.get(0).showHand(0));
					System.out.printf("\n\tDealer score: %d\n", participants.get(0).getCurrentScore());

					//check for if winner or loser to terminate
					if(participants.get(0).getIsWinner())
					{	
						break;
					}
					else if(participants.get(0).getIsBust())
					{
						System.out.printf("\n\n\tBUST");
						break;
					}
				}
			}

			//update players for winners and losers and cash amounts
			System.out.printf(game.payoutAll());

			//check each player for playing another game
			for(int playerIterator = 1; playerIterator < participants.size(); playerIterator++)
			{
				player = (BlackjackPlayer)participants.get(playerIterator);
				while(true)
				{	if(player.getPlayerMoney() > 0)
					{
						System.out.printf("\n\tPlayer #%d - play another round? 'y' or 'n'", playerIterator);
						removePlayer = input.next().charAt(0);

						if(removePlayer == 'n')
						{	
							System.out.printf("\n\t\tPlayer #%d quit - goodbye!", playerIterator);
							if(playerIterator != participants.size() - 1)
								System.out.printf("\n\t\tPlayer #%d now becomes Player #%d and so on...", playerIterator + 1, playerIterator);
							game.removePlayer(playerIterator);
							playerIterator--;
							break;
						}
						else if(removePlayer == 'y')
						{
							break;
						}
					}
					else //player out of money and should be removed
					{ 
						System.out.printf("\n\t\tPlayer #%d out of money - goodbye!", playerIterator);
						if(playerIterator != participants.size() - 1)
							System.out.printf("\n\t\tPlayer #%d now becomes Player #%d and so on...", playerIterator + 1, playerIterator);
						game.removePlayer(playerIterator);
						playerIterator--;
						break;
					}
				}
			}

			game.resetForAnotherRound();

			input.nextLine(); //move cursor to next line

			//check if want to play another game
			while(true)
			{	
				System.out.printf("\nEnter '1' to create a new Blackjack Game, '2' for another round, or '3' to end program: ");
				userInputPlayAnotherBlackjackGame = input.nextLine().charAt(0);
				if(userInputPlayAnotherBlackjackGame == '1')
				{
					playAnotherBlackjackGame = true;
					gameNumber++;
					games.add(new BlackjackGame());
					break;
				}
				else if(userInputPlayAnotherBlackjackGame == '2')
				{
					playAnotherBlackjackGame = true;
					break;
				}
				else if (userInputPlayAnotherBlackjackGame == '3')
				{
					playAnotherBlackjackGame = false;
					break;
				}
			}
		}				

		System.out.printf("\n\nEnding BlackjackGameSimulator!\n\n");
	}
}