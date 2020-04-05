public class ClassCastExceptionCatch
{
	public static void main(String[]args)
	{
		Object someObject = new String();

		try{
			int i = (int) someObject;
		}
		catch (ClassCastException e)
		{
			System.out.println("someObject cannot be casted to an int");
		}
	}
}