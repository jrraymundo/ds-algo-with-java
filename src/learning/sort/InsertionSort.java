package learning.sort;

import java.util.Arrays;

public class InsertionSort {

    /*
    INSERTION SORT
    - In-place algorithm
    - Time complexity: O(n²) - quadratic
    - Stable algorithm

    Assumes that the first index of the array is sorted,
    and assumed that index 1 onward are unsorted.
    So we take index 1 and compare it to index 0,
    if index 0 is greater, then we insert or shift index 1 to the left of index 0,
    making it the new index 0. This is repeated until all indices are sorted.
     */

    public static void main(String[] args) {
        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };

        for (int currentUnsortedIndex = 1; currentUnsortedIndex < intArray.length; currentUnsortedIndex++) {
            int temp = intArray[currentUnsortedIndex];

            int i;
            for (i = currentUnsortedIndex; i > 0 && intArray[i - 1] > temp; i--) {
                intArray[i] = intArray[i - 1];
            }

            intArray[i] = temp;
        }

        System.out.println(Arrays.toString(intArray));
        System.out.println("Sorting complete.");
    }
}
