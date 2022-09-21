package Exercise1;

public class App {
    public void printUnevenNumbers(int n) {
        for (int i = 1; i <= n; i++) {
            if (i%2 != 0) {
                System.out.println(i);
            }
        }
    }

    public void printEveryThirdNumber(int n) {
        for (int i = n; i > 0; i--) {
            if (i%3 == 0) {
                System.out.println(i);
            }
        }
    }
}
