public class Contact
{
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String emailAddress;

	//class constructor
	Contact()
	{
		firstName = new String();
		lastName = new String();
		phoneNumber = new String();
		emailAddress = new String();
	}
	
	//a more convienient constructor
	Contact(String firstName, String lastName, String phoneNumber, String emailAddress) 
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
	}

	public String toString()
	{
		return String.format("%-20s|%-20s|%-15s|%-50s", 
			firstName, lastName, phoneNumber, emailAddress);
	}
}