package nz.ac.auckland.se281.a3.bot;

public class BotFactory {

	/**
	 * A factory class which returns a new botStrategy instance depending on the
	 * user's choice of strategy type
	 * 
	 * @param type the type of botStrategy chosen by user
	 * @return a new botStrategy instance
	 */
	public static BotStrategy createBot(String type) { // A factory design pattern for strategy type
		switch (type) {
		case "R":
			return new RandomStrategy();
		case "LR":
			return new LRStrategy();
		case "HR":
			return new HRStrategy();
		default:
			return null;
		}
	}

}
