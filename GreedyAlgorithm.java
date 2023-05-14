package mypackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class GreedyAlgorithm {

    public static void ActivitySelection(int startingTime[], int endingTime[]){
        // // we have given that ending time array is already sorted
        // ArrayList <Integer> arr = new ArrayList<>();
        // int sArrayIdx = 1;
        // int eArrayIdx = 0;
        // int MaxActivities = 1;
        // arr.add(0);

        // for(int i = sArrayIdx; i<startingTime.length-1;i++){
        //     if(endingTime[eArrayIdx]<=startingTime[sArrayIdx]){
        //         eArrayIdx = i;
        //         sArrayIdx++;
        //         MaxActivities++;
        //         arr.add(i);
        //     }
        //     else{
        //         sArrayIdx++;
        //     }
        // }
        // System.out.println("the Max number of Activities are : " + MaxActivities);
        // for(int i =0; i<arr.size(); i++){
        //     System.out.print("A"+arr.get(i));
        // }   

        // when ending time array is not sorted
        // here we are creating 2D array with 3 Columns to store index; starting time and ending time
        int arr[][] = new int[startingTime.length][3];
        // here we are storing them
        for(int i = 0; i<startingTime.length; i++){
            arr[i][0] = i;
            arr[i][1] = startingTime[i];
            arr[i][2] = endingTime[i];
        }

        // here we are sorting 2D array using Arrays.sort and comparators according to ending Array
         Arrays.sort(arr, Comparator.comparingDouble(o -> o[2]));

        int MaxActivities = 0;

        ArrayList <Integer> arrList  = new ArrayList<>();

        MaxActivities = 1;
        arrList.add(arr[0][0]);
        int eArrayIdx = arr[0][2];


        for(int i = 1; i<endingTime.length;i++){
            if(arr[i][1]>= eArrayIdx){
                MaxActivities++;
                arrList.add(arr[i][0]);
                eArrayIdx = arr[i][2];
            }
            
        }
        System.out.println("the Max number of Activities are : " + MaxActivities);
        for(int i =0; i<arrList.size(); i++){
            System.out.print("A"+ arrList.get(i));
        }       
    }
    public static void main (String args[]){
        //**IMP Actitivity Selection Problem

        int startingTime[]  = {1,3,0,5,8,5};
        int endingTime[]  = {2,4,6,7,9,9};

        ActivitySelection(startingTime, endingTime);
    }
}
