import java.util.*;

/**
* BlackjackPlayer is a child of the BlackjackPaticipant class. It defines actions
* specific to a blackjack player that the dealer does not perform.
*/
public class BlackjackPlayer extends BlackjackParticipant
{
	private double playerMoney;
	private double currentBet;

	/**
	* Class concatenator
	* @return N/A
	*/
	BlackjackPlayer()
	{
		this.playerMoney = 0;
		this.currentBet = 0;
	}

	/**
	* Another class concatenator
	* @param buyIn sets this.playerMoney to buyIn on concatenation
	* @return N/A
	*/
	BlackjackPlayer(double buyIn)
	{
		this.playerMoney = buyIn;
		this.currentBet = 0;
	}

	/**
	* setPlayerMoney() is a setter for this.playerMoney for the calling BlackjackPlayer instance
	* @return N/A
	*/
	public void setPlayerMoney(double playerMoney)
	{
		this.playerMoney = playerMoney;
	}

	/**
	* setCurrentBet() is a setter for this.currentBet for the calling BlackjackPlayer instance
	* @return N/A
	*/
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

	/**
	* win() adds the currentBet to the playerMoney and clears the currentBet
	* @return N/A
	*/
	public void win()
	{
		this.playerMoney += this.currentBet;
		this.currentBet = 0;
	}

	/**
	* lose() minuses the currentBet from the playerMoney and clears the currentBet
	* @return N/A
	*/
	public void lose()
	{
		this.playerMoney -= this.currentBet;
		this.currentBet = 0;
	}

	/**
	* tie() clears the currentBet only
	* @return N/A
	*/
	public void tie()
	{
		this.currentBet = 0;
	}

	/**
	* getPlayerMoney() is a getter for this.playerMoney for the calling object
	* @return playerMoney for the calling BlackjackPlayer instance
	*/
	public double getPlayerMoney()
	{
		return this.playerMoney;
	}

	/**
	* reset() calls BlackjackParticipant.reset() and clears the currentBet
	* @return N/A
	*/
	public void reset()
	{
		super.reset();
		this.currentBet = 0;
	}


}