package nz.ac.auckland.se281.a3;

import java.util.ArrayList;
import java.util.List;

import nz.ac.auckland.se281.a3.bot.Bot;
import nz.ac.auckland.se281.a3.bot.BotFactory;
import nz.ac.auckland.se281.a3.dealer.Dealer;
import nz.ac.auckland.se281.a3.dealer.DealerHighestBidStrategy;
import nz.ac.auckland.se281.a3.dealer.DealerTopWinnerStrategy;

/**
 * Unless it is specified in the JavaDoc, you cannot change any methods.
 * 
 * You can add new methods and/or new instance fields
 */
public class BlackJack {

	private List<Player> players;
	private Dealer dealer;
	private Deck deck;

	public BlackJack(Deck deck) {
		this.deck = deck;
		players = new ArrayList<>();
		players.add(new Human("Player1")); // add the Human player first.
	}

	/**
	 * Thi constructor is for testing reasons
	 * 
	 * @param cards
	 */
	protected BlackJack(Card... cards) {
		this(new Deck(cards));

	}

	public BlackJack() {
		this(new Deck());
	}

	public List<Player> getPlayers() {
		return players;
	}

	private String getBotStrategy() {
		System.out.println("Choose Bot strategy: random (R) - low risk (LR) - high risk (HR)");
		String result = Main.scanner.next();
		while (!result.equals("R") && !result.equals("LR") && !result.equals("HR") && !result.equals("A")) {
			System.out.println("please type \"R\", \"LR\",  \"HR\"");
			result = Main.scanner.next();
		}
		return result;
	}

	// do not change this method
	public void start() {
		initBots();
		initDealer();
		String res;
		int round = 0;
		do {
			round++;
			for (Participant p : players) {
				p.play(deck, round);
			}
			dealer.play(deck, round);
			printAndUpdateResults(round); // after each game print result and update scoreboard
			System.out.println("Do you want to play again?");
			res = Main.scanner.next();
			while (!res.equals("yes") && !res.equals("no")) {
				System.out.println("please type either \"yes\" or \"no\"");
				res = Main.scanner.next();
			}
		} while (res.equals("yes"));
		printGameStatistics(); // when the user terminates the game print the statistics
	}

	/**
	 * TODO This method initializes the Bots, you should change this method for
	 * Task1
	 */
	protected void initBots() {
		Bot bot1 = new Bot("Bot1");
		Bot bot2 = new Bot("Bot2");
		String botStrategyString = getBotStrategy();

		// create and set Bots strategy here
		bot1.setStrategy(BotFactory.createBot(botStrategyString));
		bot2.setStrategy(BotFactory.createBot(botStrategyString));

		players.add(bot1);
		players.add(bot2);
	}

	/**
	 * TODO This method initializes the Dealer, you should change this method for
	 * Task2
	 */
	protected void initDealer() {
		// set the initial strategy using the Strategy pattern
		dealer = new Dealer("Dealer");
		dealer.setStrategy(new DealerHighestBidStrategy(this));
	}

	/**
	 * TODO This method prints and updates the results (wins and losses) you should
	 * change this method for Task 2 and Task 3
	 */
	protected void printAndUpdateResults(int round) {
		getResults();

		for (Player player : players) {
			System.out.println("Round " + round + ": " + player.getName() + player.getResult(player.getWin())
					+ player.getHand().getBet() + " chips");
		}
	}

	/**
	 * TODO This method should print the statistic of the game when it ends
	 */
	protected void printGameStatistics() {

		for (Player player : players) {
			System.out.println(player.getName() + " won " + player.getNumberWins() + " times and lost "
					+ player.getNumberLosts() + " times");
		}
	}

	/**
	 * returns the player with the highest bid by looping through every player in
	 * this instance of black jack game
	 * 
	 * @return a Player that bid the highest
	 */
	public Player getHighestBidTarget() {

		Player highestBid = players.get(0);

		for (int i = 1; i < players.size(); i++) { // looping for highest bidder
			if (players.get(i).getHand().getBet() > highestBid.getHand().getBet()) {
				highestBid = players.get(i);
			}
		}
		return highestBid;
	}

	/**
	 * returns the player with the higher net wins by looping through every player
	 * in this instance of black jack game
	 * 
	 * @return a Player that has the highest net wins
	 */
	public Player getTopWinnerTarget() {

		Player highestNetWins = players.get(0);

		for (int i = 1; i < players.size(); i++) { // looping for top winner
			if (players.get(i).getNetWins() > highestNetWins.getNetWins()) {
				highestNetWins = players.get(i);
			}
		}
		return highestNetWins;
	}

	/**
	 * gets the round results by checking the hands of the players and the dealers
	 * and then updating it to the player's instance fields as well as checking if
	 * dealer strategy changes
	 */
	private void getResults() {

		Player topWinner = players.get(0);

		for (Player player : players) {

			if (player.getHand().isBust()) { // player busted
				player.setResult(false);
			} else if (player.getHand().isBlackJack() && dealer.getHand().isBlackJack()) { // both dealer/player busted
				player.setResult(false);
			} else if (player.getHand().isBlackJack()) { // player blackjack
				player.setResult(true);
			} else if (player.getHand().getScore() <= dealer.getHand().getScore() && !dealer.getHand().isBust()) {
				player.setResult(false); // checks if dealer has higher score than player without being busted
			} else {
				player.setResult(true);
			}
			if (player.getNetWins() > topWinner.getNetWins()) {
				topWinner = player;
			}
		}
		if (topWinner.getNetWins() >= 2) { // checks if strategy changes
			dealer.setStrategy(new DealerTopWinnerStrategy(this));
		} else {
			dealer.setStrategy(new DealerHighestBidStrategy(this));
		}
	}
}
