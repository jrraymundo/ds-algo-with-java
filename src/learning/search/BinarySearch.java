package learning.search;

public class BinarySearch {
    static int target = 10;
    static int[] list = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    public static void main(String[] args) {
        int minIndex = 0;
        int highIndex = list.length - 1;
        int initialGuess = (list.length - 1) / 2;

        int result = binarySearch(initialGuess, minIndex, highIndex);

        if (result < 0) {
            System.out.println("Target not found in the list");
        }
        else {
            System.out.println("Answer is " + result);
        }
    }

    public static int binarySearch(int indexGuess, int minIndex, int maxIndex) {
        if (list[indexGuess] == target) return indexGuess;
        if (minIndex == maxIndex) return -1;

        if (list[indexGuess] < target) {
            minIndex = indexGuess + 1;
        }
        else {
            maxIndex = indexGuess - 1;
        }

        int newGuess = (minIndex + maxIndex) / 2;

        return binarySearch(newGuess, minIndex, maxIndex);
    }
}
