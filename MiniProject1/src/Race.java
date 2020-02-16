
//This class shall define a Race
import java.io.*; 
import java.util.*; 

public class Race
{
	private Racer [] racers;
	public int raceProgress;
	public int raceLength;
	

	Race(int totalPositons)
	{
		this.racers = { new Hare(), new Tortoise()};
		this.raceProgress = 0;
		this.raceLength = totalPositons;
	}

	public Racer simulateRace()
	{
		Racer winner = NULL;

		while(winner == NULL)
		{
			raceProgress++;

			for (Racer contender : racers)
				if (contender.advance((int)(10 * Math.random() + 1)) >= raceLength)
					winner = contender;
		}
		return winner;
	}

	/*public void showHistory()
	{

	}*/
}