package Exercise4;

public class App {
    public void starsA(int n) {
        int minRows = 1;
        for (int rows = n; minRows <= rows; rows--) {
            for (int j = 1; j <= rows; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


    public void starsB(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 10; j > i; j--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void starsC(int n) {
        int minRows = 1;
        for (int rows = n; minRows <= rows; rows--) {
            for (int j = 10; j > rows; j--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= rows; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void starsD(int n) {
        for (int i = 0; i < n; i++) {
            if (i < Math.ceil(((double)n/2))) {
                for (int j = (int)Math.floor(((double)n/2)) - 1; j > i; j--) {
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
                for (int j = (int)Math.ceil(((double)n/2)); j < i; j++) {
                    System.out.print(" ");
                }
                for (int j = n; j > i; j--) {
                    if (j == n) {
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
