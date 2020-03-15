public class HourlyEmployee extends Employee
{
	private double hourlyRate;
	private double averageHoursWorkedPerWeek;
	private double totalEarningsPerWeek;

	HourlyEmployee()
	{
		this.hourlyRate = 0;
		this.averageHoursWorkedPerWeek = 0;
		this.totalEarningsPerWeek = 0;
	}
	public String toString()
	{
		return super.toString() +
			String.format("\n\tHourly Rate: $%.2f", this.hourlyRate) +
			String.format("\n\tAverage Hours Worked Per Week: %.1f", this.averageHoursWorkedPerWeek) +
			String.format("\n\tAverage Weekly Pay: $%.2f", this.totalEarningsPerWeek) +
			String.format("\n\tYearly Pay Estimate: $%d", (int) this.getTotalEarningsPerYear());
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