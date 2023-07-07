package mypackage;
import java.util.Arrays;

public class DynamicProgrammingA {

    // memoization method in DP to calculate fibonacci sequence
    public static int calculateFibonacciM(int n, int f[]){

        // base case

        if(n == 0 || n == 1){
            return n;
        }
        if(f[n] != 0){ // it is already calculated
            return f[n];
        }

        // calculate fibo
        f[n] = calculateFibonacciM(n-1,f) + calculateFibonacciM(n-2,f);


        return f[n];
    }

    // Tabulation method in Dp to calculate fibonacci at nth no.

    public static int calculateFibonacciT(int n ){

        int dp[] = new int[n+1];
        
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2 ; i<=n ; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    // ** climbing Stairs problem Solution(Using Normal recursion )(T.C. => O(2^n))

    // function to calculate no of ways to reach nth stair
    public static int NormalREcursion(int n){
        if(n == 0){
            return 1;
        }
        if(n < -1){
            return 0;
        }

        return NormalREcursion(n-1) + NormalREcursion(n-2);
    }
    // ** climbing Stairs problem Solution(Using Memoization Method of DP)(T.C. => O(n))

    public static int Memoization(int ways[], int n){
     if(n < 0){
        return 0;
     }

     if(n == 0){
        return 1;
     }

     if(ways[n]  != -1){ // ways exists
        return ways[n];
     }

     ways[n] = Memoization(ways,n-1)+ Memoization(ways,n-2);

     return ways[n];
    }

     // ** climbing Stairs problem Solution(Using Tabulation Method of DP)(T.C. => O(n))

     // Tabulation method

     public static int Tabulation(int ways[],int n){
       ways[0] = 1;
        for(int i = 1 ; i<=n ; i++ ){
            if(i  == 1){
                ways[i] = ways[i-1] + 0;
            }else{
                ways[i] = ways[i-1] + ways[i-2];
            }
        }

        return ways[n];
     }




    public static void main(String[] args){
//         int n = 3;
//         //creating array of result of subproblems 
//         int f[] = new int[n+1];
//         for(int i = 0 ; i<f.length ; i++){
//             f[i] = 0;
//         }
//         System.out.println(calculateFibonacciM(n,f)
// );
//         System.out.println(calculateFibonacciT(n)
// );

 // ** Climbing stairs 
    int n = 5;
    // normal recursion
    System.out.println(NormalREcursion(n));

    // Memoization method

    int ways[] = new int[n+1];
    Arrays.fill(ways,-1);
    //calculate waysusing Memoization

    System.out.println(Memoization(ways, n));

    // Tabulation method
    //calculate waysusing Memoization
     Arrays.fill(ways,-1);
    System.out.println(Tabulation(ways,n));

    }
}
