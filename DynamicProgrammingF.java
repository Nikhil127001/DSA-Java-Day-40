package mypackage;

import java.util.*;

public class DynamicProgrammingF {

    public static int MatrixChainMulR(int arr[], int i, int j) {
        // base case

        if (i == j) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;

        for (int k = i; k <= j - 1; k++) {
            int cost1 = MatrixChainMulR(arr, i, k);
            int cost2 = MatrixChainMulR(arr, k + 1, j);
            int cost3 = arr[i - 1] * arr[k] * arr[j];
            // System.out.println(cost1 + " " + cost2 + " " + cost3);
            int finalCost = cost1 + cost2 + cost3;
            ans = Math.min(ans, finalCost);
        }
        return ans;
    }

    public static int MatrixChainMulM(int arr[], int i, int j, int dp[][]) {

        // base case
        if (i == j) {
            return 0;
        }

        // checkinng if sol already exists
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int cost1 = MatrixChainMulM(arr, i, k, dp);
            int cost2 = MatrixChainMulM(arr, k + 1, j, dp);
            int cost3 = arr[i - 1] * arr[k] * arr[j];
            ans = Math.min(ans, cost1 + cost2 + cost3);
        }
        return dp[i][j] = ans;
    }

    public static int MatrixChainMulT(int arr[]) {
        int n = arr.length;
        // creating 2D array
        int dp[][] = new int[n][n];

        // initialization diagonal elements cuz if the i == j means there is only one
        // single element in the arr

        for (int t = 0; t < n; t++) {
            dp[t][t] = 0;
        }

        // starting filling 2D array in bottom up manner
        // we have already define above for length of array = 1
        // now start from 2

        for (int len = 2; len <= n - 1; len++) {
            // defining starting point of array which is s
            for (int s = 1; s <= n - len; s++) {
                // finding ending point
                int e = s + len - 1;
                int ans = Integer.MAX_VALUE;
                // creating k pointer
                for (int k = s; k <= e - 1; k++) {
                    int cost1 = dp[s][k];
                    int cost2 = dp[k+1][e];
                    int cost3 = arr[s - 1] * arr[k] * arr[e];
                    dp[s][e] = Math.min(ans, cost1 + cost2 + cost3);
                }
            }
        }
        return dp[1][n-1];
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 3 };
        int n = arr.length;

        // Matrix chain multiplication using recursion

        System.out.println(MatrixChainMulR(arr, 1, n - 1));

        // Matrix chain multiplication using Memoization

        int dp[][] = new int[n][n];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(MatrixChainMulM(arr, 1, n - 1, dp));

        //// Matrix chain multiplication using Tabulation

        System.out.println(MatrixChainMulT(arr));

    }
}
