public class Employee
{
	private String employeeNumber;
	private Name employeeName;
	private Address employeeAddress;
	private Date hireDate;

	Employee()
	{
		this.employeeNumber = "######";
		this.employeeName = new Name();
		this.employeeAddress = new Address();
		this.hireDate = new Date();
	}

	public String toString()
	{
		return "\nEmployee " + this.employeeNumber + " Data" +
			   "\n\tName: " + this.employeeName +
			   "\n\tAddress: " + this.employeeAddress +
			   "\n\tHire Date: " + this.hireDate;
	}

	public boolean setEmployeeNumber(String inputEmployeeNumber)
	{
		boolean isValidEmployeeNumber = true;

		//check if inputEmployeeNumber does not contain only digits
		for (int letterIterator = 0; letterIterator < inputEmployeeNumber.length(); letterIterator++)
			isValidEmployeeNumber = isValidEmployeeNumber ? Character.isDigit(inputEmployeeNumber.charAt(letterIterator)) : isValidEmployeeNumber;

		this.employeeNumber = isValidEmployeeNumber? inputEmployeeNumber : "ERROR: invalid employeeNumber!";

		return isValidEmployeeNumber;
	}

	public boolean setEmployeeName(String inputEmployeeName)
	{
		boolean isValidEmployeeName = true;
		String [] formattedInputEmployeeName = inputEmployeeName.split("\\s+");

		if(formattedInputEmployeeName.length > 1)
		{	
			this.employeeName.setFirstName(formattedInputEmployeeName[0]);
			this.employeeName.setLastName(formattedInputEmployeeName[formattedInputEmployeeName.length - 1]);
		}
		else
			isValidEmployeeName = false;

		return isValidEmployeeName;
	}

	public boolean setEmployeeAddress(Address inputEmployeeAddress)
	{
		this.employeeAddress.setStreetName(inputEmployeeAddress.getStreetName());
		this.employeeAddress.setCityName(inputEmployeeAddress.getCityName());
		this.employeeAddress.setStateAbreviation(inputEmployeeAddress.getStateAbreviation());
		this.employeeAddress.setZipCode(inputEmployeeAddress.getZipCode());

		return true; //assume true since Address set fxns already check for valid data
	}

	public boolean setEmployeeStartDate(String inputStartDate)
	{
		boolean isValidDate = true;
		String [] stringFormatedInputEmployeeStartDate = inputStartDate.split("/");

		//check that stringFormatedInputEmployeeStartDate contains all numbers
		for(String dateIterator : stringFormatedInputEmployeeStartDate)
			for (int letterIterator = 0; letterIterator < dateIterator.length(); letterIterator++)
				isValidDate = isValidDate ? Character.isDigit(dateIterator.charAt(letterIterator)) : isValidDate;

		//only contiue if still considered valid and correct number of "/" entered
		if(isValidDate && stringFormatedInputEmployeeStartDate.length == 3)
		{
			int [] intFormattedInputEmployeeStartDate = new int[stringFormatedInputEmployeeStartDate.length];

			for (int dateIterator = 0; dateIterator < stringFormatedInputEmployeeStartDate.length; dateIterator++)
			{
				intFormattedInputEmployeeStartDate[dateIterator] = Integer.parseInt(stringFormatedInputEmployeeStartDate[dateIterator]);
			}

			isValidDate = isValidDate? this.hireDate.setMonth(intFormattedInputEmployeeStartDate[0]) : isValidDate;
			isValidDate = isValidDate? this.hireDate.setYear(intFormattedInputEmployeeStartDate[2]) : isValidDate;
			isValidDate = isValidDate? this.hireDate.setDay(intFormattedInputEmployeeStartDate[1]) : isValidDate;
		}
		else
			isValidDate = false;

		return isValidDate;
	}
}