public class Name //defines an object of type Name
{
	private String firstName;
	private String lastName;

	Name() //class concatenator
	{
		this.firstName = "FirstName";
		this.lastName = "LastName";
	}

	//Name::toString() returns a string variable with lastName, firstName
	public String toString()
	{
		return String.format("%s, %s", lastName, firstName);
	}

	//Name::setFirstName() returns true and sets firstName to the inputfirstName
	//if inputFirstName is a valid input. All inputFirstName values are valid
	public boolean setFirstName(String inputFirstName)
	{
		boolean isValidData = true;
		this.firstName = inputFirstName;
		return isValidData;
	}

	//Name::setLastName() returns true and sets firstName to the inputfirstName
	//if inputLastName is a valid input. All inputLastName values are valid
	public boolean setLastName(String inputLastName)
	{
		boolean isValidData = true;
		this.lastName = inputLastName;
		return isValidData;
	}
}