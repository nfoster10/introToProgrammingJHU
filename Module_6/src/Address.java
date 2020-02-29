public class Address
{
	private String streetName;
	private String cityName;
	private String stateAbreviation;
	private String zipCode;

	Address()
	{
		this.streetName = new String();
		this.cityName = new String();
		this.stateAbreviation = new String();
		this.zipCode = new String();
	}

	public String toString()
	{
		return String.format("%s %s, %s %s", streetName, cityName, stateAbreviation, zipCode);
	}

	public boolean setStreetName(String inputStreetName)
	{
		boolean validData = true;

		//No error conditions
		this.streetName = inputStreetName;

		return validData;
	}

	public String getStreetName()
	{
		return this.streetName;
	}

	public boolean setCityName(String inputCityName)
	{
		boolean validData = true;

		//no error condiitons
		this.cityName = inputCityName;

		return validData;
	}
	public String getCityName()
	{
		return this.cityName;
	}

	public boolean setStateAbreviation(String inputStateAbreviation)
	{
		boolean validData = true;
		inputStateAbreviation = inputStateAbreviation.trim();

		if (inputStateAbreviation.length() == 2)
			for (int letterIterator = 0; letterIterator < inputStateAbreviation.length(); letterIterator++)
				validData = validData ? !Character.isDigit(inputStateAbreviation.charAt(letterIterator)) : validData;
		else
			validData = false;

		if (validData)
			this.stateAbreviation = inputStateAbreviation.toUpperCase();

		return validData;
	}
	public String getStateAbreviation()
	{
		return this.stateAbreviation;
	}

	public boolean setZipCode(String inputZipCode)
	{
		boolean validData = true;

		if (inputZipCode.length() == 5)
			for (int letterIterator = 0; letterIterator < inputZipCode.length(); letterIterator++)
				validData = validData ? Character.isDigit(inputZipCode.charAt(letterIterator)) : validData;
		else
			validData = false;

		if(validData)
			this.zipCode = inputZipCode;

		return validData;
	}
	public String getZipCode()
	{
		return this.zipCode;
	}
}