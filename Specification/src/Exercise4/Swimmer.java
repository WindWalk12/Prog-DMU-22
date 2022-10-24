package Exercise4;

import java.time.LocalDate;
import java.util.ArrayList;

public class Swimmer {
    private String name;
    private String club;
    private LocalDate birthday;
    private ArrayList<Double> times;

    public Swimmer(String name, String club, LocalDate birthday, ArrayList<Double> times) {
        this.name = name;
        this.club = club;
        this.birthday = birthday;
        this.times = times;
    }

    public String getName() {
        return name;
    }

    public String getClub() {
        return club;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public double bestTime() {
        double bestTime = 0;
        for (Double d :times) {
            if (d > bestTime) {
                bestTime = d;
            }
        }
        return bestTime;
    }

    public double averageOfTime() {
        double avgTimes = 0;
        for (Double d :times) {
            avgTimes += d;
        }
        return avgTimes / times.size();
    }

    public double averageWithoutWorstTime() {
        double worstTime = 0;
        double avgTimesWithoutWorst = 0;
        for (Double d :times) {
            if (d > worstTime) {
                worstTime = d;
            }
            avgTimesWithoutWorst += d;
        }
        return (avgTimesWithoutWorst - worstTime) / (times.size() - 1);
    }
}
