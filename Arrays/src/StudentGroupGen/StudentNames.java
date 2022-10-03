package StudentGroupGen;

import java.util.Random;

public class StudentNames {
    private String groups[][];

    public StudentNames(int numberOfGroups) {
        groups = new String[numberOfGroups][(int)Math.ceil(mNames.length / (float)numberOfGroups)];
    }

    private static String[] mNames = {"Adam", "Amin", "Andreas", "Anton", "Christian Rosendal",
            "Christian Skræddergaard", "Elias", "Jacob Gram",
            "Jakob Noermark", "Jeppe", "John", "Kamilla", "Kasper",
            "Lasse Calvillo", "Lasse Kirkegaard", "Louise",
            "Lucas", "Lucas Holm", "Mads Ilsø", "Mads Overgaard",
            "Maksym", "Mathias", "Mikkel Hess", "Mikkel Lindhøj",
            "Niclas", "Olga", "Oliver Lochert", "Oliver Rosenquist",
            "Peter", "Rasmus", "Silas", "Simon", "Tayylp", "Tobias"};

    public static String[] getNames() {
        return mNames;
    }

    public void genGroups() {
        shuffleArray();
        int k = 0;
        for (int i = 0; i < groups[0].length; i++) {
            for (int j = 0; j < groups.length; j++) {
                if (k < mNames.length) {
                    groups[j][i] = mNames[k];
                    k++;
                }
            }
        }
        printGroups();
    }

    public void shuffleArray() {
        Random rand = new Random();
        for (int i = 0; i < mNames.length; i++) {
            int randomIndex = rand.nextInt(mNames.length);
            String temp = mNames[randomIndex];
            mNames[randomIndex] = mNames[i];
            mNames[i] = temp;
        }
    }

    public void printGroups() {
        for (int i = 0; i < groups.length; i++) {
            System.out.print("Gruppe " + (i + 1) + ": ");
            for (int j = 0; j < groups[i].length; j++) {
                if (groups[i][j] != null) {
                    System.out.print(" " + groups[i][j] + ", ");
                }
            }
            System.out.println();
        }
    }
}
