package learning.dp;

import java.util.Arrays;

public class Knapsack {

    // This is wrong
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

    // Not optimal
    static int knapsackNaiveRecursion(int C, int[] weights, int[] values, int N) {
        // Base Case
        if (N == 0 || C == 0) return 0;

        if (weights[N - 1] > C) {
            return knapsackNaiveRecursion(C, weights, values, N - 1);
        }
        else {
            int valueIncluded = values[N - 1] + knapsackNaiveRecursion(C - weights[N - 1], weights, values,N - 1);
            int valueExcluded = knapsackNaiveRecursion(C, weights, values, N - 1);
            return Math.max(valueIncluded, valueExcluded);
        }
    }

    // DP - Top Down Approach (Recursive Memo)
    static int knapsackMemoRecursion(int C, int[] weights, int[] values, int N, int[][] dpTable) {
        // Base Case
        if (N == 0 || C == 0) return 0;

        if (dpTable[N][C] != -1) return dpTable[N][C];

        if (weights[N - 1] > C) {
            return dpTable[N][C] = knapsackMemoRecursion(C, weights, values, N - 1, dpTable);
        }
        else {
            int valueIncluded = values[N - 1] + knapsackMemoRecursion(C - weights[N - 1], weights, values,N - 1, dpTable);
            int valueExcluded = knapsackMemoRecursion(C, weights, values, N - 1, dpTable);
            return dpTable[N][C] = Math.max(valueIncluded, valueExcluded);
        }
    }

    // DP - Bottom Up Approach
    static int dp(int C, int[] weights, int[] values, int N) {
        int[][] dpTable = new int[N + 1][C + 1];

        for (int i = 0; i <= N; i++) {
            for (int c = 0; c <= C; c++) {
                if (i == 0 || c == 0) dpTable[i][c] = 0;
                else if (weights[i - 1] <= c) {
                    int valueIncluded = values[i - 1] + dpTable[i-1][c - weights[i - 1]];
                    int valueExcluded = dpTable[i - 1][c];
                    dpTable[i][c] = Math.max(valueIncluded, valueExcluded);
                }
                else {
                    dpTable[i][c] = dpTable[i - 1][c];
                }
            }
        }

        System.out.println(Arrays.deepToString(dpTable));
        return dpTable[N][C];
    }

    public static void main(String[] args) {
        int[] values = {3000, 2000, 1500};
        int[] weights = {4, 3, 1};
        int N = 3; // Total number of items
        int C = 4; // Max capacity of knapsack

        // Bottom Up Approach (For loop)
        // int recursionBestValue = dp(C, weights, values, N);
        // System.out.println(recursionBestValue);

        // Top Down Approach (Recursive memo)
        int[][] dpTable = new int[N + 1][C + 1];
        for (int n = 0; n < (N + 1); n++) {
            for (int c = 0; c < (C + 1); c++) {
                dpTable[n][c] = -1;
            }
        }
        System.out.println(knapsackMemoRecursion(C, weights, values, N, dpTable));
        System.out.println(Arrays.deepToString(dpTable));
    }
}
