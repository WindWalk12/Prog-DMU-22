package StudentGroupGen_Arraylist;

import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;

public class StudentNames {
    ArrayList<String> names = new ArrayList<String>();
    private int numberOfGroups;

    public StudentNames(int numberOfGroups) {
        this.numberOfGroups = numberOfGroups;
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
        names.addAll(Arrays.asList(mNames));
        Collections.shuffle(names);
        int sizeOfGroups = (int)Math.floor(names.size()/(double)numberOfGroups);
        int rest = ((int)Math.floor(names.size()%(double)numberOfGroups));
        int k = 0;
        for (int i = 0; i < numberOfGroups; i++) {
            System.out.print("Gruppe " + (i + 1) + ": ");
            for (int j = 0; j < sizeOfGroups; j++) {
                if (i >= numberOfGroups - rest && j == sizeOfGroups - 1) {
                    System.out.print(" " + names.get(k) + ", ");
                    k++;
                }
                System.out.print(" " + names.get(k) + ", ");
                k++;

            }
            System.out.println();
        }
    }
}
