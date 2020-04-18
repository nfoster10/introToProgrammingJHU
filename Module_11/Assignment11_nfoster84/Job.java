import java.io.*;
import java.util.*;

public class Job
{
	private int jobNumber;
	private int printTimeInSeconds;

	Job(int jobNumber)
	{
		this.jobNumber = jobNumber;

		long rnSeed = jobNumber;
		Random rnGenerator = new Random( rnSeed ); // creates a Random object
		printTimeInSeconds = rnGenerator.nextInt( 1000 ) + 10; // next int in range 10-1000
	}

	public String toString()
	{
		return String.format("Job #: %d\t Job Time In Seconds: %d", jobNumber, printTimeInSeconds);
	}

}