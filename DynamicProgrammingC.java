package mypackage;

public class DynamicProgrammingC {

    public static int CoinChangeWays(int coin[], int sum) {
        // create dp marrix to store ways
        int dp[][] = new int[coin.length+1][sum+1];

        // initialising cells
        for(int i = 0 ; i< dp.length; i++){
            dp[i][0] = 1;
        }

        for(int j = 0; j<dp[0].length ; j++){
            dp[0][j] = 0;
        }

        // now using bottom up approach to fill the dp matrix

        for(int i = 1 ; i<dp.length; i++){
            for(int j = 1; j<dp[0].length; j++){
                if(coin[i-1]<=j){// checking is valid
                    // comparing ways of include and exclude condition
                    dp[i][j] = dp[i][j-coin[i-1]]+ dp[i-1][j]; 
                }else{ // not valid or invalid
                    dp[i][j] = dp[i-1][j];
                }
            }

        }
        return dp[coin.length][sum];
    }

    // using Tabulation method (Max profit)
    public static int RodCuttingMaxprice(int length[], int price[]){
        // creating the dp matrix to fill the maxProfit
        int dp[][] = new int[length.length+1][price.length+1];

        for(int i = 0; i< dp.length;i++){
            dp[i][0] = 0;
        }
        for(int j = 0 ; j<dp[0].length; j++){
            dp[0][j] = 0;
        }

        for(int i = 1 ; i< dp.length; i++){
            for(int j = 1 ; j< dp[0].length; j++){
                // valid condition
                if(length[i-1]<=j){
                    // compare include and exclude condition and then fill max of them in the dp
                    dp[i][j] = Math.max(price[i-1] + dp[i][j-length[i-1]], dp[i-1][j]);
                }
                else{
                    // invalid condition
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[length.length][price.length];
    }

    // solving using Normal recursion (T.C. => O(2^n)) exponential time complexity
    public static int LcsSumR(String str1, String str2, int n,int m){
        // base case
        if(n == 0 || m == 0){
            return 0;
        }

        if(str1.charAt(n-1) == str2.charAt(m-1)){
            return 1 + LcsSumR(str1, str2, n-1, m-1); 
        }else{
            return Math.max(LcsSumR(str1, str2, n-1, m ),LcsSumR(str1, str2, n, m-1 )) ;
        }
    }

    // solving using Memoization method dp (T.C. => O(n*m))
    public static int LcsSumM(String str1, String str2, int n,int m, int dp[][]){
        // base case
        if(n == 0 || m == 0){
            return 0;
        }

        if(dp[n][m] != -1){
            return dp[n][m];
        }

        if(str1.charAt(n-1) == str2.charAt(m-1)){
            return 1 + LcsSumR(str1, str2, n-1, m-1); 
        }else{
            return Math.max(LcsSumR(str1, str2, n-1, m ),LcsSumR(str1, str2, n, m-1 )) ;
        }
    }

    // Solving using Tabulation Method of Dp (T.C. => O(n*m))
    public static int LcsSumT(String str1, String str2){
        // dp table
        int n = str1.length()+1;
        int m = str2.length()+1;
        int dp[][] = new int[n][m];
        
        for(int i = 0; i< dp.length;i++){
            dp[i][0] = 0;
        }
        for(int j = 0 ; j<dp[0].length; j++){
            dp[0][j] = 0;
        }

        for(int i = 1 ; i< dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                // valid condition
                if(str1.charAt(i-1)  == str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        return dp[n-1][m-1];
    }

    public static void main(String[] args) {
        // ** */ coin change - > we can use approach of unbounded knapsack here to
        // calculate number of ways
        int coin[] = { 1, 2, 3 };
        int sum = 4;

        System.out.println(CoinChangeWays(coin, sum));
        
        //**  Rod cutting  -> we can use approach of unbounded knapsack here to calculate the max profit by cutting rod in pieces

        int rod[] = {1,2,3,4,5,6,7,8};
        int price[]= {1,5,8,9,10,17,17,20};
        System.out.println(RodCuttingMaxprice(rod,price));

        //IMP ** Lowest common subsequence (recursion)
        String str1 = "abcde";
        String str2  = "ace";
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];

        for(int i = 0; i< dp.length; i++){
            for(int j = 0 ; j< dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        
        for(int i = 0; i< dp.length;i++){
            dp[i][0] = 0;
        }
        for(int j = 0 ; j<dp[0].length; j++){
            dp[0][j] = 0;
        }

        System.out.println(LcsSumR(str1,str2,n ,m));
        System.out.println(LcsSumM(str1,str2,n ,m, dp ));
        System.out.println(LcsSumT(str1,str2));

    }
}