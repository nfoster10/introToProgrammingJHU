public class Date
{
	private int month;
	private int day;
	private int year;

	Date()
	{
		month = 0;
		day = 0;
		year = 0;
	}

	public String toString()
	{
		return String.format("%2d/%2d/%4d", month, day, year);
	}

	public boolean setMonth(int inputMonth)
	{
		boolean isDataValid = true;

		if (inputMonth >= 1 && inputMonth <= 12)
			this.month = inputMonth;
		else
			isDataValid = false;

		return isDataValid;
	}
	public int getMonth()
	{
		return this.month;
	}

	public boolean setDay(int inputDay)
	{
		boolean isDataValid = true;

		if (inputDay <= this.getDaysInMonth())
			this.day = inputDay;
		else
			isDataValid = false;

		return isDataValid;
	}
	public int getDay()
	{
		return this.day;
	}

	public boolean setYear(int inputYear)
	{
		boolean isDataValid = true;

		if(inputYear >= 1900 && inputYear <= 2020)
			this.year = inputYear;
		else
			isDataValid = false;

		return isDataValid;
	}
	public int getYear()
	{
		return this.year;
	}

	  /*
  PrintMonth::getDaysInMonth() returns integer value daysInMonth which is the number of days in the month 
  for an input month 'm' and year 'y'
  Pre-conditions: m is 1-12, y is greater than 0
  Post-conditons: daysInMonth returned
  */
  private int getDaysInMonth()
  {
    int daysInMonth = 0;

     switch (this.month)
    {
      case 0:
      case 1:
      case 3:
      case 5:
      case 7:
      case 8:
      case 10:
      case 12:
        daysInMonth = 31;
        break;
      case 4:
      case 6:
      case 9:
      case 11:
        daysInMonth = 30;
        break;
      case 2:
        daysInMonth = 0 == this.year % 4 ? 29 : 28;
        break;
      default:
        break;
    }

    return daysInMonth;
  }
}