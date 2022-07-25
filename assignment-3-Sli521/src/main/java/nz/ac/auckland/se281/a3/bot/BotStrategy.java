package nz.ac.auckland.se281.a3.bot;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

public interface BotStrategy {

	/**
	 * Takes in the hand of the bot and decides an action based on the strategy
	 * 
	 * @param hand a class that has present information of current hand of the bot
	 * @return either hit or hold
	 */
	Action play(Hand hand);

	/**
	 * randomly bets an integer amount depending on the strategy of the user's input
	 * 
	 * @return an integer of the bidding amount
	 */
	int bet();

}
