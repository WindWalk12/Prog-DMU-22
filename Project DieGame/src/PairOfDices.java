import java.util.Scanner;

/**
 * This class models one pair of dices.
 *
 */
public class PairOfDices {
    /**
     * The first die in the pair.
     */
	private Die die1;
	/**
	 * The second die in the pair.
	 */
	private Die die2;

	private Scanner scan;

	private int countRolls = 0;

	private int countOnes = 0;

	private int countTwos = 0;

	private int countThrees = 0;

	private int countFours = 0;

	private int countFives = 0;

	private int countSixes = 0;

	private int countPair = 0;

	private int highestThrow = 0;

	/**
	 * Constructor for objects of class PairOfDices
	 */
	// TODO: put the constructor here!

	public PairOfDices() {
		die1 = new Die();
		die2 = new Die();
		scan = new Scanner(System.in);
		
	}

	public PairOfDices(int sides) {
		die1 = new Die(sides);
		die2 = new Die(sides);
		scan = new Scanner(System.in);

	}

	public void rollBothDices() {
		die1.roll();
		die2.roll();
		countRolls++;
		if (die1.getFaceValue() == 1) {
			countOnes++;
		}
		if (die2.getFaceValue() == 1) {
			countOnes++;
		}
		if (die1.getFaceValue() == 2) {
			countTwos++;
		}
		if (die2.getFaceValue() == 2) {
			countTwos++;
		}
		if (die1.getFaceValue() == 3) {
			countThrees++;
		}
		if (die2.getFaceValue() == 3) {
			countThrees++;
		}
		if (die1.getFaceValue() == 4) {
			countFours++;
		}
		if (die2.getFaceValue() == 4) {
			countFours++;
		}
		if (die1.getFaceValue() == 5) {
			countFives++;
		}
		if (die2.getFaceValue() == 5) {
			countFives++;
		}
		if (die1.getFaceValue() == 6) {
			countSixes++;
		}
		if (die2.getFaceValue() == 6) {
			countSixes++;
		}
		if (die1.getFaceValue() == die2.getFaceValue()) {
			countPair++;
		}
		if (sumOfDices() > highestThrow) {
			highestThrow = sumOfDices();
		}
	}

	public int sumOfDices() {
		return die1.getFaceValue() + die2.getFaceValue();
	}

	public void resetPairOfDice() {
		this.countRolls = 0;
		this.countOnes = 0;
		this.countTwos = 0;
		this.countThrees = 0;
		this.countFours = 0;
		this.countFives = 0;
		this.countSixes = 0;
		this.countPair = 0;
		this.highestThrow = 0;
	}

	public int getCountRolls() {
		return countRolls;
	}

	public int getCountOnes() {
		return countOnes;
	}

	public int getCountTwos() {
		return countTwos;
	}

	public int getCountFours() {
		return countFours;
	}

	public int getCountFives() {
		return countFives;
	}

	public int getCountSixes() {
		return countSixes;
	}

	public int getCountPair() {
		return countPair;
	}

	private void gameOver() {
		System.out.println("Tak for spillet, nedenunder finder du stats");
		System.out.println();
		System.out.println("Du har slået et par " + this.countPair + " gange");
		System.out.println("Det højeste der er slået er: " + this.highestThrow);
		System.out.println("Du har slået 1'ere " + this.countOnes + " gange");
		System.out.println("Du har slået 2'ere " + this.countTwos + " gange");
		System.out.println("Du har slået 3'ere " + this.countThrees + " gange");
		System.out.println("Du har slået 4'ere " + this.countFours + " gange");
		System.out.println("Du har slået 5'ere " + this.countFives + " gange");
		System.out.println("Du har slået 6'ere " + this.countSixes + " gange");
		scan.close();
	}

	private void takeTurn() {
		rollBothDices();
		System.out.println("Du har slået: " + sumOfDices());
		System.out.println();
	}

	public void startGame() {
		System.out.println("Velkommen til spillet PairOfDices");
		boolean finished = false;

		while (!finished) {
			System.out.print("Vil du kaste en terning? Angiv Ja eller Nej: ");
			String goOn = scan.nextLine();
			if (goOn.equalsIgnoreCase("Nej")) {
				finished = true;
			} else {
				takeTurn();
			}
		}
		gameOver();
		resetPairOfDice();
	}
}
