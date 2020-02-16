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
			System.out.print("\n\n\n");
			System.out.print("Enter max asterisks and choice (1 or 2) seperated by a blank space and then depress the return key.");
			System.out.print("\n\n");
			validResponse = printAsterisks(input.nextInt(), (short) input.nextInt());
		}

	}

	public static boolean printAsterisks(int asterisks, short choice)
	{
		boolean validChoice = true;

		System.out.println("\n\n");

		switch(choice)
		{
			case CHOICE_1:
				for(int i = 1; i <= asterisks; i++)
				{
					System.out.print("\t\t" + i + ": ");
					for (int j = 0; j < i; j++)
						System.out.print(" * ");
					System.out.println();
				}
				break;

			case CHOICE_2:
				for(int i = asterisks; i > 0; i--)
				{
					System.out.print("\t\t" + (asterisks + 1 - i) + ": ");
					for (int j = 0; j < i; j++)
						System.out.print(" * ");
					System.out.println();
				}
				break;

			default:
				System.out.print("\t\tInvalid Choice! Pick 1 or 2. Try again.");
				System.out.println();
				validChoice = false;
				break;
		}
		return validChoice;
	}
}