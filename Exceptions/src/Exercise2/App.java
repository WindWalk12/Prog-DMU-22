package Exercise2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        File file = new File("Exceptions/src/Exercise2/input.txt");
        try(Scanner sc = new Scanner(file);) {
            while (sc.hasNext()) {
                int res = sc.nextInt();
                System.out.println(res * 2);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (InputMismatchException e) {
            System.out.println("Write only numbers");
        }
    }
}
