package learning.sort.practice;

import java.util.Arrays;

public class MergeSortPractice {

    public static void main(String[] args) {
        int[] myNumbers = { 20, 13, 31, 7, 27, 1, 45, 77, 89 };
        mergeSort(myNumbers, 0, myNumbers.length);
        System.out.println(Arrays.toString(myNumbers));
    }

    public static void mergeSort(int[] array, int start, int len) {
        // Once we're left with an array with 1 item then return
        if (len - start <= 1) return;

        int mid = (start + len) / 2;
        // System.out.println(mid);

        mergeSort(array, start, mid); // Succeeding length of Left's array will now be 3

        mergeSort(array, mid, len);

        merge(array, start, mid, len);
    }

    public static void merge(int[] array, int start, int mid, int len) {
        int i = start; // 0
        int j = mid; // 1

        int tempIndex = 0;
        int[] temp = new int[len - start];

        while (i < mid && j < len) {
            temp[tempIndex++] = array[i] <= array[j] ? array[i++] : array[j++];
        }
        while (i < mid) {
            temp[tempIndex++] = array[i++];
        }
        while (j < len) {
            temp[tempIndex++] = array[j++];
        }

        // System.out.format("start %d; mid %d; len %d", start, mid, len);
        // System.out.println("");
        // System.out.println(Arrays.toString(temp));

        System.arraycopy(temp, 0, array, start, temp.length);
    }

    public static void arrayCopy() {
        int[] array = {1, 2, 3};
        int[] otherArray = {4, 5, 6};
        System.arraycopy(otherArray, 0, array, 0, otherArray.length);
        System.out.println(Arrays.toString(array)); // array becomes [4,5,6] due to arraycopy
    }
}
