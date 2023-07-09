package mypackage;

public class DynamicProgrammingB {
    // 0-1 Knapsack using Recursion
    public static int KnapsackRecursion(int val[], int wt[], int W, int n) {
        // Base Case
        if (n == 0 || W == 0) {
            return 0;
        }

        // valid condition
        if (W >= wt[n - 1]) {
            // if we choose to include the weight
            int include = val[n - 1] + KnapsackRecursion(val, wt, W - wt[n - 1], n - 1);
            // if we want to exclude the weight
            int exclude = KnapsackRecursion(val, wt, W, n - 1);
            return Math.max(include, exclude);
        } else {
            // invalid condition
            return KnapsackRecursion(val, wt, W, n - 1);
        }
    }

    public static int KnapsackMemorization(int val[], int wt[], int W, int n, int dp[][]) {
        // base case
        if (n == 0 || W == 0) {
            return 0;
        }
        // if maxProfit already exists for given parameters
        if (dp[n][W] != -1) {
            return dp[n][W];
        }

        // else fill the max profit in cell with given n and wt
        if (W >= wt[n - 1]) {
            // condition for include
            int include = val[n - 1] + KnapsackMemorization(val, wt, W - wt[n - 1], n - 1, dp);
            // Exclude condition
            int exclude = KnapsackMemorization(val, wt, W, n - 1, dp);
            dp[n][W] = Math.max(include, exclude);
            return dp[n][W];
        } else {
            // invalid Condition
            return KnapsackMemorization(val, wt, W, n - 1, dp);
        }

    }

    public static int KnapsackTabulation(int[] val, int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n + 1][W + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                int v = val[i - 1];
                int w = wt[i - 1];
                if (j >= w) { // valid
                    int include = v + dp[i - 1][j - w];
                    int exclude = dp[i - 1][j];
                    dp[i][j] = Math.max(include, exclude);
                } else {// invalid
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
        for (int j = 0; j < dp[0].length; j++) {
        System.out.print(dp[i][j]+" ");
        }
        System.out.println();
        }
        return dp[n][W];
    }

    // Target Sum Subset

    public static boolean TargetSumSubset(int num[], int sum){
        // creating dp array to store answers
        int size = num.length;
        boolean dp[][] = new boolean[size+1][sum+1];

        // initialise condition -> if sum is zero then there is only one empty subset so
        for(int i = 0; i<dp.length; i++){
            dp[i][0] = true;
        }

        for(int i = 1 ; i<dp.length; i++ ){
            for(int j = 1; j< dp[0].length; j++){
                int n = num[i-1];
                // include
                if( j>= n && dp[i-1][j-n]== true){
                     dp[i][j] = true;
                }else if(dp[i-1][j] == true){// exclude
                     dp[i][j] = true;
                }
            }
        }
        return dp[size][sum];
    }

    // Unbounded Knapsack problem
    public static int UnboundedKnapsackTabulation(int[] val, int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n + 1][W + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                int v = val[i - 1];
                int w = wt[i - 1];
                if (j >= w) { // valid
                    int include = v + dp[i][j - w];
                    int exclude = dp[i - 1][j];
                    dp[i][j] = Math.max(include, exclude);
                } else {// invalid
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
        for (int j = 0; j < dp[0].length; j++) {
        System.out.print(dp[i][j]+" ");
        }
        System.out.println();
        }
        return dp[n][W];
    }


    public static void main(String[] args) {
        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int W = 7;
        int n = 5;
        // 0-1 Knapsack using Recursion
        System.out.println(KnapsackRecursion(val, wt, W, n));
        // create 2D array to store Maximum profits between the range 0 to i and
        // capacity W.
        int dp[][] = new int[n + 1][W + 1];
        // initializing it with -1 in each cell
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(KnapsackMemorization(val, wt, W, n, dp));
        System.out.println(KnapsackTabulation(val, wt, W));

        // Target Sum Subset Question

        int number[] = {4,2,7,1,3};
        int Sum = 10;

        System.out.print(TargetSumSubset(number,Sum));

        // Unbounded Knapsack
        System.out.println(UnboundedKnapsackTabulation(val, wt, W));

    }
}
