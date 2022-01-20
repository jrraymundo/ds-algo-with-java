package learning.sort;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };
        int initialGap = intArray.length / 2;

        // Outer loop
        // The gap will be divided by 2 for every iteration
        for (int gap = initialGap; gap > 0; gap /= 2) {

            // Inner loop that moves to the right
            for (int i = gap; i < intArray.length; i++) {
                int newElement = intArray[i];

                // Innermost loop that moves to the left
                int j = i;
                while (j >= gap && intArray[j - gap] > newElement) {
                    intArray[j] = intArray[j - gap];
                    j -= gap;
                }

                intArray[j] = newElement;
            }

        }

        System.out.println(Arrays.toString(intArray));
        System.out.println("Sorting complete.");
    }
}
