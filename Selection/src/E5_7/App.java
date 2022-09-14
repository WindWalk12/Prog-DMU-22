package E5_7;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Write a number: ");
        int inputDouble = myScanner.nextInt();

        System.out.print("Write another number: ");
        int inputDouble2 = myScanner.nextInt();

        System.out.print("Write a third number: ");
        int inputDouble3 = myScanner.nextInt();

        if (inputDouble < inputDouble2 && inputDouble2 < inputDouble3) {
            System.out.println("Numbers are increasing: " + inputDouble + inputDouble2 + inputDouble3);
        } else if (inputDouble > inputDouble2 && inputDouble2 > inputDouble3) {
            System.out.println("Numbers are decreasing: " + inputDouble3 + inputDouble2 + inputDouble);
        } else {
            System.out.println("Numbers are neither increasing or decreasing");
        }
    }
}
