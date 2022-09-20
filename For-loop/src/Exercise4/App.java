package Exercise4;

public class App {

    public App() {

    }

    public void starsA() {
        int minRows = 1;
        for (int rows = 10; minRows <= rows; rows--) {
            for (int j = 1; j <= rows; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


    public void starsB() {
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
    }

    public void starsC() {
        int minRows = 1;
        for (int rows = 10; minRows <= rows; rows--) {
            for (int j = 10; j > rows; j--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= rows; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void starsD() {
        for (int i = 0; i < 10; i++) {
            if (i < 5) {
                for (int j = 4; j > i; j--) {
                    System.out.print(" ");
                }
                for (int j = 0; j <= i; j++) {
                    if (j == 0) {
                        System.out.print("*");
                    } else {
                        for (int k = 0; k < 2; k++) {
                            System.out.print("*");
                        }
                    }
                }
            } else {
                for (int j = 5; j < i; j++) {
                    System.out.print(" ");
                }
                for (int j = 10; j > i; j--) {
                    if (j == 10) {
                        System.out.print("*");
                    } else {
                        for (int k = 0; k < 2; k++) {
                            System.out.print("*");
                        }
                    }
                }
            }
            System.out.println();
        }
    }
}
