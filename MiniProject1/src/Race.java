
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

		while(winner == null)
		{
			raceProgress++;

			if (hare.advance((int)(10 * Math.random() + 1)) >= raceLength)
				winner = hare;
			if (winner == null & tortoise.advance((int)(10 * Math.random() + 1)) >= raceLength)
				winner = tortoise;
		}
		return winner;
	}

	public void showHistory()
	{
			System.out.print("\n\tHare\t\t\t\tTortoise");

		for (int i = 0; i <= raceProgress; i++)
		{
			System.out.printf("\n%d:\t%d\t%s \t\t%d\t%s", i, hare.raceHistoryPositions.get(i), hare.raceHistoryMoves.get(i), 
				tortoise.raceHistoryPositions.get(i), tortoise.raceHistoryMoves.get(i));
		}

	}
}