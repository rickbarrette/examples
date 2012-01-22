/**
 * @author ricky barrette
 * @author Twenty Codes, LLC
 */
import java.util.Random;

/**
 * This class will be used to has a helper class for the dice roller application
 * @author ricky barrette
 */
public class DiceRoller {

	/**
	 * rolls the dice
	 * @param rolls
	 * @param sides
	 * @return
	 * @author ricky barrette
	 */
	protected static String rollDice(int rolls, int sides) {
		Random gen = new Random();
		int tally = 0, number;
		/*
		 * now we process the user's input and generate results for them.
		 */
		for (int i = 0; i < rolls; i++) {
			number = gen.nextInt(sides) +1;
			tally = tally + number;
		}
		return "You rolled: " + tally;
	}

}