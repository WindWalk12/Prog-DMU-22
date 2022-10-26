package model;

import java.util.Random;

public class Yatzy {
	// Face values of the 5 dice.
	// 1 <= values[i] <= 6.
	private int[] values = new int[5];

	// Number of times the 5 dice have been thrown.
	// 0 <= throwCount <= 3.
	private int throwCount = 0;

	// Random number generator.
	private Random random = new Random();
	private int totalScore;
	private int sumLower;
	private int sumUpper;

	public Yatzy() {
		totalScore = 0;
		sumLower = 0;
		sumUpper = 0;
	}

	/**
	 * Returns the 5 face values of the dice.
	 */
	public int[] getValues() {
		return values;
	}

	/**
	 * Sets the 5 face values of the dice. Pre: values contains 5 face values in
	 * [1..6]. Note: This method is only meant to be used for test, and
	 * therefore has package visibility.
	 */
	public void setValues(int[] values) {
		this.values = values;
	}

	/**
	 * Returns the number of times the 5 dice has been thrown.
	 */
	public int getThrowCount() {
		return throwCount;
	}

	/**
	 * Resets the throw count.
	 */
	public void resetThrowCount() {
		throwCount = 0;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void addTotalScore(int totalScore) {
		this.totalScore += totalScore;
	}

	public int getSumLower() {
		return sumLower;
	}

	public void addSumLower(int sumLower) {
		this.sumLower += sumLower;
	}

	public int getSumUpper() {
		return sumUpper;
	}

	public void addSumUpper(int sumUpper) {
		this.sumUpper += sumUpper;
	}

	/**
	 * Rolls the 5 dice. Only roll dice that are not hold. Pre: holds contain 5
	 * boolean values.
	 */
	public void throwDice(boolean[] holds) {
		for (int i = 0; i < values.length; i++) {
			if (!holds[i]) {
				values[i] = random.nextInt(6) + 1;
			}
		}
		throwCount++;
	}

	// -------------------------------------------------------------------------

	/**
	 * Returns all results possible with the current face values. The order of
	 * the results is the same as on the score board. Note: This is an optional
	 * method. Comment this method out, if you don't want use it.
	 */
	public int[] getResults() {
		int[] results = new int[15];
		for (int i = 0; i <= 5; i++) {
			results[i] = this.sameValuePoints(i + 1);
		}
		results[6] = this.onePairPoints();
		results[7] = this.twoPairPoints();
		results[8] = this.threeSamePoints();
		results[9] = this.fourSamePoints();
		results[10] = this.fullHousePoints();
		results[11] = this.smallStraightPoints();
		results[12] = this.largeStraightPoints();
		results[13] = this.chancePoints();
		results[14] = this.yatzyPoints();

		return results;
	}

	// -------------------------------------------------------------------------

	// Returns an int[7] containing the frequency of face values.
	// Frequency at index v is the number of dice with the face value v, 1 <= v
	// <= 6.
	// Index 0 is not used.
	private int[] calcCounts() {
		int[] calcArray = new int[7];
		for (int i = 0; i < values.length; i++) {
			calcArray[values[i]]++;
		}
		return calcArray;
	}

	/**
	 * Returns same-value points for the given face value. Returns 0, if no dice
	 * has the given face value. Pre: 1 <= value <= 6;
	 */
	public int sameValuePoints(int value) {
		int[] tempArray = calcCounts();
		return tempArray[value] * value;
	}

	/**
	 * Returns points for one pair (for the face value giving highest points).
	 * Returns 0, if there aren't 2 dice with the same face value.
	 */
	public int onePairPoints() {
		int[] tempArray = calcCounts();
		int points = 0;
		for (int i = 1; i < tempArray.length; i++) {
			if (tempArray[i] >= 2) {
				points = 2 * i;
			}
		}
		return points;
	}

	/**
	 * Returns points for two pairs (for the 2 face values giving highest
	 * points). Returns 0, if there aren't 2 dice with one face value and 2 dice
	 * with a different face value.
	 */
	public int twoPairPoints() {
		int[] tempArray = calcCounts();
		int points = 0;
		int count = 0;
		for (int i = 1; i < tempArray.length; i++) {
			if (tempArray[i] >= 2) {
				points += 2 * i;
				count++;
			}
		}
		if (count < 2) {
			points = 0;
		}
		return points;
	}

	/**
	 * Returns points for 3 of a kind. Returns 0, if there aren't 3 dice with
	 * the same face value.
	 */
	public int threeSamePoints() {
		int[] tempArray = calcCounts();
		int points = 0;
		for (int i = 1; i < tempArray.length; i++) {
			if (tempArray[i] >= 3) {
				points = 3 * i;
			}
		}
		return points;
	}

	/**
	 * Returns points for 4 of a kind. Returns 0, if there aren't 4 dice with
	 * the same face value.
	 */
	public int fourSamePoints() {
		int[] tempArray = calcCounts();
		int points = 0;
		for (int i = 1; i < tempArray.length; i++) {
			if (tempArray[i] >= 4) {
				points = 4 * i;
			}
		}
		return points;
	}

	/**
	 * Returns points for full house. Returns 0, if there aren't 3 dice with one
	 * face value and 2 dice a different face value.
	 */
	public int fullHousePoints() {
		int[] tempArray = calcCounts();
		int points = 0;
		boolean threeSame = false, twoSame = false;
		for (int i = 1; i < tempArray.length; i++) {
			if (tempArray[i] == 3 && !threeSame) {
				points += 3 * i;
				threeSame = true;
			}
			if (tempArray[i] == 2 && !twoSame) {
				points += 2 * i;
				twoSame = true;
			}
		}
		if (!threeSame || !twoSame) {
			points = 0;
		}
		return points;
	}

	/**
	 * Returns points for small straight. Returns 0, if the dice are not showing
	 * 1,2,3,4,5.
	 */
	public int smallStraightPoints() {
		int[] tempArray = calcCounts();
		int points = 0;
		if (tempArray[1] >= 1 && tempArray[2] >= 1 && tempArray[3] >= 1 && tempArray[4] >= 1 && tempArray[5] >= 1) {
			points = 15;
		}
		return points;
	}

	/**
	 * Returns points for large straight. Returns 0, if the dice is not showing
	 * 2,3,4,5,6.
	 */
	public int largeStraightPoints() {
		int[] tempArray = calcCounts();
		int points = 0;
		if (tempArray[2] >= 1 && tempArray[3] >= 1 && tempArray[4] >= 1 && tempArray[5] >= 1 && tempArray[6] >= 1) {
			points = 20;
		}
		return points;
	}

	/**
	 * Returns points for chance.
	 */
	public int chancePoints() {
		int[] tempArray = calcCounts();
		int points = 0;
		for (int i = 1; i < tempArray.length; i++) {
			points += tempArray[i] * i;
		}
		return points;
	}

	/**
	 * Returns points for yatzy. Returns 0, if there aren't 5 dice with the same
	 * face value.
	 */
	public int yatzyPoints() {
		int[] tempArray = calcCounts();
		int points = 0;
		for (int i = 1; i < tempArray.length; i++) {
			if (tempArray[i] >= 5) {
				points = 50;
				break;
			}
		}
		return points;
	}

}
