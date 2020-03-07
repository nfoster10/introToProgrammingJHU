public class Date //defines an object of type Date
{
	private int month;
	private int day;
	private int year;

	Date() //class concatenator
	{
		month = 0;
		day = 0;
		year = 0;
	}

	//Date::toString() returns a string variable of MM/DD/YYYY
	public String toString()
	{
		return String.format("%2d/%2d/%4d", month, day, year);
	}

	//Date::setMonth() returns true and stores inputMonth if valid inputMonth (1 <= inputMonth <= 12)
	//returns false and terminates processing if invalid inputMonth
	public boolean setMonth(int inputMonth)
	{
		boolean isDataValid = true;

		//check if valid inputMonth
		if (inputMonth >= 1 && inputMonth <= 12)
			this.month = inputMonth;
		else
			isDataValid = false;

		return isDataValid;
	}
	//Date::getMonth() returns int variable month for the calling Date object
	public int getMonth()
	{
		return this.month;
	}

	//Date::setDay() returns true and stores inputDay if input valid inputDay
	//returns false and terminates processing if input invalid inputDay
	//inputDay valid if greater than 0 AND less than or equal getDaysInMonth 
	public boolean setDay(int inputDay)
	{
		boolean isDataValid = true;

		if (inputDay <= this.getDaysInMonth() && inputDay > 0)
			this.day = inputDay;
		else
			isDataValid = false;

		return isDataValid;
	}

	//Date::getDay() returns int variable day for calling Date object
	public int getDay()
	{
		return this.day;
	}

	//Date::setYear() returns true and stores inputYear if valid inputYear
	//returns false and terminates processing if inputYear invalid
	public boolean setYear(int inputYear)
	{
		boolean isDataValid = true;

		//inputYear valid if between 1900 and 2020 inclusive
		if(inputYear >= 1900 && inputYear <= 2020)
			this.year = inputYear;
		else
			isDataValid = false;

		return isDataValid;
	}

	//Date::getyear() returns int variable year for calling Date object
	public int getYear()
	{
		return this.year;
	}

  /*
  PrintMonth::getDaysInMonth() returns integer value daysInMonth which is the number of days in the month 
  for object month and year
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