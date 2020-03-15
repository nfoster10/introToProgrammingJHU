//This class shall define the parent class to Hare and Tortoise
/*Racer is the parent class of both Hare and Tortoise. It contains 
the data that is shared between every racer (in this case the hare 
and the tortoise) but is specific to an individual racer and not a 
Race object. This data includes current position in the race, 
racePosition, a name, a history of the racer’s moves and position in 
the race, raceHistoryMoves and raceHistoryPositions respectively. 
Only relevant get methods and set methods are defined for the relevant
data. */
import java.io.*; 
import java.util.*; 

public class Racer
{
	private int racePosition;
	private String name;
	public ArrayList<String> raceHistoryMoves;
	public ArrayList<Integer> raceHistoryPositions;

	Racer() //class concatnator
	{
		racePosition = 1;
		name = "Racer";
		raceHistoryMoves = new ArrayList<String>();
		this.raceHistoryMoves.add("START\t");
		raceHistoryPositions = new ArrayList<>();
		this.raceHistoryPositions.add(1);

	}
	public String getName()
	{
		return name;
	}
	public void setName(String newName)
	{
		name = newName;
	}
	public int getRacePosiiton()
	{
		return racePosition;
	}
	public void setRacePosition(int position)
	{
		racePosition = position;
	}
}