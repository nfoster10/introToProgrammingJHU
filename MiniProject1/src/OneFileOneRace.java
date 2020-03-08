
import java.io.*; 
import java.util.*; 

public class OneFileOneRace
{
	public static void main(String [] args)
	{
		Scanner input = new Scanner(System.in);
		boolean performAnotherRace = true;

		while(performAnotherRace)
		{
			System.out.print("\n\nEnter the total number of positions of the Hare vs. Tortoise Race and then depress the Enter key. \n" );
			Race race = new Race(input.nextInt());

			System.out.print("\n\nMyRace will now simulate a race. Enter any key then depress the Enter key for results...");
			input.next().charAt(0);
			
			Racer winner = race.simulateRace();

			if (winner != null)
				System.out.print("\n\n" + winner.getName() + " WINS!");
			else
				System.out.print("\n\nIT'S A TIE");


			System.out.print("\n\nEnter 'h' for race history or any other key to continue. \nThen depress the Enter key. \n" );
			if(input.next().charAt(0) == 'h')
				race.showHistory();

			System.out.print("\n\nEnter 'y' for another race or any other key to end. \nThen depress the Enter key. \n" );
			if(input.next().charAt(0) != 'y')
				performAnotherRace = false;
		} 
	}
}

//This class shall define a Race
class Race
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

class Racer
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

class Tortoise extends Racer
{
	Tortoise()
	{
		this.setName("TORTOISE");
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

//This class is a child of Racer and defines Hare

class Hare extends Racer
{

	Hare()
	{
		this.setName("HARE");
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