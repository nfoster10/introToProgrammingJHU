import java.util.Scanner;

public class PrintMonth
{
  public static void main (String [] args)
  {
    Scanner input = new Scanner(System.in);
    boolean done = false;

    System.out.print("\n\nThis program will print a given month from a given year");

    while(!done)
    {
      System.out.print("\n\nEnter a month (1-12) and a year seperated by a space. Then depress the Enter key.");
      printMonthCalendar(input.nextInt(), input.nextInt());

      System.out.print("\n\nEnter 'd' for done or any other key. Then depress the Enter key to continue.");
      if(input.next().charAt() == 'd')
        done = true;
    }

    System.out.print("\n\nDONE.");
  }

  public static void printMonthCalendar(int m, int y)
  {
    printMonthHeader(m,y);
    printMonthBody(m,y);
  }

  public static void printMonthHeader(int m, int y)
  {
    String month = getMonthName(m);
    System.out.printf("\n\n\t\t%s  %d", month, y);

    System.out.printf("\n-----------------------------");
    System.out.printf("\n Sun Mon Tue Wed Thu Fri Sat ");

  }

  public static void printMonthBody(int m, int y)
  {
    int startDay = getStartDay(m, 1, y);
    startDay = startDay == 7? 0 : startDay;

    int weekDayCounter = 0;

    for(int i = 0; i < startDay; i++)
    {
      System.out.printf("     ");//&-4d");
      weekDayCounter++;
    }


    for(int i = 0; i < getDaysInMonth(m, y); i++)
    {
      System.out.printf("%-4d", (i + 1));
      weekDayCounter++;

      if (weekDayCounter == 7)
      {
        weekDayCounter = 0;
        System.out.println();
      }
    }
  }

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

  public static void getDaysInMonth(int m, int y)
  {
    
  }

  public static void isLeapYear(int y)
  {

  }
}