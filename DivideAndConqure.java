package mypackage;

public class DivideAndConqure {
    public static void mergeSort(int arr[], int si, int ei){
      int mid = (si+ei)/2;
      if (si>=ei) {
        return;
      }
      mergeSort(arr, si, mid); // left part
      mergeSort(arr, mid+1, ei); // left part
      merge(arr,si,mid, ei);
    }

    public static void merge(int arr[], int si,int mid,int ei){
        // here we are creating new temperory array
        int temp[] = new int[ei-si+1];
        int  i = si;// starting index of first part
        int j =  mid+1; // starting index of second part
        int k = 0;
        while(i<= mid & j<= ei){
        if(arr[i] < arr[j]){
            temp[k] = arr[i];
            i++;
            
        }
        else{
            temp[k] = arr[j];
            j++;
            
        }
        k++;
    }
    // for some left over items in array
    while(i<= mid){
        temp[k++] = arr[i++];
    }
    while(j<= ei){
        temp[k++] = arr[j++];
    }

    for (int k2 = 0, l = si; k2 < temp.length; k2++,l++) {
        arr[l] = temp[k2];
    }
    }

    public static void printArr(int Arr[]){
        for (int i = 0; i < Arr.length; i++) {
            System.out.print(Arr[i]);
        }
    }
    public static void main(String[] args) {
        
        int arr[] = {2,5,8,10,1,3,4};

        mergeSort( arr, 0, arr.length-1);
        printArr(arr);
    }

}
