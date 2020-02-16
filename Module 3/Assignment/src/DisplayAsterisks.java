import java.util.Scanner;

public class DisplayAsterisks 
{
	private static final int CHOICE_1 = 1;
	private static final int CHOICE_2 = 2;

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		boolean validResponse = false;

		while(!validResponse)
		{
			validResponse = printAsterisks()
		}

	}

	public static boolean printAsterisks(int asterisks, short choice)
	{
		boolean validChoice = false;

		switch choice
		{
			case CHOICE_1:
				validChoice = true;
				break;
			case CHOICE_2:
				validChoice = true;
				break;
			default
				break;
		}

		return validChoice;

	}

}
