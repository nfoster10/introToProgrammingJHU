public class ArrayIndexOutOfBoundsExceptionThrown
{
	public static void main(String[]args)
	{
		int [] shotrtArray = {1,2,3};

		for(int i = 0; i < shotrtArray.length + 1; i++)
			System.out.print("\n\t" + shotrtArray[i]);
	}
}