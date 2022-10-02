package E7_19;

import java.util.Scanner;

public class AsteriskGen {
    private int[] inputs;
    private final int maxAsterisks = 40;
    private Scanner scan;

    public AsteriskGen() {
        scan = new Scanner(System.in);
        System.out.print("Number for size of array: ");
        int size = scan.nextInt();
        inputs = new int[size];
        System.out.println("Write " + size + " numbers");
        for (int i = 0; i < size; i++) {
            int number = scan.nextInt();
            inputs[i] = number;
        }
        System.out.println();
    }

    public void Gen() {
        int highestNumber = 0;
        for (int i = 0; i < inputs.length; i++) {
            if (inputs[i] > highestNumber) {
                highestNumber = inputs[i];
            }
        }
        for (int i = 0; i < inputs.length; i++) {
            for (int j = 0; j < Math.floor(maxAsterisks / (highestNumber/(float)inputs[i])); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
