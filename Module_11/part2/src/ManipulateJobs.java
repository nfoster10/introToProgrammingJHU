import java.io.*;
import java.util.*;

public class ManipulateJobs
{
	public static void main(String [] args)
	{
		Scanner userInpt = new Scanner(System.in);
		LinkedList<Job> jobQueue = new LinkedList<Job>();
		int jobCounter = 0;

		while(true)
		{
			System.out.println("\nEnter anything to add a job or 'quit' to quit: ");
			if(!userInpt.nextLine().trim().equals("quit"))
			{
				//add a job to the queue
				jobQueue.add(new Job(jobCounter));

				System.out.println("\tAdding " + jobQueue.getLast());

				jobCounter++;
			}
			else
				break;
		}

		//display the job queue
		System.out.println("Quit command received. Showing job queue: ");
		for(Job job : jobQueue)
			System.out.println(job);
	}
}