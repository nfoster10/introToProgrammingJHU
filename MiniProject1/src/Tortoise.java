//This class is a child of Racer and defines Tortoise

public class Tortoise extends Racer
{
	Tortoise()
	{
		this.setName("Tortoise");
	}

	public int advance(int randomInput)
	{
		switch(randomInput)
		{
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
				this.setRacePosition(this.performFastPlod());
				break;
			case 6:
			case 7:
			case 8:
				this.setRacePosition(this.performSlowPlod());
				break;
			case 9:
			case 10:
				this.setRacePosition(this.performSlip());
				break;
			default:
				System.out.print("\nERROR\n");
				break;
		}

		return this.getRacePosiiton();
	}

	public int performFastPlod()
	{
		int newPosition = this.getRacePosiiton();
		newPosition += 3;

		this.raceHistoryMoves.add("FAST PLOD");
		this.raceHistoryPositions.add(newPosition);
		return newPosition;
	}

	public int performSlowPlod()
	{
		int newPosition = this.getRacePosiiton();
		newPosition += 1;

		this.raceHistoryMoves.add("SLOW PLOD");
		this.raceHistoryPositions.add(newPosition);
		return newPosition;
	}

	public int performSlip()
	{
		int newPosition = this.getRacePosiiton();
		newPosition -= 6;

		if(newPosition <= 0)
			newPosition = 1;
			
		this.raceHistoryMoves.add("SLIP");	
		this.raceHistoryPositions.add(newPosition);
		return newPosition;
	}
}