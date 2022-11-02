package Exercise4;

import java.util.ArrayList;

/**
 * Models a training plan for a Swimmer
 */
public class TrainingPlan {
	private char level;
	private int weeklyWaterHours;
	private int weeklyStrengthHours;
	private ArrayList<Swimmer> swimmers;
	
	public TrainingPlan(char level, int weeklyWaterHours, int weeklyStrengthHours) {
		this.level = level;
		this.weeklyWaterHours = weeklyWaterHours;
		this.weeklyStrengthHours = weeklyStrengthHours;
		this.swimmers = new ArrayList<>();
	}
	
	public char getLevel() {
		return level;
	}
	
	public void setLevel(char niveau) {
		this.level = niveau;
	}
	
	public int getWeeklyStrengthHours() {
		return weeklyStrengthHours;
	}
	
	public void setWeeklyStrengthHours(int weeklyStrengthHours) {
		this.weeklyStrengthHours = weeklyStrengthHours;
	}
	
	public int getWeeklyWaterHours() {
		return weeklyWaterHours;
	}
	
	public void setWeeklyWaterHours(int weeklyWaterHours) {
		this.weeklyWaterHours = weeklyWaterHours;
	}

	public Swimmer createSwimmer(String name, int yearGroup, ArrayList<Double> lapTimes, String club) {
		Swimmer s = new Swimmer(name, yearGroup, lapTimes, club);
		swimmers.add(s);
		return s;
	}

	public void addSwimmer(Swimmer s) {
		if (!swimmers.contains(s)) {
			swimmers.add(s);
		}
	}

	public void removeSwimmer(Swimmer s) {
			swimmers.remove(s);
	}

	public ArrayList<Swimmer> getSwimmers() {
		return new ArrayList<>(swimmers);
	}
	
}
