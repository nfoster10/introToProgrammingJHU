//This class is a child of Racer and defines Hare
//This class will rename the object to HARE and define the movement for the hare
public class Hare extends Racer
{

	Hare() //class concatenator
	{
		this.setName("HARE");
	}

	//Hare::advance() takes a random input from 1-10 inclusive, updates the position of the hare per the random 
	//input as defined in the MiniProject1 document.
	//precondition: randomInput is between 1 and 10 inclusive
	//postcondiotn: the current positon after the hare has advanced is returned
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

	//Hare::performBigHop() moves the hare forward 9 positons, returns this value and stores move/position history
	public int performBigHop()
	{
		int newPosition = this.getRacePosiiton();
		newPosition += 9;
			
		this.raceHistoryMoves.add("BIG HOP");	
		this.raceHistoryPositions.add(newPosition);
		return newPosition;
	}

	//Hare::performSmallHop() moves the hare forward 1 positon, returns this value and stores move/positon history
	public int performSmallHop()
	{
		int newPosition = this.getRacePosiiton();
		newPosition += 1;
			
		this.raceHistoryMoves.add("SMALL HOP");	
		this.raceHistoryPositions.add(newPosition);
		return newPosition;
	}

	//Hare::performBigSlip() moves the hare backward 12 positions, returns this value and stores move/position history
	//if the hare slips below 0, the position is defaulted to 1.
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

	//Hare::performSmallSlip() moves the hare backward 2 positions, returns this value and stores move/position history
	//if the hare slips below 0, the position is defaulted to 1
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

	//Hare::performSleep() leaves the hare at current posiiton, returns this value and stores move/positon history
	public int performSleep()
	{
		int newPosition = this.getRacePosiiton();
			
		this.raceHistoryMoves.add("SLEEP\t");	
		this.raceHistoryPositions.add(newPosition);
		return newPosition;
	}
}