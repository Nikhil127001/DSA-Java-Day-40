package mypackage;

public class Recursion {
    // public static void printDecreasingNum(int n){
    //     // here we will hit the base case
    //     if(n==1){
    //         System.out.print(n);
    //         return;
    //     }
    //     // first print number 
    //     System.out.print(n);
    //     // the call function again for lower level
    //     printDecreasingNum(n-1);
    //}

    // public static void printIncreasingNum(int n){
    //     if(n == 1){
    //            System.out.println(n);
    //            return;
    //     }
    //     printIncreasingNum(n-1);
    //     System.out.println(n);
        
    // }

    // public static int  printFactorialOfNum(int n){
    //     if(n ==1 ){
    //         return n;
    //     }
    //    int fc = n * printFactorialOfNum(n-1);
    //      return fc;
    // }

    // public static int printSumOfNaturalNum(int n ){
    //     if (n == 1 ){
    //         return 1;
    //     }

    //     int sum = n + printSumOfNaturalNum(n-1);
    //     return sum;
    // }
    // public static int printFibnacci(int n){
    //     if(n ==0 || n ==1){
    //       return n;
    //     }
    //      int fn  = printFibnacci(n-1)+ printFibnacci(n-2);
    //     return fn;
    // }

    // public static Boolean checkSorted(int arr[], int i){
    //     if(i == arr.length-1){
    //         return true;
    //     }
    //     if(arr[i]> arr[i+1]){
    //         return false;
    //     }
        
    //     return checkSorted(arr, i+1);

    // }

    // public static void  FirstOccurence(int arr[], int key, int i){
    //     if(i == 0){
    //         System.out.println("key not found");
    //        return;
    //     }
    //     if(arr[i] == key){
    //        System.out.println("key found at index = " + i);
    //        return;
    //     }
    //     FirstOccurence(arr, key, i-1); 
    // }

    // public static void  LastOccurence(int arr[], int key, int i){
    //     if(i == 0){
    //         System.out.println("key not found");
    //        return;
    //     }
    //     if(arr[i] == key){
    //        System.out.println("key found at index = " + i);
    //        return;
    //     }
    //     LastOccurence(arr, key, i-1); 
    // }
    
    // public static int CalcPow(int x , int i){
    //     if(i == 0){
    //         int ans = (int)(Math.pow(x, i));
    //         return ans;
    //     }
         
    //      int result = x*CalcPow(x, i-1);
    //     return result;
    // }

    // public static int OptimizedPow(int x, int i){
    //     if(i == 0){
    //                 return 1;
    //             }
    //     int halfpower = OptimizedPow(x, i/2);
    //     int z = halfpower * halfpower;
    //     if(x % 2 != 0){
    //         z = x * z;
    //     }
    //     return z;
    //     }
        
    // public static int TilingProblem(int length){
    //     if(length == 0|| length ==1){
    //         return 1;
    //     }
        
    //     int TotalWays = 
    //     /* for vertical choice*/
    //     TilingProblem(length-1) + 
    //     /* for horizontal choice*/
    //     TilingProblem(length-2);

    //     return TotalWays;
    // }
    

    // public static void RemoveDuplicates(String str, int idx, StringBuilder st, boolean Arr[]){
    //     if(idx == str.length()){
    //         System.out.println(st);
    //         return ;
    //     }
    //     char currentChar = str.charAt(idx);
    //     if ( Arr[currentChar - 'a'] == true) {
    //         RemoveDuplicates(str, idx+1, st, Arr);
    //     }else{
    //         Arr[currentChar-'a'] = true;
    //         RemoveDuplicates(str, idx+1, st.append(currentChar), Arr);
    //     }
    // }

    // public static int  PairingWays(int n){
    //     if (n== 1||n==2) {
    //         return n;
    //     }
    // return PairingWays(n-1) + (n-1)*PairingWays(n-2);
    // }

    // public static void PrintBinaryStrings(int n,int LastBit, String str){
    //     if(n == 0){
    //         System.out.println(str);
    //         return;
    //     }
    //     PrintBinaryStrings(n-1,0 ,str+"0");

    //     if (LastBit == 0) {
    //         PrintBinaryStrings(n-1, 1, str+"1");
    //     }
    // }

    // public static void PrintKeyOccurences(int i,int arr[], int key){
     
    //     if(i == arr.length){
    //         return;
    //     }

    //     if (key == arr[i]) {
    //         System.out.println(i);
    //     }
    //     PrintKeyOccurences(i+1, arr, key);
    // }

    // public static void NumToString(int n , String arr[]){
        
        
    //     if(n == 0){
    //         return;
    //     } 
    //     int  num = n%10;
    //     System.out.println(arr[num]);     
    //     // here we are getting number for next iteration 1975/10 = 195,195/10 = 19, 19/10 = 1, 9/10 = 0;
    //     NumToString(n/10, arr); 
    // }

    // public static int printLength(String str){
       
    //     if (  str.length()==0) {
    //         return 0;
    //     }
    //     return printLength(str.substring(1))+1;    
    // }

    // public static void towerOFHanoi(int NumberOfRings, String Source, String Helper, String Destination){
      
    //     if (NumberOfRings == 1) {
    //        System.out.println("transfer ring"+ NumberOfRings+ "from" + Source + "to" + Destination); 
    //        return;
    //     }
          
    //     towerOFHanoi(NumberOfRings-1, Source, Destination, Helper);
    //     System.out.println("transfer ring"+ NumberOfRings+ "from" + Source + "to" + Destination); 
    //     towerOFHanoi(NumberOfRings-1, Helper, Source, Destination);
    // }

    // public static int CountSubstrings(String str, int i , int j , int n){
    //     if (n == 1) {
    //         return 1;
    //     }

    //     if (n == 0) {
    //         return 0;
    //     }
    //      // as we know that AUB = (A+B)-(A^B)
    //     int count = CountSubstrings(str, i+1, j, n-1)+ CountSubstrings(str, i, j-1, n-1) - CountSubstrings(str, i+1, j-1, n-2);
    //     if(str.charAt(i) == str.charAt(j)){
    //         count ++;
    //     }
    //     return count;
    // }
    public static void main(String[] args) {
        // // printing numbers in decreasing order using recursion
        // int n =  10;
        // printDecreasingNum(n);

        // int n = 20;
        // printIncreasingNum(n);

        // int n = 5;
        // System.out.println(printFactorialOfNum(n));

        // int n = 3;
        // System.out.println(printSumOfNaturalNum(n));

        // int n = 10;
        // System.out.println(printFibnacci(n));

        // check if array is sorted or not

        // int arr[] = {1,2,5,4,5};
        // System.out.println(checkSorted(arr, 0));

    //     int arr[] = {8,3,6,9,5,10,2,5,3};
    //    FirstOccurence(arr,5, 8);
    //    LastOccurence(arr,5, 8);

    // // calculating power of a number using recursion
    // int x = 2;
    // int i = 10;
    // System.out.println(CalcPow(x,i));
    
    // // optimized approach

    // int x = 2;
    // int i = 5;
    // System.out.println(OptimizedPow(x,i));
    

    // //****IMP Tiling Problem

    // int length = 3;
    // System.out.println(TilingProblem(length));

    ////**IMP */ Remove Duplicates from string 
    // String Str = "appnnacollege";
    // int idx = 0;
    // RemoveDuplicates(Str , idx, new StringBuilder(""), new boolean[26]); 

    // Friends Pairing Problem 
    // Q. Given n friends, each one can remain single or can be paired up with some other friend. Each friend can be paired only once. Find out the total number of ways in which friends can remain single or can be paired up.
        
    // // function explanition in notebook
    // int n = 3;
    // System.out.println(PairingWays(n));
    

    // Q. Binary Strings Problem
    // print all binary strings of size N without consecutive ones

    // int n =3;
    // PrintBinaryStrings(n,0,"");

    // Q. 1) Question1:ForagivenintegerarrayofsizeN.Youhavetofindalltheoccurrences(indices)ofagivenelement(Key)andprintthem.Usearecursivefunctiontosolvethisproblem

    // int arr[] =  {3, 2, 4, 5, 6, 2, 7, 2, 2};
    // int Key = 2;
    // PrintKeyOccurences(0,arr, Key);

    // Question 2 :You are given a number (eg -  2019), convert it into a String of english like“two zero one nine”.  Use a recursive function to solve this problem.NOTE-Thedigitsofthenumberwillonlybeintherange0-9andthelastdigitofanumbercan’t be 0.

    // int n = 1947;
    // String arr[] = {"zero","one","two","three", "four","five","six","seven","eight","nine"};
    // NumToString(n, arr);

    // String Str = "nikhil";
    // System.out.println(printLength(Str));

    // //**IMP  Question 5 :TOWER OF HANOI(Important!)
    // towerOFHanoi(3,"A","B","C");

    // //**IMP Question4:WearegivenastringS,weneedtofindthecountofallcontiguoussubstringsstarting and ending with the same character.Sample Input 1: S = "abcab"Sample Output 1: 7There are 15 substrings of "abcab" : a, ab, abc, abca, abcab, b, bc, bca, bcab, c, ca, cab, a, ab, bOutoftheabovesubstrings,thereare7substrings:a,abca,b,bcab,c,aandb.So,only7contiguous substrings start and end with the same character
    
    // String str = "abcab";
    // int i = 0;
    // int j = str.length()-1;
    // int k = str.length();
    // System.out.println(CountSubstrings( str, i, j ,k));
}
}
    


