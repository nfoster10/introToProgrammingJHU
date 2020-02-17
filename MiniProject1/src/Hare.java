//This class is a child of Racer and defines Hare

public class Hare extends Racer
{

	Hare()
	{
		this.setName("Hare");
	}

	public int advance(int randomInput)
	{
		switch(randomInput)
		{
			case 1:
			case 2:
				this.setRacePosition(this.performBigHop());
				break;
			case 3:
			case 4:
			case 5:
				this.setRacePosition(this.performSmallHop());
				break;
			case 6:
				this.setRacePosition(this.performBigSlip());
				break;
			case 7:
			case 8:
				this.setRacePosition(this.performSmallSlip());
				break;
			case 9:
			case 10:
				this.setRacePosition(this.performSleep());
				break;
			default:
				System.out.print("\nERROR\n");
				break;
		}
		return this.getRacePosiiton();
	}
	public int performBigHop()
	{
		int newPosition = this.getRacePosiiton();
		newPosition += 9;
			
		this.raceHistoryMoves.add("BIP HOP");	
		this.raceHistoryPositions.add(newPosition);
		return newPosition;
	}
	public int performSmallHop()
	{
		int newPosition = this.getRacePosiiton();
		newPosition += 1;
			
		this.raceHistoryMoves.add("SMALL HOP");	
		this.raceHistoryPositions.add(newPosition);
		return newPosition;
	}
	public int performBigSlip()
	{
		int newPosition = this.getRacePosiiton();
		newPosition -= 12;

		if(newPosition <= 0)
			newPosition = 1;
			
		this.raceHistoryMoves.add("BIG SLIP");	
		this.raceHistoryPositions.add(newPosition);
		return newPosition;
	}
	public int performSmallSlip()
	{
		int newPosition = this.getRacePosiiton();
		newPosition -= 2;

		if(newPosition <= 0)
			newPosition = 1;
			
		this.raceHistoryMoves.add("SMALL SLIP");	
		this.raceHistoryPositions.add(newPosition);
		return newPosition;
	}
	public int performSleep()
	{
		int newPosition = this.getRacePosiiton();
			
		this.raceHistoryMoves.add("SLEEP\t");	
		this.raceHistoryPositions.add(newPosition);
		return newPosition;
	}
}