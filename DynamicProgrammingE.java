package mypackage;

import java.util.Arrays;

public class DynamicProgrammingE {

    public static boolean WildCardMatching(String s, String p) {

        int n = s.length();
        int m = p.length();
        // creating Dp array
        boolean dp[][] = new boolean[n + 1][m + 1];

        // Initialization
        dp[0][0] = true;
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = false;
        }

        for (int j = 1; j < dp[0].length; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        // fill the dp array

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {

                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
    }

    public static int CatalansR(int n) {
        // base case
        if (n == 1 || n == 0) {
            return 1;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {

            ans += CatalansR(i) * CatalansR(n - i - 1);

        }
        return ans;
    }

    public static int CatalansM(int n, int dp[]) {

        if (n == 0 || n == 1) {
            return 1;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        // else

        int ans = 0;
        for (int j = 0; j < n; j++) {
            ans += CatalansM(j, dp) * CatalansM(n - j - 1, dp);
        }

        return dp[n] = ans;
    }

    public static int CatalansT(int n) {
        // creating dp array
        int dp[] = new int[n + 1];

        // initializing
        dp[0] = dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    public static int CountBST(int nodes){
        int count[] = new int[nodes+1];

        count[0] = count[1] = 1;

        for(int i= 2 ; i< count.length; i++){
            for(int  j = 0 ; j<i; j++){
                int left = count[j];
                int right = count[i-j-1];

                count[i] += left*right;
            }
        }
        return count[nodes];
    }

    public static int MountainRanges(int pairs){
        // initialising dp array
        int dp[] = new int[pairs+1];
        dp[0] = dp[1] = 1;

        for(int i = 2 ; i<dp.length; i++){
            for(int j = 0 ; j<i; j++){
                // if the pair is outside slant sides
                int inside = dp[j];
                int outside = dp[i-j-1];
                dp[i] += inside*outside;
            }
        }
        return dp[pairs];
    }

    public static void main(String[] agrs) {
        // ** */ Wild card matching Question
        String s = "baaabab";
        String p = "a*ab";
        System.out.println(WildCardMatching(s, p));

        // ** Catalans Number (Imp Concept)
        // Using Recursion
        int n = 5;
        System.out.println(CatalansR(n));
        // Using Memorization
        int d = 4;
        int dp[] = new int[d + 1];
        Arrays.fill(dp, -1);
        System.out.println(CatalansM(d, dp));
        // Using Tebulation
        int e = 5;
        System.out.println(CatalansT(e));
        // count BST
        int nodes = 3;
        System.out.println(CountBST(nodes));
        // Mountain Ranges
        int pairs = 3;
         System.out.println(MountainRanges(pairs));
    }
}
