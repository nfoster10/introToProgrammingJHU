import java.util.*;

/**
* BlackjackPlayer is a child of the BlackjackPaticipant class. It defines actions
* specific to a blackjack player that the dealer does not perform.
* @author Nathaniel Foster
*/
public class BlackjackPlayer extends BlackjackParticipant
{
	private double playerMoney;
	private double currentBet;

	/**
	* Class concatenator
	*/
	BlackjackPlayer()
	{
		this.playerMoney = 0;
		this.currentBet = 0;
	}

	/**
	* Another class concatenator
	* @param buyIn sets this.playerMoney to buyIn on concatenation
	*/
	BlackjackPlayer(double buyIn)
	{
		this.playerMoney = buyIn;
		this.currentBet = 0;
	}

	/**
	* setPlayerMoney() is a setter for this.playerMoney for the calling BlackjackPlayer instance
	* @param playerMoney the input value to which to set this.playerMoney
	*/
	public void setPlayerMoney(double playerMoney)
	{
		this.playerMoney = playerMoney;
	}

	/**
	* setCurrentBet() is a setter for this.currentBet for the calling BlackjackPlayer instance
	* @param inputBet the input value to which to set this.currentBet
	* @return boolean true if bet is less than or equal to playerMoney or false
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
	*/
	public void win()
	{
		this.playerMoney += this.currentBet;
		this.currentBet = 0;
	}

	/**
	* lose() minuses the currentBet from the playerMoney and clears the currentBet
	*/
	public void lose()
	{
		this.playerMoney -= this.currentBet;
		this.currentBet = 0;
	}

	/**
	* tie() clears the currentBet only
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
	*/
	public void reset()
	{
		super.reset();
		this.currentBet = 0;
	}
}