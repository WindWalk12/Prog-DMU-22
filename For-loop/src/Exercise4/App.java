package Exercise4;

public class App {
    public void starsA(int number) {
        int minRows = 1;
        for (int rows = number; minRows <= rows; rows--) {
            for (int j = 1; j <= rows; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


    public void starsB(int number) {
        for (int i = 1; i <= number; i++) {
            for (int j = 10; j > i; j--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void starsC(int number) {
        int minRows = 1;
        for (int rows = number; minRows <= rows; rows--) {
            for (int j = 10; j > rows; j--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= rows; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void starsD(int number) {
        for (int i = 0; i < number; i++) {
            if (i < Math.ceil(((double)number/2))) {
                for (int j = (int)Math.floor(((double)number/2)); j > i; j--) {
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
                for (int j = (int)Math.ceil(((double)number/2)) - 1; j < i; j++) {
                    System.out.print(" ");
                }
                for (int j = number; j > i; j--) {
                    if (j == number) {
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
