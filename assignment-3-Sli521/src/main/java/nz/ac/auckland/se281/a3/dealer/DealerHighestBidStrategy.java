package nz.ac.auckland.se281.a3.dealer;

import nz.ac.auckland.se281.a3.BlackJack;
import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

public class DealerHighestBidStrategy implements DealerStrategy {

	private BlackJack game;

	/**
	 * A constructor which takes in an instance of a black jack game and gives
	 * access in this class
	 * 
	 * @param game instance of a blackjack game
	 */
	public DealerHighestBidStrategy(BlackJack game) { // getting instance of the game
		this.game = game;
	}

	/**
	 * Takes in the hand of the dealer and return an action depending on the hand
	 * and also the hands of other players in the instance of the black jack game
	 * 
	 * @param hand a class that has present information of current hand of the
	 *             dealer
	 * @return an action which is either hit or hold
	 */
	@Override
	public Action play(Hand hand) {

		if (hand.getScore() >= game.getHighestBidTarget().getHand().getScore() // checks if score is greater than target
				|| game.getHighestBidTarget().getHand().isBust() // checks if target busted
				|| (game.getHighestBidTarget().getHand().isBlackJack() && hand.getScore() >= 17)) { // special case
			return Action.HOLD;
		} else {
			return Action.HIT;
		}
	}

}
