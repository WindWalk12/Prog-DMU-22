package Exercise3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args){
        File file = new File("Exceptions/src/Exercise3/input.txt");
        ArrayList<Integer> integers = new ArrayList<>();
        try (Scanner sc = new Scanner(file);) {

            while (sc.hasNext()) {
                int res = sc.nextInt();
                integers.add(res);
            }
        }  catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (InputMismatchException e) {
            System.out.println("Write only numbers");
        }
        Collections.reverse(integers);
        System.out.println(integers);
    }
}
