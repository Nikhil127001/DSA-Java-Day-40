package mypackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class GreedyAlgorithm {

    public static void ActivitySelection(int startingTime[], int endingTime[]) {
        // // we have given that ending time array is already sorted
        // ArrayList <Integer> arr = new ArrayList<>();
        // int sArrayIdx = 1;
        // int eArrayIdx = 0;
        // int MaxActivities = 1;
        // arr.add(0);

        // for(int i = sArrayIdx; i<startingTime.length-1;i++){
        // if(endingTime[eArrayIdx]<=startingTime[sArrayIdx]){
        // eArrayIdx = i;
        // sArrayIdx++;
        // MaxActivities++;
        // arr.add(i);
        // }
        // else{
        // sArrayIdx++;
        // }
        // }
        // System.out.println("the Max number of Activities are : " + MaxActivities);
        // for(int i =0; i<arr.size(); i++){
        // System.out.print("A"+arr.get(i));
        // }

        // when ending time array is not sorted
        // here we are creating 2D array with 3 Columns to store index; starting time
        // and ending time
        int arr[][] = new int[startingTime.length][3];
        // here we are storing them
        for (int i = 0; i < startingTime.length; i++) {
            arr[i][0] = i;
            arr[i][1] = startingTime[i];
            arr[i][2] = endingTime[i];
        }

        // here we are sorting 2D array using Arrays.sort and comparators according to
        // ending Array
        Arrays.sort(arr, Comparator.comparingDouble(o -> o[2]));

        int MaxActivities = 0;

        ArrayList<Integer> arrList = new ArrayList<>();

        MaxActivities = 1;
        arrList.add(arr[0][0]);
        int eArrayIdx = arr[0][2];

        for (int i = 1; i < endingTime.length; i++) {
            if (arr[i][1] >= eArrayIdx) {
                MaxActivities++;
                arrList.add(arr[i][0]);
                eArrayIdx = arr[i][2];
            }

        }
        System.out.println("the Max number of Activities are : " + MaxActivities);
        for (int i = 0; i < arrList.size(); i++) {
            System.out.print("A" + arrList.get(i));
        }
    }

    public static void KnapsackProblem(int[] val, double MaxWeight, int[] weight) {
        // creating 2D array for the fields Val,Weight And their indexes

        double arr[][] = new double[val.length][3];
        double ratio[] = new double[val.length];

        for (int i = 0; i < ratio.length; i++) {
            ratio[i] = val[i] / weight[i];
        }

        for (int i = 0; i < val.length; i++) {
            arr[i][0] = (int) ratio[i];
            arr[i][1] = val[i];
            arr[i][2] = weight[i];
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

        // now here i am sorting the arr using camparator
        Arrays.sort(arr, Comparator.comparingDouble(o -> o[0]));
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

        double profit = 0;

        for (int i = val.length - 1; i >= 0; i--) {
            // checking if the weight to be inserting in the bag is less then or equal
            // MaxWeight Required
            if (arr[i][2] <= MaxWeight) {
                profit = profit + arr[i][1];
                MaxWeight = MaxWeight - arr[i][2];
            } else {
                // if the weight to be insert is greater than the max weight required then we
                // have to insert its fractional part

                profit = profit + arr[i][0] * MaxWeight;
                break;
            }

        }
        System.out.print((int) profit);
    }

    public static void SumOfMinAbDiff(int A[], int B[]) {// T.C = O(nlogn) because of sorting
        // first sort both the arrays
        Arrays.sort(A);
        Arrays.sort(B);

        int minDiff = 0;

        for (int i = 0; i < A.length; i++) {
            minDiff = minDiff + Math.abs(A[i] - B[i]);
        }
        System.out.print(minDiff);
    }

    public static void LongestChainFormed(int a[], int b[]) {
        int arr[][] = new int[a.length][2];

        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = a[i];
            arr[i][1] = b[i];
        }

        // here i am sorting the array using first column of arr
        Arrays.sort(arr, Comparator.comparingDouble(o -> o[0]));

        // at first initiate the length to 1.
        int length = 1;
        int bidx = 0;
        for (int i = 1; i < arr.length; i++) {
            // check is the element in b is is less then the element in a
            if (arr[bidx][1] <= arr[i][0]) {
                bidx = i; // change the index of b to i(the current elements ending number)
                // index.add(i); // add the index to the arraylist(Index)
                length++; // increase the length
            }
        }
        System.out.print(length);

    }

    public static void MinNumCoins(Integer[] coins, int v) {
        Arrays.sort(coins, Comparator.reverseOrder()); // comparator and Collections always work on Arrays created from
                                                       // Integer class
        int count = 0;

        for (int i = 0; i < coins.length; i++) {
            // if the value at idx is less than the v then include it otherwise move to the
            // next index of array
            while (coins[i] <= v) {
                v = v - coins[i];
                System.out.println(coins[i]);
                count++;
            }

        }

        System.out.print(count);

    }

    public static void MinCost(Integer[] HorCost, Integer[] VerCost) {

        Arrays.sort(HorCost, Collections.reverseOrder());
        Arrays.sort(VerCost, Collections.reverseOrder());


        int idx1 = 0; // horcost idx
        int idx2 = 0; // vercost index
        int cost = 0; // cost
        int horPiece = 1;
        int verPiece = 1;

        while (idx1 < HorCost.length && idx2 < VerCost.length) {
            // calculate cost
            if (VerCost[idx2] <= HorCost[idx1]) {
                cost += (HorCost[idx1] * verPiece);
                horPiece++;
                idx1++;
            } else {
                cost += (VerCost[idx2] * horPiece);
                verPiece++;
                idx2++;
            }
        }
        while (idx1 < HorCost.length) {
            
            cost += (HorCost[idx1] * verPiece);
            horPiece++;
            idx1++;
        }
        while (idx2 < VerCost.length) {
            
            cost += (VerCost[idx2] * horPiece);
            verPiece++;
            idx2++;
        }
        System.out.print(cost);
    }

    

    public static void main(String args[]) {
        // //**IMP Actitivity Selection Problem

        // int startingTime[] = {1,3,0,5,8,5};
        // int endingTime[] = {2,4,6,7,9,9};

        // ActivitySelection(startingTime, endingTime);

        // // Knapsak Problem
        // int val[] = {60,100,120};
        // int weight[] = {10,20,30};
        // double w = 50;

        // KnapsackProblem(val, w, weight);

        // // Sum of Min absolute difference in A and B
        // int A[] = {4,1,8,7};
        // int B[] = {2,3,6,5};

        // SumOfMinAbDiff(A,B);

        // // LongestchainProblem

        // int A[] = {5,39,5,27,50};
        // int B[] = {24,60,28,40,90};

        // LongestChainFormed(A,B);

        // // Indian Coins

        // Integer[] Coins = {1,2,5,10,20,50,100,500,2000};
        // int V = 1059;

        // // Min Number Of Coins coins requires to make the value V

        // MinNumCoins(Coins,V);

        // //**IMP Chocola Problem

        // Integer HorCost[] = { 4, 1, 2 };
        // Integer VerCost[] = { 2, 1, 3, 1, 4 };

        // MinCost(HorCost, VerCost);

    }
}
