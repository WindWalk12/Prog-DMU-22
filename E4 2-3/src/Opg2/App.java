package Opg2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Write a number: ");
        double inputDouble = myScanner.nextDouble();

        System.out.println("Square of input number: " + (inputDouble*inputDouble));
        System.out.println("Cube of input number: " + (inputDouble*inputDouble*inputDouble));
        System.out.println("Fourth power of input number: " + (Math.pow(inputDouble, 4)));
    }
}
