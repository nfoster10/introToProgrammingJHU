public class Name
{
	private String firstName;
	private String lastName;

	Name()
	{
		this.firstName = "FirstName";
		this.lastName = "LastName";
	}

	public String toString()
	{
		return String.format("%s, %s", lastName, firstName);
	}

	public boolean setFirstName(String inputFirstName)
	{
		boolean isValidData = true;
		this.firstName = inputFirstName;
		return isValidData;
	}

	public boolean setLastName(String inputLastName)
	{
		boolean isValidData = true;
		this.lastName = inputLastName;
		return isValidData;
	}
}