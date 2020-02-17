
//This class shall define a Race
import java.io.*; 
import java.util.*; 

public class Race
{
	private Hare hare;
	private Tortoise tortoise;
	public int raceProgress;
	public int raceLength;
	
	Race(int totalPositons)
	{
		this.hare = new Hare();
		this.tortoise = new Tortoise();

		this.raceProgress = 0;
		this.raceLength = totalPositons;
	}

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
				if(winner != null)
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
	public void showProgress(int progress)
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