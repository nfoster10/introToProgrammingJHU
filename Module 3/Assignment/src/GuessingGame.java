
import java.util.Scanner;

public class GuessingGame 
{
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		boolean success = false;

		System.out.print("\n\n\n");
		System.out.print("Please provid a number 'N' to be the MAX number for the Guessing Game! \n\n\t");
		int maxNumber = input.nextInt();
		int randomNumber = (int)( maxNumber * Math.random() ) + 1;

		while(!success)
		{
			System.out.print("\n\n\n");
			System.out.print("Enter guess and then depress the return key.");
			System.out.print("\n");
			success = processGuess(input.nextInt(), randomNumber);
		}
	}

	public static boolean processGuess(int guess, int correctNumber)
	{
		boolean validChoice = false;

		System.out.println("\n\n");

		if(guess > correctNumber)
			System.out.println("\nTOO HIGH\n");
		else if(guess < correctNumber)
			System.out.println("\nTOO LOW\n");
		else
		{
			validChoice = true;
			System.out.println("\nCORRECT\n");
		}
		return validChoice;
	}
}
