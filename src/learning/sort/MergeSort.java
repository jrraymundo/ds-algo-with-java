package learning.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        // int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };
        int[] intArray = { 4, 2, 3, 1}; // [3,1] start = 2; end = 4; mid = 3;
                                        // mergeSort(input, 3, 4) 4-3= 1 return

        mergeSort(intArray, 0, intArray.length);

        System.out.println(Arrays.toString(intArray));
        System.out.println("Sorting complete.");
    }

    public static void mergeSort(int[] input, int start, int end) {
        /**
         * NOTE: The "end" is always 1 index greater than the actual last index of the array
         * */

        // When we're left with 1 item in the array then stop recursion
        if (end - start < 2) return;

        // Get the middle index
        int mid = (start + end) / 2;

        // Divide and conquer begins
        // Recursively handle the left side of the array
        mergeSort(input, start, mid);

        // Recursively handle the right side of the array
        mergeSort(input, mid, end);

        merge(input, start, mid, end);
    }

    public static void merge(int[] input, int start, int mid, int end) {
        // It's expected that this method always merges sorted arrays
        // So if "input[mid - 1] <= input[mid]" is true then we don't have to merge anything
        // This an optimization, this method will still work even without this line
        if (input[mid - 1] <= input[mid]) return;

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];

        // We loop over the left (i) and right (j) side of an array
        // to compare their values, the lower value gets pushed to the temp array
        // this repeats until the temp array basically holds all the values and is sorted
        while (i < mid && j < end) {
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }

        /**
         * System.arraycopy(source_arr, sourcePos, dest_arr, destPos, len)
         *  source_arr = array to be copied from
         *  sourcePos = starting position in source array from where to copy
         *  dest_arr = array to be copied in
         *  destPos = starting position in destination array, where to copy in
         *  len = total no. of components to be copied.
         */

        // The line below only does something when there are leftover elements in the left array when the loop ends
        // If there's a leftover element in the left array, "i" will always be the index of that element
        // Example:
        //  temp = [1, 2, 3]
        //  input = [2, 4, 1, 3]
        //              i     j
        //
        // System.arraycopy(input, i, input, start + tempIndex, mid - i);
        // input = [2, 4, 1, 4] <- "i" which is equal to 4 gets copied to the last index of input
        //
        // System.arraycopy(temp, 0, input, start, tempIndex);
        // input = [1, 2, 3, 4] <- temp gets copied to input up to the tempIndex only, preserving the 4 that was copied
        //
        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, input, start, tempIndex);
    }
}
