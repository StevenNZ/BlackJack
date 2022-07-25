package nz.ac.auckland.se281.a3.bot;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Player;

/**
 * you should change this class for TASK 1
 */
public class Bot extends Player {

	private BotStrategy strategy;

	public Bot(String name) {
		super(name);
	}

	/**
	 * /** Takes in the hand of the bot and decides an action based on the strategy
	 * 
	 * @param hand a class that has present information of current hand of the bot
	 * @return either hit or hold
	 */
	@Override
	public Action decideAction(Hand hand) {
		return strategy.play(hand);
	}

	@Override
	public int makeABet() {
		return strategy.bet();
	}

	public void setStrategy(BotStrategy strategy) {
		this.strategy = strategy;
	}

}
