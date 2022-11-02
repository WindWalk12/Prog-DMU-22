package Exercise4double;

import java.util.ArrayList;

public class SwimmerApp {
    
    public static void main(String[] args) {
        TrainingPlan t1 = new TrainingPlan('A', 22, 5);
        TrainingPlan t2 = new TrainingPlan('B', 50, 1);

        ArrayList<Double> lapTimes = new ArrayList<>();
        lapTimes.add(1.02);
        lapTimes.add(1.01);
        lapTimes.add(0.99);
        lapTimes.add(0.98);
        lapTimes.add(1.02);
        lapTimes.add(1.04);
        lapTimes.add(0.99);
        t1.createSwimmer("Jan", 1994, lapTimes, "AGF", t1);

        lapTimes = new ArrayList<>();
        lapTimes.add(1.05);
        lapTimes.add(1.01);
        lapTimes.add(1.04);
        lapTimes.add(1.06);
        lapTimes.add(1.08);
        lapTimes.add(1.04);
        lapTimes.add(1.02);
        t1.createSwimmer("Bo", 1995, lapTimes, "Lyseng", t1);

        lapTimes = new ArrayList<>();
        lapTimes.add(1.03);
        lapTimes.add(1.01);
        lapTimes.add(1.02);
        lapTimes.add(1.05);
        lapTimes.add(1.03);
        lapTimes.add(1.06);
        lapTimes.add(1.03);
        t2.createSwimmer("Mikkel", 1993, lapTimes, "AIA-Tranbjerg", t2);

        System.out.println("Træningsplan A");
        for (Swimmer s: t1.getSwimmers()) {
            System.out.println(s.getName() + " er medlem af " + s.getClub() + " og er medlem af træningsplanen " + s.gettPlan().getLevel());
        }
        System.out.println();

        System.out.println("Træningsplan B");
        for (Swimmer s: t2.getSwimmers()) {
            System.out.println(s.getName() + " er medlem af " + s.getClub() + " og er medlem af træningsplanen " + s.gettPlan().getLevel());
        }
        System.out.println();

        t2.getSwimmer("Mikkel", "AIA-Tranbjerg").setTPlan(t1);

        System.out.println("Træningsplan A");
        for (Swimmer s: t1.getSwimmers()) {
            System.out.println(s.getName() + " er medlem af " + s.getClub() + " og er medlem af træningsplanen " + s.gettPlan().getLevel());
        }
        System.out.println();

        t2.addSwimmer(t1.getSwimmer("Jan", "AGF"));

        System.out.println("Træningsplan A");
        for (Swimmer s: t1.getSwimmers()) {
            System.out.println(s.getName() + " er medlem af " + s.getClub() + " og er medlem af træningsplanen " + s.gettPlan().getLevel());
        }
        System.out.println();

        System.out.println("Træningsplan B");
        for (Swimmer s: t2.getSwimmers()) {
            System.out.println(s.getName() + " er medlem af " + s.getClub() + " og er medlem af træningsplanen " + s.gettPlan().getLevel());
        }


        /*t1.removeSwimmer("Mikkel", "AIA-Tranbjerg");

        System.out.println();
        for (Swimmer s: t1.getSwimmers()) {
            System.out.println(s.getName() + " er medlem af " + s.getClub() + " og er medlem af træningsplanen");
        }*/
    }
    
}
