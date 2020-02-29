import java.io.*; 
import java.util.*; 

public class GatherEmployeeData
{
	public static void main (String [] args)
	{
		char isNotDone = 'y';
		Scanner input = new Scanner(System.in);
		ArrayList<Employee> employees = new ArrayList<Employee>();
		int numberOfEmployees = 0;
		Address tempAddress = new Address();
		boolean dataInvalid = false;

		while (isNotDone != 'n')
		{
			System.out.printf("\n\nEnter 'y' to enter Employee data or 'n' to end. \nThen depress the Enter key: ");
			isNotDone = input.nextLine().charAt(0);

			if (isNotDone != 'y' && isNotDone != 'n')
				System.out.printf("\n\nINVALID input");
			else if (isNotDone == 'n')
				break;
			else
			{
				employees.add(new Employee());

				do
				{
					if(dataInvalid){
						dataInvalid = false;
						System.out.print("\n\nINVALID INPUT - Please try again!");
					}

					System.out.printf("\n\nEnter Employee number, then depress the Enter key: ");
					dataInvalid = dataInvalid? dataInvalid : !employees.get(numberOfEmployees).setEmployeeNumber(input.nextLine());
				}while(dataInvalid);

				do
				{
					if(dataInvalid){
						dataInvalid = false;
						System.out.print("\n\nINVALID INPUT - Please try again!");
					}

					System.out.printf("\n\n Enter Employee first and last name seperated by a space, then depress the Enter key: ");
					dataInvalid = dataInvalid? dataInvalid : !employees.get(numberOfEmployees).setEmployeeName(input.nextLine());
				}while(dataInvalid);

				do
				{
					if(dataInvalid){
						dataInvalid = false;
						System.out.print("\n\nINVALID INPUT - Please try again!");
					}

					System.out.printf("\n\nEnter Employee the following address data: ");
					System.out.printf("\n\tStreet Name: ");
					dataInvalid = dataInvalid? dataInvalid : !tempAddress.setStreetName(input.nextLine());
					System.out.printf("\n\tCity Name: ");
					dataInvalid = dataInvalid? dataInvalid : !tempAddress.setCityName(input.nextLine());
					System.out.printf("\n\tState Abreviation: ");
					dataInvalid = dataInvalid? dataInvalid : !tempAddress.setStateAbreviation(input.nextLine());
					System.out.printf("\n\tZip Code: ");
					dataInvalid = dataInvalid? dataInvalid : !tempAddress.setZipCode(input.nextLine());
				}while(dataInvalid);
				employees.get(numberOfEmployees).setEmployeeAddress(tempAddress);

				do
				{
					if(dataInvalid){
						dataInvalid = false;
						System.out.print("\n\nINVALID INPUT - Please try again!");
					}

					System.out.printf("\n\nEnter start date in the follow form MM/DD/YYYY: ");
					dataInvalid = dataInvalid? dataInvalid : !employees.get(numberOfEmployees).setEmployeeStartDate(input.nextLine());
				}while(dataInvalid);

				numberOfEmployees++;
			}
		}

		System.out.print("\n\nDisplaying Employee Data:");
		employees.forEach((employee) -> System.out.print("\n" + employee));

		System.out.printf("\n\nDONE");
	}
}