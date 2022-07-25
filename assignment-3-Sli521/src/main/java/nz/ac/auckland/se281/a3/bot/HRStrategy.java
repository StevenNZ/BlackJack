package nz.ac.auckland.se281.a3.bot;

import java.util.Random;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

public class HRStrategy implements BotStrategy {

	/**
	 * Takes in the hand of the bot and returns an action based on the hand. For
	 * high risk, if score is less than 19 then return hit else return hold
	 * 
	 * @param hand a class that has present information of current hand of the bot
	 * @return an action which is either hit or hold
	 */
	@Override
	public Action play(Hand hand) {
		if (hand.getScore() < 19) { // hit if score is less than 19 else hold
			return Action.HIT;
		} else {
			return Action.HOLD;
		}
	}

	/**
	 * randomly bets an integer amount. For high risk, bet is between 50 - 100
	 * inclusive
	 * 
	 * @return an integer of the bidding amount
	 */
	@Override
	public int bet() {
		Random random = new Random();
		int numberRandom = random.nextInt(50, 101); // generates a number from 50(inclusive) to 101(exclusive)
		return numberRandom;
	}

}
