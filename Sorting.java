package mypackage;
import java.util.Arrays;
public class Sorting {

    // public static void BubbleSort(int arr[]) {
    //     for (int i = 0; i < arr.length - 1; i++) {
    //         for (int j = 0; j < arr.length - 1 - i; j++) {
    //             if (arr[j] > arr[j + 1]) {
    //                 int temp = arr[j];
    //                 arr[j] = arr[j + 1];
    //                 arr[j + 1] = temp;

    //             }
    //         }
           
    //     }
    //     for (int j = 0; j < arr.length; j++) {
    //         System.out.println(arr[j]);
    //     }
        
    // }

    // public static void SelectionSort(int arr[]){
        
    //         for(int i = 0; i<arr.length-1;i++){
    //             int MinNumIndex = i;
    //             for(int j = i+1; j<arr.length;j++){
    //                 if (arr[MinNumIndex]> arr[j]) {
    //                     MinNumIndex = j;
    //                 }
    //             }
    //             int temp = arr[i];
    //             arr[i] = arr[MinNumIndex];
    //             arr[MinNumIndex] = temp;  
    //         }
    //         for (int i = 0; i < arr.length-1; i++) {
    //             System.out.println(arr[i]);
    //         }       
    // }


        // public static void InsertionSort(int arr[]){
            
        //     for(int i=1; i<arr.length;i++){
        //         int curr = arr[i];
        //         int prev = i-1;
        //         while(prev>=0 && arr[prev]>curr){
        //             // here we are finding the correct place
        //             arr[prev+1] = arr[prev];
        //             prev--; 
        //         }
        //         // here we are inserting the number
        //         arr[prev+1] = curr;
                    
        //         }
        //     }


        public static void printArray(int arr[]){
            for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
            }
        }

        public static void CountingSort(int arr[],int Max){
            // creating new Array
           int [] Arr = new int[Max];
           //Traversing old Array and updating new Array with Count
            for(int i=0; i<arr.length;i++){
                for (int j = 0; j < Arr.length; j++) {
                    if (arr[i] == j) {
                        Arr[j] += 1;
                    }
                }
            }
            //Traversing New Array and updating old Array
            int j = 0;
            for (int i = 0; i < Arr.length; i++) {
                while(Arr[i]>0){
                    arr[j] = i;
                    j++;
                    Arr[i]--;
                }
            }
        }
        
    public static void main(String[] args) {
        // int arr[] = { 5, 4, 7, 6, 3, 8, 1 };
        // BubbleSort(arr);


        // int arr[] = { 5, 4, 7, 6, 3, 8, 1 };
        // SelectionSort(arr);


        // int arr[] = { 5, 4, 7, 6, 3, 8, 1 };
        // InsertionSort(arr);
        // for (int i = 0; i < arr.length; i++) {
        //             System.out.println(arr[i]);
        //         }
        
        // Inbuilt Sorting
        // int arr[] = { 5, 4, 7, 6, 3, 8, 1 };
        // Arrays.sort(arr);
        // printArray(arr);

        int arr[] = {1,2,1,2,3,3,4,5,1,2,3,4,1,2,3,4,1,2,3,4};
        CountingSort(arr,6);
        printArray(arr);

        
    }
}
