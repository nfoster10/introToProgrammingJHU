public class HourlyEmployee extends Employee
{
	private double hourlyRate;
	private double averageHoursWorkedPerWeek;
	private double totalEarningsPerWeek;

	HourlyEmployee()
	{
		this.hourlyRate = 0;
	}

	public boolean setHourlyRate(double inputHourlyRate)
	{
		boolean isDataValid = true;

		if (inputHourlyRate > 0)
			this.hourlyRate = inputHourlyRate;
		else
			isDataValid = false;

		if (averageHoursWorkedPerWeek > 0 && isDataValid) //only set totalEarningsPerWeek if averageHoursWorkedPerWeek already set
			totalEarningsPerWeek = averageHoursWorkedPerWeek > 40 ? this.hourlyRate * 40 + (averageHoursWorkedPerWeek - 40) : 
				this.hourlyRate * averageHoursWorkedPerWeek;

		return isDataValid; //must be greater than 0
	}
	public double getHourlyRate()
	{
		return hourlyRate;
	}

	public boolean setAverageHoursWorkedPerWeek(double inputAverageHoursWorkedPerWeek)
	{
		boolean isDataValid = true;
		if (inputAverageHoursWorkedPerWeek > 0 && inputAverageHoursWorkedPerWeek <= (7*24))
			this.averageHoursWorkedPerWeek = inputAverageHoursWorkedPerWeek;
		else
			isDataValid = false;

		if (hourlyRate > 0 && isDataValid) //only set totalEarningsPerWeek if hourlyRate already set
			totalEarningsPerWeek = averageHoursWorkedPerWeek > 40 ? this.hourlyRate * 40 + (averageHoursWorkedPerWeek - 40) : 
				this.hourlyRate * averageHoursWorkedPerWeek;

		return isDataValid; //must be greater than 0 but less than 7 * 24
	}
	public double getAverageHoursWorkedPerWeek()
	{
		return this.averageHoursWorkedPerWeek;
	}

	public double getTotalEarningsPerWeek()
	{
		return this.totalEarningsPerWeek;
	}
	public double getTotalEarningsPerYear()
	{
		return this.totalEarningsPerWeek * (double) 52;
	}
}