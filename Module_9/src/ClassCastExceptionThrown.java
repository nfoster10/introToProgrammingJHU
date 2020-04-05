public class ClassCastExceptionThrown
{
	public static void main(String[]args)
	{
		Object someObject = new String();

		int i = (int) someObject;
	}
}