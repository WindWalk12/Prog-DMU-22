package E7_22_Arraylist;

import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class AsteriskGen {
    private final int maxAsterisks = 40;
    private Scanner scan;
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    ArrayList<String> captions = new ArrayList<String>();

    public AsteriskGen() {
        scan = new Scanner(System.in);
        System.out.print("Number for how many lines: ");
        int size = scan.nextInt();
        System.out.println("Write " + size + " numbers");
        for (int i = 0; i < size; i++) {
            int number = scan.nextInt();
            numbers.add(number);
        }
        System.out.println();
        System.out.println("Write " + size + " Strings");
        for (int i = 0; i < size; i++) {
            String caption = scan.next();
            captions.add(caption);
        }
        System.out.println();
    }

    public void Gen() {
        int highestNumber = Collections.max(numbers);
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + " ");
            for (int j = 0; j < Math.floor(maxAsterisks / (highestNumber/(float)numbers.get(i))); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
