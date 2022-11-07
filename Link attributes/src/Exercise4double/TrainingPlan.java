package Exercise4double;

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

	public Swimmer createSwimmer(String name, int yearGroup, ArrayList<Double> lapTimes, String club, TrainingPlan tPlan) {
		Swimmer s = new Swimmer(name, yearGroup, lapTimes, club, tPlan);
		swimmers.add(s);
		return s;
	}

	public void addSwimmer(Swimmer s) {
		if (!swimmers.contains(s)) {
			swimmers.add(s);
			s.addTPlan(this);
		}
	}

	public void removeSwimmer(String name, String club) {
		for (Swimmer s :swimmers) {
			if (s.getName().equals(name) && s.getClub().equals(club)) {
				swimmers.remove(s);
				break;
			}
		}
	}

	public ArrayList<Swimmer> getSwimmers() {
		return new ArrayList<>(swimmers);
	}

	public Swimmer getSwimmer(String name, String club) {
		for (Swimmer s :swimmers) {
			if (s.getName().equals(name) && s.getClub().equals(club)) {
				return s;
			}
		}
		return null;
	}
	
}
