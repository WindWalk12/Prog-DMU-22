import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class TheaterFloorApp {
    private static Scanner scan;

    public static void main(String[] args) {
        scan = new Scanner(System.in);
        TheaterFloor t = new TheaterFloor();
        t.populate();
        System.out.println("Do you want to buy from a price or by seat? price : seat");
        String answer = scan.next();
        if (answer.equalsIgnoreCase("price")) {
            System.out.println("At which price? It ranges from 10..20..30..90");
            int price = scan.nextInt();
            if (price >= 10 && price <= 90 && price % 10 == 0) {
                if (t.buySeat(price)) {
                    System.out.println("Seat is bought");
                } else {
                    System.out.println("We are all out of seats at the price of " + price);
                }
            } else {
                System.out.println("We don't have that price here");
            }
        } else if (answer.equalsIgnoreCase("seat")) {
            System.out.println("At which seat? It ranges from row 1-9 and col 1-10");
            System.out.print("Row: ");
            int row = scan.nextInt();
            System.out.println();
            System.out.print("Col: ");
            int col = scan.nextInt();
            if (row >= 1 && row <= 9 && col >= 1 && col <= 10) {
                if (t.buySeat(row,col)) {
                    System.out.println("Seat is bought");
                } else {
                    System.out.println("That seat is already bought");
                }
            } else {
                System.out.println("That seat is out of our range");
            }
        }
        t.print();
    }
}
