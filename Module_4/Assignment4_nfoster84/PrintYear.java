import java.util.Scanner;

public class PrintYear
{
  public static void main (String [] args)
  {
    Scanner input = new Scanner(System.in);
    boolean done = false;

    System.out.print("\n\nThis program will print a given month from a given year");

    while(!done)
    {
      System.out.print("\n\nEnter a year. Then depress the Enter key:\t");
      printYearCalendar(input.nextInt());

      System.out.print("\n\nEnter 'd' for done or any other key to print another month.\n" + 
                          " Then depress the Enter key to continue:\t");
      if(input.next().charAt(0) == 'd')
        done = true;
    }

    System.out.print("\n\nDONE.\n\n");
  }

  /*
	PrintYear::printYearCalendar() prints a calendar for an entire input year 'yearToPrint'
	Pre-conditions: yearToPrint is greater than 0;
	Post-conditions: a ycalendar is output to the terminal
  */
  public static void printYearCalendar(int yearToPrint)
  {
  	for(int month = 1; month <= 12; month++)
  	{
  		printMonthCalendar(month, yearToPrint);
  	}
  }

  /*
  PrintYear::printMonthCalendar() prints a month header and a month body from an input month 'm' and an input year 'y'.
  Pre-conditions: m is 1-12; y is greater than 0;
  Post-condition: a month header and month body is output to the terminal
  */
  public static void printMonthCalendar(int m, int y)
  {
    printMonthHeader(m,y);
    printMonthBody(m,y);
  }

  /*
  PrintYear::printMonthHeader() is called by printMonthCalendar. It prints the header of a calendar for input month 'm' 
  and an input year 'y'.
  Pre-conditions: m is 1-12; y is greater than 0
  Post-conditions: a month header is output to the terminal
  */
  public static void printMonthHeader(int m, int y)
  {
    String month = getMonthName(m);
    System.out.printf("\n\n\t%s  %d", month, y);

    System.out.printf("\n-----------------------------");
    System.out.printf("\n Sun Mon Tue Wed Thu Fri Sat \n");

  }

  /*
  PrintYear::printMonthBody() is called by printMonthCalendar. It prints the body of a calendar for input month 'm' 
  and an input year 'y'.
  Pre-conditions: m is 1-12; y is greater than 0
  Post-conditions: a month body is output to the terminal
  */
  public static void printMonthBody(int m, int y)
  {
    int startDay = getStartDay(m, 1, y);
    startDay = startDay == 7 ? 0 : startDay;

    int weekDayCounter = 0;

    for(int i = 0; i < startDay; i++)
    {
      System.out.printf("    ");
      weekDayCounter++;
    }


    for(int i = 0; i < getDaysInMonth(m, y); i++)
    {
      System.out.printf("%4d", (i + 1));
      weekDayCounter++;

      if (weekDayCounter == 7)
      {
        weekDayCounter = 0;
        System.out.println();
      }
    }
  }

  /*
  PrintYear::getMonthName() returns a string object for a valid input integer month 'm' set equal to the string literal 
  corresponding to that month from a list of months. If the input is invalid, it returns invalid.
  Pre-conditions: m is 1-12
  Post-conditions: String month name returned for input month 'm'
  */
  public static String getMonthName(int m)
  {
    String [] months = new String[]{"January", "February", "March", "April", "May", "June", 
      "July", "August", "September", "October", "Novermber", "December"};

    return m >0 && m <= 12 ? months[m-1] : "INVALID";
  }

  /****
    The method getStartDay() implements Zeller's Algorithm for determining the day of the
    week the first day of a month is. The method adjusts Zeller's numbering scheme
    for day of week ( 0=Saturday, ..., 6=Friday ) to conform to a day of week number
    that corresponds to ISO conventions (i.e., 1=Monday, ..., 7=Sunday)
    
    Pre-Conditions: The month value, m,  is 1-12
                          The day value, d, is 1-31, or 1-28, 1-29 for February
                          The year value, y, is the full year (e.g., 2012)
                    
   Post-Conditions: A value of 1-7 is returned, representing the first day of the month
                          1 = Monday, ..., 7 = Sunday
  ****/
  public static int getStartDay( int m, int d, int y )
  {
    // Adjust month number & year to fit Zeller's numbering system
    if (m < 3) 
    {
      m = m + 12;
      y = y - 1;
    }
        
      int k = y % 100;      // Calculate year within century
      int j = y / 100;      // Calculate century term
      int h = 0;            // Day number of first day in month 'm'
      
      h = ( d + ( 13 * ( m + 1 ) / 5 ) + k + ( k / 4 ) + ( j / 4 ) +
          ( 5 * j ) ) % 7;
      
      // Convert Zeller's value to ISO value (1 = Mon, ... , 7 = Sun )
      int dayNum = ( ( h + 5 ) % 7 ) + 1;     
      
        return dayNum;
  }

  /*
  PrintYear::getDaysInMonth() returns integer value daysInMonth which is the number of days in the month 
  for an input month 'm' and year 'y'
  Pre-conditions: m is 1-12, y is greater than 0
  Post-conditons: daysInMonth returned
  */
  public static int getDaysInMonth(int m, int y)
  {
    int daysInMonth = 0;

    switch (m)
    {
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
    		daysInMonth = isLeapYear(y) ? 29 : 28;
    		break;
    	default:
    		break;
    }

    return daysInMonth;
  }

  /*
  PrintYear:isLeapYear() returns boolean value isLeapYear which is true if the input year 'y' is a leap year 
  or false if the input year 'y' is not a leap year.
  Pre-conditons: y is greater than 0;
  Post-conditions: isLeapYear returned
  */
  public static boolean isLeapYear(int y)
  {
    boolean isLeapYear = y % 4 > 0 ? false : true;

    return isLeapYear;
  }
}