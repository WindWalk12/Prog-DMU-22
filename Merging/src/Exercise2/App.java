package Exercise2;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        int[] t1 = {2, 4, 6, 8, 10, 12, 14};
        int[] t2 = {1, 2, 4, 5, 6, 9, 12, 17};

        System.out.println(Arrays.toString(intersection(t1, t2)));

    }

    public static int[] intersection(int[] a1, int [] a2) {
        int matching = 0;
        int j = 0;
        while (a1.length > j) {
            boolean matchFound = false;
            for (int k = 0; k < a2.length; k++) {
                if (a1[j] == a2[k]) {
                    matchFound = true;
                }
            }
            if (!matchFound) {
                matching++;
            }
            j++;
        }
        int[] result = new int[matching];
        int i = 0;
        int resI = 0;
        while (a1.length > i) {
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
        return result;
    }
}
