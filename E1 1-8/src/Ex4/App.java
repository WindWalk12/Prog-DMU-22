package Ex4;

public class App {
    public static void main(String[] args) {
        double balance = 1000;
        for (int i = 0; i < 3; i++) {
            balance *= 1.05;
            System.out.println(balance);
        }
    }
}
