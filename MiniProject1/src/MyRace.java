//This class contains the main function

import java.util.Scanner;

public class MyRace
{
	public static void main(String [] args)
	{
		Scanner input = new Scanner(System.in);
		boolean performAnotherRace = true;

		do
		{
			System.out.print("\n\nEnter the total number of positions of the race and then depress the Enter key. \n" );
			Race race = new Race(input.nextInt());

			System.out.print("\n\nMyRace will now simulate a race!");
			
			Racer winner = race.simulateRace();

			System.out.print("\n\nThe " + winner.getName() + " is the winner!");
			System.out.print("\n\nEnter 'h' for race history or any other key to continue. \nThen depress the Enter key. \n" );

			if(input.nextChar() == 'h')
				race.showHistory();

			System.out.print("\n\nEnter 'y' for another race or any other key to end. \nThen depress the Enter key. \n" );
			if(input.nextChar() != 'y')
				performAnotherRace = false;

		} while(performAnotherRace)
	}
}