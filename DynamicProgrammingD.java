package mypackage;
import java.util.HashSet;
import java.util.Arrays;

public class DynamicProgrammingD {

    public static int longestCommonSubstring(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        // creating 2d array to store lcs
        int dp[][] = new int[n + 1][m + 1];
        // initializing
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }
        int ans = 0;

        // filling the 2D array dp

        for (int j = 1; j < m + 1; j++) {
            for (int i = 1; i < n + 1; i++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    // valid
                    // if same
                    ans = Math.max(1 + dp[i - 1][j - 1], ans);
                    dp[i][j] = ans;
                } else {
                    // diff
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }

    public static int lcs(int arr[], int arr2[]) {
        int n = arr.length;
        int m = arr2.length;
        // creating 2D array to store the lcs
        int dp[][] = new int[n + 1][m + 1];

        // initialising
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }

        // filling the array dp
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (arr[i - 1] == arr2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }

    public static int lis(int arr[]) {
        // longest increasing sequence is a sequence of longest unique sorted and in
        // ascending order characters
        // we areusing here hashset to take out unique charecters and fill it
        // in the new array
        HashSet<Integer> h = new HashSet<>();
        for (int j = 0; j < arr.length; j++) {
            h.add(arr[j]);
        }
        int arr2[] = new int[h.size()];
        int i = 0;
        for (int item : h) {
            arr2[i] = item;
            i++;
        }
        // sorting the array
        Arrays.sort(arr2);
        return lcs(arr, arr2);
    }

    public static int ED(String Str1, String Str2){
        int n = Str1.length();
        int m = Str2.length();
        // creating 2D array to store the lcs
        int dp[][] = new int[n + 1][m + 1];
        
        // initialising
        for(int i = 0; i< dp.length; i++){
            dp[i][0] = i;
        }
        for(int j = 0; j< dp[0].length; j++){
            dp[0][j] = j;
        }
         
        // filling the array dp
        for(int i = 1; i< dp.length; i++){
            for(int j = 1; j< dp[0].length; j++){
                if(Str1.charAt(i-1) == Str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    int replace  = dp[i-1][j-1] +1;
                    int delete  = dp[i-1][j] +1;
                    int insert  = dp[i][j-1] +1;
                    dp[i][j] = Math.min(replace,Math.min(delete, insert));
                }
            }
        }
        for(int i = 0; i< dp.length; i++){
            for(int j = 0; j< dp[0].length; j++){
               System.out.print(dp[i][j]+ " ");
            }
            System.out.println();
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        // Longest common substring
        String Str1 = "ABCDGH";
        String Str2 = "ACDGHR";
        System.out.println(longestCommonSubstring(Str1, Str2));

        // Longest Increasing Subsequence
        int arr[] = { 50, 3, 10, 7, 40, 80 };
        System.out.println(lis(arr));

        //** IMP Edit Distance
        String str1 = "abc";
        String str2 = "sbd";
        System.out.println(ED(str1, str2));
    }
}
