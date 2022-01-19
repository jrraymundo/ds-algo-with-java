package learning.sort;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };

        for (int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            int largestIndex = 0;
            for (int i = 0; i <= lastUnsortedIndex; i++) {
                if (intArray[i] > intArray[largestIndex]) {
                    largestIndex = i;
                }
            }
            swap(intArray, largestIndex, lastUnsortedIndex);
        }

        System.out.println(Arrays.toString(intArray));
        System.out.println("Sorting complete.");
    }

    public static void swap(int[] array, int i, int j) {
        if (i == j) return;

        // Ex. array[i] = 1; array[j] = 2;
        array[i] += array[j]; // 1 + 2 = 3
        array[j] = array[i] - array[j]; // 3 - 2 = 1
        array[i] = array[i] - array[j]; // 3 - 1 = 2
    }
}
