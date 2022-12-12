package Exercise2;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        int[] t1 = {2, 4, 6, 8, 10, 12, 14};
        int[] t2 = {1, 2, 4, 5, 6, 9, 12, 17};

        System.out.println(Arrays.toString(difference(t1, t2)));

    }

    public static int[] difference(int[] a1, int [] a2) {
        int[] result = new int[Math.min(a1.length, a2.length)];
        int i = 0;
        int resI = 0;
        while (a1.length > i && a2.length > i) {
            boolean matchFound = false;
            for (int k = 0; k < a2.length; k++) {
                if (a1[i] == a2[k]) {
                    matchFound = true;
                }
            }
            if (!matchFound) {
                result[resI] = a1[i];
                resI++;
            }
            i++;
        }
        return Arrays.copyOf(result, resI);
    }
}
