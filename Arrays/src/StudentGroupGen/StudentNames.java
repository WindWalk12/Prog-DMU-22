package StudentGroupGen;

public class StudentNames {
    public int groupSize;
    private String groups[][];
    private int count = 0;

    public StudentNames(int groupSize) {
        this.groupSize = groupSize;
        groups = new String[groupSize][(int)Math.ceil(mNames.length/groupSize)];
    }

    private static String[] mNames = {"Adam", "Amin", "Andreas", "Anton", "Christian Rosendal",
                       "Christian Skræddergaard", "Elias", "Jacob Gram",
                       "Jakob Noermark", "Jeppe", "John", "Kamilla", "Kasper",
                       "Lasse Calvillo", "Lasse Kirkegaard", "Louise",
                       "Lucas", "Lucas Holm", "Mads Ilsø", "Mads Overgaard",
                       "Maksym", "Mathias", "Mikkel Hess", "Mikkel Lindhøj",
                       "Niclas", "Olga", "Oliver Lochert", "Oliver Rosenquist",
                       "Peter", "Rasmus", "Silas", "Simon", "Tayylp", "Tobias"};

    public static String[] getNames() { return mNames; }

    public void genGroups() {
        for (int i = 0; i < mNames.length; i++) {
            groups[(int)Math.floor(Math.random()*5)][(int)Math.floor(Math.random()*(mNames.length/groupSize))] = mNames[(int)Math.floor(Math.random()*33)];
        }
    }

    public void genGroups2() {
        findNotNull();
        while (count > 0) {
            for (int i = 0; i < groups.length; i++) {
                for (int j = 0; j < groups[i].length; j++) {
                    int element = (int) Math.floor(Math.random() * 33);
                    if (mNames[element] != null) {
                        groups[i][j] = mNames[element];
                        mNames[element] = null;
                    }
                    findNotNull();
                }
            }
        }
    }

    public int findNotNull(){
        this.count = 0;
        for (int i = 0; i < mNames.length; i++) {
            if (mNames[i] != null) {
                this.count++;
            }
        }
        return this.count;
    }
    
    public void printGroups() {
        for (int i = 0; i < groups.length; i++) {
            System.out.print("Gruppe " + (i + 1) + ": ");
            for (int j = 0; j < groups[i].length; j++) {
                System.out.print(" " + groups[i][j] + ", ");
            }
            System.out.println();
        }
    }

}
