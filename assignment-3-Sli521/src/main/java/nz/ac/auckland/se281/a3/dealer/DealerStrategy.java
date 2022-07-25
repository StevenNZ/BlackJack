package nz.ac.auckland.se281.a3.dealer;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

public interface DealerStrategy {

	/**
	 * Takes in the hand of the dealer and decides an action based on the strategy
	 * 
	 * @param hand a class that has present information of current hand of the
	 *             dealer
	 * @return either hit or hold
	 */
	Action play(Hand hand);

}
