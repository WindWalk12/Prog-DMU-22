import java.util.Arrays;

public class TheaterFloor {
    private int[][] seats = {
            {10,10,10,10,10,10,10,10,10,10},
            {10,10,10,10,10,10,10,10,10,10},
            {10,10,10,10,10,10,10,10,10,10},
            {10,10,20,20,20,20,20,20,10,10},
            {10,10,20,20,20,20,20,20,10,10},
            {10,10,20,20,20,20,20,20,10,10},
            {20,20,30,30,40,40,30,30,20,20},
            {20,20,30,40,50,50,40,30,20,20},
            {30,40,50,50,50,50,50,50,40,30}

    };

    public boolean buySeat(int price){
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j] == price) {
                    seats[i][j] = -1;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean buySeat(int row, int seat){
        if (seats[row - 1][seat - 1] == -1) {
            return false;
        } else {
            seats[row - 1][seat - 1] = -1;
            return true;
        }
    }

    public void print() {
        System.out.print("   Seat : ");
        for (int i = 0; i < seats[0].length; i++) {
            System.out.print((i + 1) + "   ");
        }
        System.out.println();
        System.out.print("          --------------------------------------");
        for (int i = 0; i < seats.length; i++) {
            System.out.println();
            System.out.print("Row   " + (i + 1) + " : ");
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j] > -1) {
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
