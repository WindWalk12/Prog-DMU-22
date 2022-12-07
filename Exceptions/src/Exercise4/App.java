package Exercise4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class App {
    public static void main(String[] args){
        File file = new File("Exceptions/src/Exercise4/output.txt");
        try (PrintWriter pw = new PrintWriter(file);) {
            for (int i = 1; i < 100; i++) {
                pw.println(i);
                i++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
