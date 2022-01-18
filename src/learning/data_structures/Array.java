package learning.data_structures;

import java.util.Arrays;

public class Array {

    /**
     * ARRAYS
     * - Contiguous block in memory
     * - Every element occupies the same amount of space in memory (making it predictable for computing)
     *
     * Items are accessed fast and easily as long as you know the index.
     * The computation that happens to access the arrays are constant O(1).
     * Formula is `x + i * y`
     * int x = start address of the array (could be anything)
     * int i = index of array value
     * int y = size of the array value
     *
     * TIME COMPLEXITY
     * Retrieve item with index - O(1)
     * Retrieve without index - O(n)
     * Add item to a full array - O(n)
     * Add item to end of array (not full) - O(1)
     * Insert/update item at a specific index - O(1)
     * Delete element by setting it to null - O(1)
     * Delete element by shifting elements - O(n)
     *
     * KEY TAKEAWAYS
     * - When you don't need to loop through an array for an operation,
     *   then it's O(1) or constant.
     * - When you need to loop over an array then it's O(n) or linear.
     */

    public static void main(String[] args) {
        int[] numbers = new int[5];
        numbers[0] = 2;
        numbers[1] = 5;
        numbers[2] = 12;
        numbers[3] = 7;
        numbers[4] = 16;

        System.out.println(Arrays.toString(numbers));
        System.out.println(numbers[1]);
        System.out.println(numbers[2]);
    }
}
