package mypackage;

import java.util.*;

public class InbuiltArraylist {

    // public static int ContainerWithMostWater(ArrayList <Integer> List){

    // // iterative Approach
    // // Brute Force Approach
    // int MaxContainer = 0;

    // for (int i = 0; i < List.size(); i++) {
    // for(int j =1; j<List.size(); j++){
    // int width = j-i;
    // int height = Math.min( List.get(i), List.get(j));

    // int area = width*height;

    // MaxContainer = Math.max(MaxContainer, area);
    // }
    // }
    // return MaxContainer;

    // // optimized approach

    // int i = 0;
    // int j = List.size()-1;
    // int MaxVolume =0;
    // int area = 0;

    // while(i<j){
    // int width = j-i;
    // int height = Math.min(List.get(i), List.get(j));
    // area = height*width;
    // MaxVolume = Math.max(MaxVolume,area);
    // if (List.get(i)< List.get(j)) {
    // i++;
    // } else {
    // j--;
    // }
    // }
    // return MaxVolume;
    // }
    // .......................................................
    // public static boolean FindSum(ArrayList <Integer> List){
    // // Brute Force Approach
    // int key = 16;
    // int i = 0;
    // int j = List.size()-1;
    // for (int i = 0; i < List.size(); i++) {
    // for(int j = 1; j <List.size();j++){
    // int sum = List.get(i)+ List.get(j);
    // if (sum == key) {
    // return true;
    // }
    // }
    // }

    // // optimized two pointer approach
    // while(i!=j){

    // if (List.get(i)+ List.get(j) == key) {
    // return true;
    // }
    // if (List.get(i)+ List.get(j) < key)
    // {
    // i++;
    // }
    // else{
    // j--;
    // }

    // }

    // // pair sum 2
    // // brute force approach is same as pair sum 1
    // // optimized approach two pointer using modular arithmetic to traverse
    // int key = 16;
    // int bp = -1;
    // int n = List.size();
    // // to find pivot and i and j
    // for (int i = 0; i < List.size(); i++) {
    // if (List.get(i)> List.get(i+1)) {
    // bp = i;
    // break;
    // }
    // }
    // int i = bp+1;
    // int j = bp;

    // while (i != j) {
    // int sum = List.get(j) + List.get(i);
    // if(sum == key){
    // return true;
    // }
    // if (sum>key) {
    // j = (n+j-1)%n;

    // } else {
    // i = (i+1)%n;
    // }
    // }

    // return false;
    // }
    // ......................................................

    // public static boolean CheckMonotonic(ArrayList <Integer> List ){
    // boolean inc = true;
    // boolean dec = true;
    // for (int i = 0; i < List.size()-1; i++) {
    // if (List.get(i) <= List.get(i+1) ) {
    // dec = false;
    // }
    // if (List.get(i)>= List.get(i+1)) {
    // inc = false;
    // }
    // }
    // return inc||dec;
    // }

    // // brute force approach
    // public static ArrayList findLonelyNumbers(ArrayList <Integer> List){
    //     ArrayList <Integer>  Solution = new ArrayList<>();
    //   for (int i = 0; i < List.size(); i++) {
    //     for (int j = i+1; j < List.size(); j++) {
    //         if (List.get(j) == List.get(i)+1 || List.get(j) == List.get(i)-1 || List.get(j) == List.get(i)) {
    //             List.remove(j);
    //             List.remove(i);
    //         } 
    //     }
    //     Solution.add(List.get(i));  
    //   }
    //   return Solution;
    // }

    // public static int mostFrequent(ArrayList<Integer> nums, int key) {
    //     int[]result = new int[1000];
    //     for(int i=0; i<nums.size()-1; i++){
    //     if(nums.get(i) == key){
    //     result[nums.get(i+1)-1]++;
    //     }
    //     }
    //     int max = Integer.MIN_VALUE;
    //     int ans = 0;
    //     for(int i=0; i<1000; i++){
    //     if(result[i] > max){
    //     max = result[i];
    //     ans = i+1;
    //     }
    //     }
    //     return ans;
    //     }
        

    public static void main(String[] args) {

        // // print Reverse of an arrayList

        // ArrayList <Integer> list = new ArrayList<>();
        // for (int i = 1; i <=5; i++) {
        // list.add(i);
        // }
        // for (int i = list.size()-1; i >=0; i--) {
        // System.out.print(list.get(i)+ " ");
        // }

        // // find Maximum in an ArrayList

        // ArrayList<Integer> list = new ArrayList<>();
        // for (int i = 1; i <= 5; i++) {
        // list.add(i);
        // }
        // int max = Integer.MIN_VALUE;
        // for (int i = 0; i < list.size(); i++) {
        // max = Math.max(max,list.get(i));
        // }
        // System.out.println(max);

        // // Swap two Numbers
        // ArrayList<Integer> list = new ArrayList<>();
        // for (int i = 1; i <= 5; i++) {
        // list.add(i);
        // }
        // int idx1 = 0;
        // int idx2 = 1;
        // int temp = list.get(idx1);
        // list.set(idx1, list.get(1));
        // list.set(idx2,temp);

        // System.out.println(list);

        // // to sort an arraylist we use

        // Collections.sort(list, Collections.reverseOrder());
        // System.out.println(list);

        // // Implementation of 2D arraylist

        // ArrayList <ArrayList<Integer>> Mainlist = new ArrayList<>();
        // ArrayList <Integer> list1 = new ArrayList<>();
        // ArrayList <Integer> list2 = new ArrayList<>();
        // for (int i = 0; i < 5; i++) {
        // list1.add(1*i);
        // list2.add(2*i);
        // }
        // Mainlist.add(list1);
        // Mainlist.add(list2);

        // // traversing 2D arraylist

        // for (int i = 0; i < Mainlist.size(); i++) {
        // ArrayList <Integer> currentList = new ArrayList<>(Mainlist.get(i));
        // for (int j = 0; j < currentList.size(); j++) {
        // System.out.print(currentList.get(j)+ " ");
        // }
        // System.out.println();
        // }

        // //** IMP Container With Most Water
        // ArrayList <Integer> List = new ArrayList<>();
        // List.add(1);
        // List.add(8);
        // List.add(6);
        // List.add(2);
        // List.add(5);
        // List.add(4);
        // List.add(8);
        // List.add(3);
        // List.add(7);
        // System.out.println(ContainerWithMostWater(List));

        // // Find if any pair in a Sorted ArrayLIst has a target sum.

        // ArrayList <Integer> List = new ArrayList<>();

        // List.add(6);
        // List.add(8);
        // List.add(9);
        // List.add(10);
        // List.add(11);
        // List.add(15);
        // System.out.println( FindSum(List));

        // // Find if any pair in a Sorted and rotated ArrayLIst has a target sum.

        // ArrayList <Integer> List = new ArrayList<>();
        // List.add(11);
        // List.add(15);
        // List.add(6);
        // List.add(8);
        // List.add(9);
        // List.add(10);
        // System.out.println( FindSum(List));



        // // Question 1 :
        // // Monotonic ArrayList (EASY)
        // // An Arraylist is monotonic if it is either monotone increasing or monotone decreasing.
        // // An Arraylist nums is monotone increasing if for all i <= j, nums.get(i) <= nums.get(j). An
        // // Arraylist nums is monotone decreasing if for all i <= j, nums.get(i) >= nums.get(j).
        // // Given an integer Arraylist nums, return true if the given list is monotonic, or false otherwise.
        // // Sample Input 1 : nums = [1,2,2,3]
        // // Sample Output 1 : true
        // // Sample Input 2 : nums = [6,5,4,4]
        // // Sample Output 2 : true
        // // Sample Input 3 : nums = [1,3,2]
        // // Sample Output 3 : false
        // // Constraints :
        // // ● 1 <= nums.size() <= 105
        // // ● -105 <= nums.get(i) <= 105

        // ArrayList <Integer> List = new ArrayList<>();
        // List.add(1);
        // List.add(3);
        // List.add(4);
        // List.add(8);
        // List.add(9);
        // List.add(10);
        // System.out.println( CheckMonotonic(List));

//Question 2 :
// Lonely Numbers in ArrayList (MEDIUM)
// You are given an integer arraylist nums. A number x is lonely when it appears only once, and
// no adjacent numbers (i.e. x + 1 and x - 1) appear in the arraylist.
// Return all lonely numbers in nums. You may return the answer in any order.
// Sample Input 1 : nums = [10,6,5,8]
// Sample Output 1 : [10,8]
// Explanation :
// - 10 is a lonely number since it appears exactly once and 9 and 11 does not appear in nums.
// - 8 is a lonely number since it appears exactly once and 7 and 9 does not appear in nums. 
// - 5 is not a lonely number since 6 appears in nums and vice versa.
// Hence, the lonely numbers in nums are [10, 8].
// Note that [8, 10] may also be returned.

// ArrayList <Integer> List = new ArrayList<>();
//         List.add(1);
//         List.add(5);
//         List.add(2);
//         List.add(10);
//         // List.add(3);
//         // List.add(10);
        
//         System.out.println(findLonelyNumbers(List));

// Question 3 :
// Most Frequent Number following Key (EASY)
// You are given an integer Arraylist nums. You are also given an integer key, which is present in
// nums.
// For every unique integer target in nums, count the number of times target immediately follows
// an occurrence of key in nums. In other words, count the number of indices i such that:
// 0 <= i <= nums.size() - 2,
// nums.get(i) == key and,
// nums.get(i+1) == target.
// Return the target with the maximum count.
// (Assumption - that the target with maximum count is unique.)
// Sample Input 1 :nums = [1,100,200,1,100], key = 1
// Sample Output 1 : 100
// Explanation :
// For target = 100, there are 2 occurrences at indices 1 and 4 which follow an occurrence of key.
// No other integers follow an occurrence of key, so we return 100. kumarnikhil2111@gmail.com
// Sample Input 2 : nums = [2,2,2,2,3], key = 2
// Sample Output 2 : 2
// Explanation :
// For target = 2, there are 3 occurrences at indices 1, 2, and 3 which follow an occurrence of key.
// For target = 3, there is only one occurrence at index 4 which follows an occurrence of key.
// target = 2 has the maximum number of occurrences following an occurrence of key, so we
// return 2.
// Constraints :
// ● 2 <= nums.size() <= 1000
// ● 1 <= nums.get(i) <= 1000
// ● Assume that the answer is unique.
// Hints : Count the number of times each target value follows the key in the arraylist.
// Choose the target with the maximum count and return it.

// ArrayList <Integer> List = new ArrayList<>();
//         List.add(1);
//         List.add(100);
//         List.add(2);
//         List.add(1);
//         List.add(100);
//         List.add(14);
        
//         System.out.println(mostFrequent(List,1));


    }
}
