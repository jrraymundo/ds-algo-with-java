package learning.dp;

public class Knapsack {

    /* Doesn't work for other cases */
    public static int naiveForLoop(int maxCapacity, int[] weights, int[] values, int totalItems) {
        int maxValue = 0;
        for (int x = 0; x < totalItems; x++) {
            for (int y = x+1; y < totalItems; y++) {
                if (weights[x] + weights[y] > maxCapacity) continue;

                int currentSumValue = values[x] + values[y];
                if (currentSumValue > maxValue) maxValue = currentSumValue;
            }
        }
        return maxValue;
    }

    static int knapsackRecursion(int C, int[] weights, int[] values, int N) {
        // Base Case
        if (N == 0 || C == 0) return 0;

        if (weights[N - 1] > C) {
            return knapsackRecursion(C, weights, values, N - 1);
        }
        else {
            int valueIncluded = values[N - 1] + knapsackRecursion(C - weights[N - 1], weights, values,N - 1);
            int valueExcluded = knapsackRecursion(C, weights, values, N - 1);
            return Math.max(valueIncluded, valueExcluded);
        }
    }

    public static void main(String[] args) {
        int N = 3; // Total number of items
        int C = 4; // Max capacity of knapsack
        int[] values = {3000, 2000, 1500};
        int[] weights = {4, 3, 1};

        // int naiveBestValue = naiveForLoop(C, weights, values, N);
        // System.out.println(naiveBestValue);

        int recursionBestValue = knapsackRecursion(C, weights, values, N);
        System.out.println(recursionBestValue);
    }
}
