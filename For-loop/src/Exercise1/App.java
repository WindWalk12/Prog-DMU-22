package Exercise1;

public class App {

    public void printUnevenNumbers(int number) {
        for (int i = 1; i <= number; i++) {
            if (i%2 != 0) {
                System.out.println(i);
            }
        }
    }

    public void printEveryThirdNumber(int number) {
        for (int i = number; i > 0; i--) {
            if (i%3 == 0) {
                System.out.println(i);
            }
        }
    }
}
