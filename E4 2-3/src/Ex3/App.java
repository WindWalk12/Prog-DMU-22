package Ex3;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Write a number: ");
        double inputDouble = myScanner.nextDouble();
        System.out.print("Write another number: ");
        double inputDouble2 = myScanner.nextDouble();

        System.out.println("Sum of input numbers: " + (inputDouble+inputDouble2));
        System.out.println("Difference of input numbers: " + (inputDouble-inputDouble2));
        System.out.println("Product of input numbers: " + (inputDouble*inputDouble2));
        System.out.println("Average of input numbers: " + ((inputDouble+inputDouble2)/2));
        System.out.println("Distance of input numbers: " + (Math.abs(inputDouble-inputDouble2)));
        System.out.println("Maximum of input numbers: " + (Math.max(inputDouble,inputDouble2)));
        System.out.println("Minimum of input numbers: " + (Math.min(inputDouble,inputDouble2)));
    }
}
