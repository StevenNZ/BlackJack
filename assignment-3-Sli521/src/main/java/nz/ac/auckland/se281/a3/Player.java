package nz.ac.auckland.se281.a3;

/**
 * 
 * You can (and should) add new fields and/or methods
 *
 */
public abstract class Player extends Participant {

	protected int wins = 0;
	protected int losts = 0;
	protected boolean isWin;

	public Player(String name) {
		super(name);
	}

	public abstract int makeABet();

	public int getNetWins() {
		return wins - losts;
	}

	public boolean getWin() {
		return isWin;
	}

	public int getNumberWins() {
		return wins;
	}

	public int getNumberLosts() {
		return losts;
	}

	/**
	 * This method checks the isWin instance field and returns if they win or lost
	 * 
	 * @param isWin an instance field that holds the current result of the instance
	 *              of the player
	 * @return a string of either "won" or "lost"
	 */
	public String getResult(boolean isWin) { // prints win or lost based on isWin

		if (isWin) {
			return " won ";
		} else {
			return " lost ";
		}
	}

	/**
	 * This method updates the wins or lost instance fields of the players as well
	 * as it's current result
	 * 
	 * @param win a boolean variable that determines if the player wins or lost
	 */
	public void setResult(boolean win) { // updates net wins and either win or lose boolean

		if (win) {
			wins++;
			isWin = true;
		} else {
			losts++;
			isWin = false;
		}
	}
}
