package Exercise2;

import java.util.Arrays;

public class App {
    public static void bubbleSort(int[] a, boolean order) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1] && order) {
                   int temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
                if (a[j] < a[j + 1] && !order) {
                    int temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] a, boolean order) {
        for (int i = 0; i < a.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[index] && order) {
                    index = j;
                }
                if (a[j] > a[index] && !order) {
                    index = j;
                }
            }
            int smallestNumber = a[index];
            a[index] = a[i];
            a[i] = smallestNumber;
        }
    }
    public static void main(String[] args) {
        int[] numbers = {11, 2, 4, 1, 9, 8};
        System.out.println(Arrays.toString(numbers));
        //bubbleSort(numbers, true);
        selectionSort(numbers, true);
        System.out.println(Arrays.toString(numbers));
    }
}
