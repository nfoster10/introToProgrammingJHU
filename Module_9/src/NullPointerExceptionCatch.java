public class NullPointerExceptionCatch
{
	public static void main(String[]args)
	{
		String nullString = null;

		try {
			nullString.contains("1");
		}
		catch (NullPointerException e)
		{
			System.out.println("\n\tThe String is null, cannot search!");
		}
	}
}