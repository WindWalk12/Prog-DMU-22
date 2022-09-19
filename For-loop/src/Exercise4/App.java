package Exercise4;

public class App {
    public static void main(String[] args) {
        System.out.println("a)");
        int minRows = 1;
        for (int rows = 10; minRows <= rows ; rows--) {
            for (int j = 1; j <= rows ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("b)");

        int maxRows = 10;
        for (int i = 1; i <= maxRows; i++) {
            for (int j = 10; j > i; j--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("c)");

        for (int rows = 10; minRows <= rows ; rows--) {
            for (int j = 10; j > rows; j--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= rows ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("d)");

        maxRows = 5;
        for (int i = 1; i <= maxRows; i++) {
            for (int j = 4; j >= i; j--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                if (j == 1) {
                    System.out.print("*");
                } else {
                    System.out.print("**");
                }
            }
            System.out.println();
        }
        for (int rows = 5; minRows <= rows ; rows--) {
            for (int j = 5; j > rows; j--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= rows ; j++) {
                if (j == 1) {
                    System.out.print("*");
                } else {
                    System.out.print("**");
                }
            }
            System.out.println();
        }
    }
}
