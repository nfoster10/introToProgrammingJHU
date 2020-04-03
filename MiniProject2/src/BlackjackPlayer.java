import java.util.*;

public class BlackjackPlayer extends BlackjackParticipant
{
	private double playerMoney;
	private double currentBet;

	BlackjackPlayer()
	{
		this.playerMoney = 0;
		this.currentBet = 0;
	}
	BlackjackPlayer(double buyIn)
	{
		this.playerMoney = buyIn;
		this.currentBet = 0;
	}

	public void setPlayerMoney(double playerMoney)
	{
		this.playerMoney = playerMoney;
	}





	public boolean setCurrentBet(double inputBet)
	{
		boolean validData = false;

		if(inputBet > 0 && inputBet <= playerMoney)
		{
			this.currentBet = inputBet;
			validData = true;
		}

		return validData;
	}

	public double getCurrentBet()
	{
		return this.currentBet;
	}


}