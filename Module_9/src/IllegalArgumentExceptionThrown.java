import java.util.*;

public class IllegalArgumentExceptionThrown
{
	public static void main(String [] args)
	{
		Scanner input = new Scanner(System.in);

		System.out.printf("\n\tEnter the number 1: ");
		inputChar1(input.next().charAt(0));
	}

	public static void inputChar1(char inputChar)
	{
		if (inputChar != '1')
			throw new IllegalArgumentException("1 != " + inputChar);
	}
}