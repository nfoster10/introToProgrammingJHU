//This class shall define the parent class to Hare and Tortoise
import java.io.*; 
import java.util.*; 

public class Racer
{
	private int racePosition;
	private String name;
	public ArrayList<String> raceHistoryMoves;
	public ArrayList<Integer> raceHistoryPositions;


	Racer()
	{
		racePosition = 1;
		name = "Racer";
		raceHistoryMoves = new ArrayList<String>();
		raceHistoryPositions = new ArrayList<>();

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