import java.io.*; 
import java.util.*; 

public class GatherPaidEmployeeData
{
	private static Scanner input = new Scanner(System.in);
	private static ArrayList<Employee> employees = new ArrayList<Employee>();
	private static Address tempAddress = new Address();
	private static boolean dataInvalid = false;

	public static void main (String [] args)
	{
		char isNotDone = 'y';
		int numberOfEmployees = 0;
		char salaryOrHourly;

		while (isNotDone != 'n')
		{
			System.out.printf("\n\nEnter 'y' to enter Employee data or 'n' to end. \nThen depress the Enter key: ");
			isNotDone = input.nextLine().charAt(0);

			//if the input is not y or n, output error
			//if the input is n, break
			//if the input is y, continue
			if (isNotDone != 'y' && isNotDone != 'n')
				System.out.printf("\n\nINVALID input");
			else if (isNotDone == 'n')
				break;
			else
			{
				System.out.printf("\n\nEnter 's' for salaried employee or 'h' for hourly employee.");
				System.out.printf("\nThen depress the Enter key: ");
				salaryOrHourly = input.nextLine().charAt(0);

				if (salaryOrHourly == 's')
				{
					employees.add(new SalariedEmployee());
					getStandardEmployeeData(numberOfEmployees);

					do //get employee salary
					{
						if(dataInvalid){
							dataInvalid = false;
							System.out.print("\n\nINVALID INPUT - Please try again!");
						}

						System.out.printf("\n\nEnter employee salary without any commas to the nearest dollar: $");
						dataInvalid = dataInvalid? dataInvalid : !((SalariedEmployee)employees.get(numberOfEmployees)).setSalary(input.nextInt());
					}while(dataInvalid);

					numberOfEmployees++;
					input.nextLine(); //consume rest of line
				}
				else if (salaryOrHourly == 'h')
				{
					employees.add(new HourlyEmployee());
					getStandardEmployeeData(numberOfEmployees);

					do //get employee hourly rate
					{
						if(dataInvalid){
							dataInvalid = false;
							System.out.print("\n\nINVALID INPUT - Please try again!");
						}

						System.out.printf("\n\nEnter employee hourly rate: $");
						dataInvalid = dataInvalid? dataInvalid : !((HourlyEmployee)employees.get(numberOfEmployees)).setHourlyRate(input.nextDouble());
					}while(dataInvalid);

					do //get employee average hours per week
					{
						if(dataInvalid){
							dataInvalid = false;
							System.out.print("\n\nINVALID INPUT - Please try again!");
						}

						System.out.printf("\n\nEnter employee average hours worked per week: ");
						dataInvalid = dataInvalid? dataInvalid : !((HourlyEmployee)employees.get(numberOfEmployees)).setAverageHoursWorkedPerWeek(input.nextInt());
					}while(dataInvalid);

					numberOfEmployees++;
					input.nextLine(); //consume rest of line
				}
				else
				{
					System.out.print("\n\nINVALID INPUT");
				}

			}
		}

		System.out.print("\n\nDisplaying Employee Data:");
		employees.forEach((employee) -> System.out.print("\n" + employee));

		System.out.printf("\n\nDONE");
	}

	public static void getStandardEmployeeData(int numberOfEmployees)
	{
		do //get Employee number
		{
			if(dataInvalid){
				dataInvalid = false; //must reset in order to re-enter data
				System.out.print("\n\nINVALID INPUT - Please try again!");
			}

			System.out.printf("\n\nEnter Employee number, then depress the Enter key: ");
			dataInvalid = dataInvalid? dataInvalid : !employees.get(numberOfEmployees).setEmployeeNumber(input.nextLine());
		}while(dataInvalid);

		do //get employee name
		{
			if(dataInvalid){
				dataInvalid = false;
				System.out.print("\n\nINVALID INPUT - Please try again!");
			}

			System.out.printf("\n\n Enter Employee first and last name seperated by a space, then depress the Enter key: ");
			dataInvalid = dataInvalid? dataInvalid : !employees.get(numberOfEmployees).setEmployeeName(input.nextLine());
		}while(dataInvalid);

		do //get employee address
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

		do //get employee start date
		{
			if(dataInvalid){
				dataInvalid = false;
				System.out.print("\n\nINVALID INPUT - Please try again!");
			}

			System.out.printf("\n\nEnter start date in the follow form MM/DD/YYYY: ");
			dataInvalid = dataInvalid? dataInvalid : !employees.get(numberOfEmployees).setEmployeeStartDate(input.nextLine());
		}while(dataInvalid);
	}
}