//This class is a child of Racer and defines Tortoise
//This class will rename the object to TORTOISE and define the movement for the tortoise
public class Tortoise extends Racer
{
	Tortoise() //class concatnator
	{
		this.setName("TORTOISE");
	}

	//Tortoise::advance() takes a random input from 1-10 inclusive, updates the position of the tortoise per the random 
	//input as defined in the MiniProject1 document.
	//precondition: randomInput is between 1 and 10 inclusive
	//postcondiotn: the current positon after the hare has advanced is returned
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

	//Tortoise::performFastPlod() moves the tortoise forward 3 positons, returns this value and stores move/position history
	public int performFastPlod()
	{
		int newPosition = this.getRacePosiiton();
		newPosition += 3;

		this.raceHistoryMoves.add("FAST PLOD");
		this.raceHistoryPositions.add(newPosition);
		return newPosition;
	}

	//Tortoise::performSlowPlod() moves the tortoise forward 1 positons, returns this value and stores move/position history
	public int performSlowPlod()
	{
		int newPosition = this.getRacePosiiton();
		newPosition += 1;

		this.raceHistoryMoves.add("SLOW PLOD");
		this.raceHistoryPositions.add(newPosition);
		return newPosition;
	}

	//Tortoise::performSlip() moves the tortoise backward 6 positons, returns this value and stores move/position history
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