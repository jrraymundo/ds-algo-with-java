package learning.sort;

import java.util.Arrays;

public class BubbleSort {

    /**
     * BUBBLE SORT
     * - In-place algorithm
     * - Stable sort
     * - Time complexity: O(n²) - quadratic
     * - It will take 100 steps to sort 10 items
     * - Probably shouldn't use this in real projects because it's slow
     *
     * Starting from the 1st index, you check if it's greater than the next index value
     * If it's greater, then swap them. Else, move pointer to the greater index value
     * and check if it's greater than the next index as well. This repeats until the greater
     * values are moved to the end of the array.
     */

    public static void main(String[] args) {
        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };

        for (int lastUnsortedIndex = intArray.length -1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            for (int i = 0; i < lastUnsortedIndex; i++) {
                if (intArray[i] > intArray[i + 1]) {
                    swap(intArray, i, i + 1);
                }
            }
        }

        System.out.println(Arrays.toString(intArray));
        System.out.println("Sorting complete.");
    }

    /**
     * Alternate Solution with while loop
     *
    public static void main(String[] args) {
        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };
        int x = 0;
        int y = intArray.length - 1;
        while (true) {
            if (y <= 0) {
                System.out.println("Sorting complete.");
                return;
            }

            if (x == y) {
                System.out.println(Arrays.toString(intArray));
                x = 0;
                y--;
            }

            if (intArray[x] > intArray[x + 1]) {
                swap(intArray, x, x+1);
            }

            x++;
        }
    }
    */

    public static void swap(int[] array, int i, int j) {
        if (i == j) return;

        // Ex. array[i] = 1; array[j] = 2;
        array[i] += array[j]; // 1 + 2 = 3
        array[j] = array[i] - array[j]; // 3 - 2 = 1
        array[i] = array[i] - array[j]; // 3 - 1 = 2
    }
}
