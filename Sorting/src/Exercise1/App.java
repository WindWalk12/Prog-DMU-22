package Exercise1;

import java.util.Arrays;

public class App {
    public static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                   int temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[index]) {
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
        //bubbleSort(numbers);
        selectionSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
