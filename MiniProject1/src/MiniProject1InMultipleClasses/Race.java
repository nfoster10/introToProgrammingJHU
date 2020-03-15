
//This class shall define a Race.
/*Race defines an object of type Race. A Race object has two racers which are the 
hare and the tortoise, an indication of elapsed time or progress made it in the race, 
raceProgress, and a total length of the race, raceLength. The total length of the 
race had to be stored for each race since it the race length is input by the user. 
Race also contains methods for simulating a race to determine a winner, showing the 
progress of the race, and the function to show the history of a simulated race.*/
import java.io.*; 
import java.util.*; 

public class Race
{
	private Hare hare;
	private Tortoise tortoise;
	public int raceProgress;
	public int raceLength;
	
	Race(int totalPositons) //class concatenator
	{
		this.hare = new Hare();
		this.tortoise = new Tortoise();

		this.raceProgress = 0;
		this.raceLength = totalPositons;
	}

	//Race::simulateRace() simulates a race between the hare and the tortoise for an input length during concatenation.
	//precondition: N/A
	//postcondition: return winner of race of type Racer or null pointer if tied
	public Racer simulateRace()
	{
		Racer winner = null;

		System.out.print("\nAND THEY'RE OFF!");
		this.showProgress(raceProgress);

		while(winner == null)
		{
			if (hare.advance((int)(10 * Math.random() + 1)) >= raceLength)
				winner = hare;
			if (tortoise.advance((int)(10 * Math.random() + 1)) >= raceLength)
			{
				if(winner != null) //if winner is already set, it must be a tie
				{
					winner = null;

					raceProgress++;
					this.showProgress(raceProgress);

					break;
				}
				winner = tortoise;
			}

			raceProgress++;
			this.showProgress(raceProgress);
			
		}
		return winner;
	}

	//Race::showProgress() displays the current progress of the race while the race is being simulated
	//precondition: progress is a positive integer
	//postcondition: race progress is displayed to the terminal
	private void showProgress(int progress)
	{
		System.out.print("\n\tRace Progress:\n\t");
		for (int i = 0; i < this.raceLength; i++)
			System.out.printf("%-3d  ", (i + 1));
		System.out.print("\n\t");

		String display = new String();

		for (int i = 1; i <= this.raceLength; i++)
		{
			if(this.hare.raceHistoryPositions.get(progress) == i 
				|| (this.hare.raceHistoryPositions.get(progress) >= this.raceLength && i == this.raceLength))
			{
				display = this.hare.raceHistoryPositions.get(progress) == this.tortoise.raceHistoryPositions.get(progress) ? 
					"OUCH!":"H    ";
				System.out.print(display);
			}
			else
				System.out.print("     ");
		}
		System.out.print("\n\t");
		for (int i = 1; i <= this.raceLength; i++)
		{
			if(this.tortoise.raceHistoryPositions.get(progress) == i
				|| (this.tortoise.raceHistoryPositions.get(progress) >= this.raceLength && i == this.raceLength))
			{
				if (!display.equals("OUCH!"))
					display = "T    ";
				System.out.print(display);
			}
			else
				System.out.print("     ");
		}
	}

	//Race::showHistory() outputss a brief history of a race to the terminal
	//preconditon: the race has been simulated
	//poscondition: race history brief is output to the terminal
	public void showHistory()
	{
		System.out.print("\n\tHare\t\t\t\tTortoise");

		for (int i = 0; i <= raceProgress; i++)
		{
			System.out.printf("\n%d:\t%d\t%s \t\t%d\t%s", i, hare.raceHistoryPositions.get(i), hare.raceHistoryMoves.get(i), 
				tortoise.raceHistoryPositions.get(i), tortoise.raceHistoryMoves.get(i));
			if (hare.raceHistoryPositions.get(i) == tortoise.raceHistoryPositions.get(i))
				System.out.print("\t\tOUCH!");
		}
	}
}