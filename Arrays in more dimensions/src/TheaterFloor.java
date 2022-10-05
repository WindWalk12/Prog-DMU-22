import java.util.Arrays;

public class TheaterFloor {
    private int[][] seats = new int[9][10];

    public void populate() {
        for (int i = 0; i < seats.length; i++) {
            Arrays.fill(seats[i], 10 * (i + 1));
        }
    }

    public boolean buySeat(int price){
        for (int j = 0; j < seats[(price/10) - 1].length; j++) {
            if (seats[(price/10) - 1][j] != 0) {
                seats[(price/10) - 1][j] = 0;
                return true;
            }
        }
        return false;
    }

    public boolean buySeat(int row, int seat){
        if (seats[row - 1][seat - 1] == 0) {
            return false;
        } else {
            seats[row - 1][seat - 1] = 0;
            return true;
        }
    }

    public void print() {
        System.out.print("   Sæde : ");
        for (int i = 0; i < seats[0].length; i++) {
            System.out.print((i + 1) + "   ");
        }
        System.out.println();
        System.out.print("          --------------------------------------");
        for (int i = 0; i < seats.length; i++) {
            System.out.println();
            System.out.print("Række " + (i + 1) + " : ");
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j] > 0) {
                    System.out.print(seats[i][j]);
                    if (j < seats[i].length - 1) {
                        System.out.print(", ");
                    }
                } else {
                    System.out.print( "--, ");
                }
            }
        }
        System.out.println();
    }
}
