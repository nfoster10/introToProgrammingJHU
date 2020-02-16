//This class is a child of Racer and defines Hare

public class Hare extends Racer
{

	Hare()
	{
		this.setName("Hare");
	}

	public void advance(int randomInput)
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
	}

	public void performBigHop()
	{

	}

	public void performSmallHop()
	{

	}

	public void performBigSlip()
	{

	}
	public void performSmallSlip()
	{

	}
	public void performSleep()
	{

	}

}




