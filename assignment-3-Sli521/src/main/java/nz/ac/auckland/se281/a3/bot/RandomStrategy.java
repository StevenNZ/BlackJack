package nz.ac.auckland.se281.a3.bot;

import java.util.Random;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

public class RandomStrategy implements BotStrategy {

	/**
	 * Randomly returns an action of hold or hit not based on the bot's hand
	 * 
	 * @param hand a class that has present information of current hand of the bot
	 * @return an action which is either hit or hold
	 */
	@Override
	public Action play(Hand hand) {
		Random random = new Random();
		float numberRandom = random.nextFloat();

		if (numberRandom < 0.5f) {// if the float is less than 0.5 then resulting action is hit else hold
			return Action.HIT;
		} else {
			return Action.HOLD;
		}
	}

	/**
	 * randomly bets an integer amount. For random, bet is between 1 - 100 inclusive
	 * 
	 * @return an integer of the bidding amount
	 */
	@Override
	public int bet() {
		Random random = new Random();
		int numberRandom = random.nextInt(1, 101); // generates a number from 1(inclusive) to 101(exclusive)
		return numberRandom;
	}

}
