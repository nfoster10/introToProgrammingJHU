public class SalariedEmployee extends Employee
{
	private int salary;

	SalariedEmployee()
	{
		this.salary = 0;
	}

	public boolean setSalary(int inputSalary)
	{
		boolean isValidData = true;

		this.salary = inputSalary;

		return isValidData;
	}
	public int getSalary()
	{
		return this.salary;
	}
}