public class SalariedEmployee extends Employee
{
	private int salary;

	SalariedEmployee()
	{
		this.salary = 0;
	}
	public String toString()
	{
		return super.toString() +
			String.format("\n\tYearly Salary: $%d", this.salary);
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