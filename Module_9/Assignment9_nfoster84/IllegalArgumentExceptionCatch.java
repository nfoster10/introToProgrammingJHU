import java.util.*;

public class IllegalArgumentExceptionCatch
{
	public static void main(String [] args)
	{
		Scanner input = new Scanner(System.in);

		try {
			System.out.printf("\n\tEnter the number 1: ");
			inputChar1(input.next().charAt(0));
		}
		catch (IllegalArgumentException e)
		{
			System.out.println("\n\tThe number 1 was not entered!");
		}
	}

	public static void inputChar1(char inputChar)
	{
		if (inputChar != '1')
			throw new IllegalArgumentException("1 != " + inputChar);
	}
}