package mypackage;

import java.util.*;

public class DynamicProgrammingF {

    public static int MatrixChainMulR(int arr[], int i, int j) {
        // base case

        if (i == j) {
            return 0;
        }
        
        int ans = Integer.MAX_VALUE;

        for (int k = i; k<=j-1; k++) {
            int cost1 = MatrixChainMulR(arr, i, k);
            int cost2 = MatrixChainMulR(arr, k+1, j);
            int cost3 = arr[i - 1] * arr[k] * arr[j];
            // System.out.println(cost1 + " " + cost2 + " " + cost3);
            int finalCost = cost1 + cost2 + cost3;
            ans = Math.min(ans, finalCost);
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 3 };
        int n = arr.length;
        System.out.print(MatrixChainMulR(arr, 1, n-1));
    }
}
