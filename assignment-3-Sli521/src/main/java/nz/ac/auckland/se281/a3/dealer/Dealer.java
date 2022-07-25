package nz.ac.auckland.se281.a3.dealer;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant;

/**
 * 
 * You should change this class for Task 2
 *
 */
public class Dealer extends Participant {

	private DealerStrategy strategy;

	public Dealer(String name) {
		super(name);
	}

	/**
	 * Takes in the hand of the dealer and decides an action based on the strategy
	 * 
	 * @param hand a class that has present information of current hand of the bot
	 * @return either hit or hold
	 */
	@Override
	public Action decideAction(Hand hand) {

		return strategy.play(hand);
	}

	public void setStrategy(DealerStrategy strategy) {
		this.strategy = strategy;
	}
}
