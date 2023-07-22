package mypackage;
public class Arrays {

    // public static int LargestNumber(int Array[]){
    // int Greatest = Integer.MIN_VALUE;
    // for (int j = 0; j < Array.length; j++) {
    // if (Greatest<Array[j]) {
    // Greatest = Array[j];

    // }
    // }
    // return Greatest;

    // }

    // public static Boolean BinarySearch(int Array[], int key){
    // int start = 0;
    // int end = Array.length-1;

    // for (int i = 0; i < Array.length; i++) {
    // int Mid = (start+end)/2;

    // if (Array[Mid] == key) {
    // return true;
    // }
    // if (Array[Mid]<key) {
    // start = Mid+1;

    // }
    // else{
    // end = Mid-1;
    // }

    // }

    // return false;
    // }

    // public static void ReaverseAnArray(int Array[]){
    // int Temp = 0;
    // int start = 0;
    // int end = Array.length-1;
    // while (end > start) {
    // Temp = Array[end];
    // Array[end] = Array[start];
    // Array[start] = Temp;
    // end--;
    // start++;
    // }
    // }

    // public static void PairsinArray(int Array[]){
    // for (int i = 0; i < Array.length; i++) {
    // for (int j = i+1; j < Array.length; j++) {
    // System.out.print("(" + Array[i] + ","+ Array[j] + ")"+ " ");
    // }
    // }
    // }

    // public static void SubArrays(int Array[]) {

    //     for (int i = 0; i < Array.length; i++) {
    //         for (int j = i; j < Array.length; j++) {
                
    //             for (int k = i; k <= j; k++) {
    //                 System.out.print(Array[k] + ' ');
    //             }
    //             System.out.println();

    //         }
    //         System.out.println();

    //     }
    // }

    // public static int KadansMaxSubArraySum(int Array[]){
    //       int MS = Integer.MIN_VALUE;
    //       int CS = 0;

    //       for (int i = 0; i < Array.length; i++) {
    //         CS = CS += Array[i];
    //         if (CS <0) {
    //             CS = 0;
    //         }

    //         else{
    //             MS = Math.max(CS, MS);
    //         }
    //         if (MS < 0) {
    //             for (int j = 0; j < Array.length; j++) {
    //                 MS = Math.max(Array[i], MS);
    //             }
    //         }

    //       }

    //     return MS;
    // }

    // public static int TrappingRainWater(int height[]){
    //     int trappedWater = 0;
    //     int n = height.length;
    //     int leftMax[] = new int[n];
    //     int rightMax[] = new int[n];
    //     leftMax[0] = height[0];
    //     rightMax[n-1] = height[n-1];
    //     for (int i = 1; i < n; i++) {
    //         leftMax[i] = Math.max(height[i], leftMax[i-1]);
    //     }

    //     for (int i = n-2; i >=0; i--) {
    //         rightMax[i] = Math.max(rightMax[i+1], height[i]);

    //     }
    //     for (int i = 0; i < rightMax.length; i++) {

    //         int waterLevel = Math.min(leftMax[i], rightMax[i]);

    //         trappedWater += (waterLevel-height[i]);
    //     }
    //     return trappedWater;
    // }

    // public static int MaxProfit(int price[]){
    //     int PurchasingPrice = Integer.MAX_VALUE;
    //     int MaxProfit = 0;
    //     for(int i=0; i<price.length;i++){
    //         if(PurchasingPrice<price[i]){
    //             int profit = price[i] - PurchasingPrice;
    //             MaxProfit = Math.max(MaxProfit,profit);
    //         }
    //         else{
    //             PurchasingPrice = price[i];
    //         }

    //     }
    //     return MaxProfit;
    // }

    public static void BubbleSort(int arr[]){

    }

    public static void main(String[] args) {
        // int Array[] = { -2,-3,-2,-1,-2,-7,-8,-3,0};
        // int key = 1;
        // System.out.println(LargestNumber(Array));
        // System.out.println(BinarySearch(Array, key)
        // );
        // ReaverseAnArray(Array);

        // for (int i = 0; i < Array.length; i++) {
        // System.out.print(Array[i]);
        // }
        // PairsinArray(Array);
        // SubArrays(Array);

        // ** IMP
        
        // System.out.println( KadansMaxSubArraySum(Array)
        // );


        // int height[] = {4,2,0,6,3,2,5};
        // System.out.println(TrappingRainWater(height));


        // int price[] = {7,1,5,3,6,4};
        // System.out.println(MaxProfit(price));
        
        int arr[] = {5,6,7,3,2,1};
        BubbleSort(arr);
    }
}
