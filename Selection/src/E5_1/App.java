package E5_1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Write a number: ");
        int inputInt = myScanner.nextInt();

        if (inputInt > 0) {
            System.out.println("Number is positive");
        } else if (inputInt == 0) {
            System.out.println("Number is zero");
        } else {
            System.out.println("Number is negative");
        }
    }
}
