package Exercise5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args){
        try (Scanner sc = new Scanner(System.in);) {
            File file = new File("Exceptions/src/Exercise5/output.txt");
            PrintWriter pw = new PrintWriter(file);
            int loop = 0;
            while (loop != -1) {
                int number = sc.nextInt();
                if (number == -1) {
                    loop = number;
                    pw.close();
                }
                pw.println(number);
                pw.flush();
            }
        }  catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (InputMismatchException e) {
            System.out.println("Write only numbers");
        }
    }
}
