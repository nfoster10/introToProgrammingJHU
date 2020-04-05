public class ArrayIndexOutOfBoundsExceptionCatch
{
	public static void main(String[]args)
	{
		int [] shotrtArray = {1,2,3};

		try {
			for(int i = 0; i < shotrtArray.length + 1; i++)
				System.out.print("\n\t" + shotrtArray[i]);
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.println("\n\tThe limit of the array was exceeded!");
		}
	}
}