package nz.ac.auckland.se281.a3.bot;

import java.util.Random;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

public class LRStrategy implements BotStrategy {

	/**
	 * Takes in the hand of the bot and returns an action based on the hand. For low
	 * risk, if score is less than 17 then return hit else return hold
	 * 
	 * @param hand a class that has present information of current hand of the bot
	 * @return an action which is either hit or hold
	 */
	@Override
	public Action play(Hand hand) {

		if (hand.getScore() < 17) { // hit if score is less than 17 else hold
			return Action.HIT;
		} else {
			return Action.HOLD;
		}
	}

	/**
	 * randomly bets an integer amount. For low risk, bet is between 10 - 50
	 * inclusive
	 * 
	 * @return an integer of the bidding amount
	 */
	@Override
	public int bet() {
		Random random = new Random();
		int numberRandom = random.nextInt(10, 51); // generates a number from 10(inclusive) to 51(exclusive)
		return numberRandom;
	}

}
