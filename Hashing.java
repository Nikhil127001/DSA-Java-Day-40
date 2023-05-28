import java.util.HashMap;
import java.util.*;

public class Hashing {

    public static void majourityelem(int nums[], HashMap<Integer, Integer> hm) {
        // traverse through an array and put the elements in the Hashmap with their
        // occurence as value.
        for (int i = 0; i < nums.length; i++) {
            // if the element is in the hashmap
            if (hm.containsKey(nums[i])) {
                hm.put(nums[i], hm.get(nums[i]) + 1);
            } else {
                // if not exists
                hm.put(nums[i], 1);
            }
        }

    }

    public static boolean ValidAnagram(String a, String b) {
        HashMap<Character, Integer> hm = new HashMap<>();
        // base case;
        if (a.length() != b.length()) {
            return false;
        }

        // first put all the characters in the hashmap with their occurences as value
        for (int i = 0; i < a.length(); i++) {
            // if the char arrives multiple times
            if (hm.containsKey(a.charAt(i))) {
                hm.put(a.charAt(i), hm.get(a.charAt(i)) + 1);
            } else {
                hm.put(a.charAt(i), 1);
            }
        }

        // then traverse through the second string

        for (int j = 0; j < b.length(); j++) {
            // if the character at second string is inthe hashmap then decrease it value by
            // one\
            char ch = b.charAt(j);

            if (hm.get(ch) != null) {

                if (hm.get(ch) == 1) {
                    hm.remove(ch);
                } else {
                    // if the get ch ! = 1 and not == null
                    hm.put(ch, hm.get(ch) - 1);
                }
            }
        }
        // if at last the hm is empty then return true
        if (hm.isEmpty()) {
            return true;
        }

        return false;

    }
    public static String findStart(HashMap<String, String> fromto){
        HashMap <String, String> tofrom = new HashMap<>();

        for(String key : fromto.keySet()){
            tofrom.put(fromto.get(key), key);
        }

        String start = "";
        Set<String> st = fromto.keySet();
        for(String s : st){
            if(!tofrom.containsKey(s)){
                start = s;
            }
        }
        return start;
    }
    public static void main(String[] args) {
        // // hashmap implementation
        // HashMap <String,Integer> hm = new HashMap<>();
        // hm.put("india", 150);
        // hm.put("China", 120);
        // hm.put("uk", 50);
        // hm.put("usa", 60);
        // hm.put("russia", 100);

        // // traversal on hashmap we use set here
        // Set<String> key = hm.keySet();

        // for(String k : key){
        // System.out.println("the population of "+ k +" is "+ hm.get(k));

        // }
        // HashMap<Integer, Integer> hm = new HashMap<>();
        // // Majourity elements
        // int nums[] = { 1, 3, 2, 5, 1, 3, 1, 5, 1, 3, 3 };
        // int boundary = nums.length / 3;

        // majourityelem(nums, hm);

        // // traverse through the hashmap
        // Set<Integer> key = hm.keySet();
        // for (Integer k : key) {
        //     if (hm.get(k) > boundary) {
        //         System.out.print(" " + k);
        //     }
        // }

        // // ** IMP valid Anagram
        // String str1 = "nonu";
        // String str2 = "nunh";
        // System.out.print(ValidAnagram(str1, str2));



        //**** */ Hashset


        // // union and intersaction in HashSet

        // int arr1[] = {7,3,9};
        // int arr2[] = {6,3,9,2,9,4};
        // HashSet <Integer> h = new HashSet<>();

        // // to calculate union put all the elements of both the arrays in the Hashset then find the size of the Hashset

        // int j =0; int i =0;
        // while (i != arr1.length ){
        //     h.add(arr1[i]);
        //     i++;
        // }
        // while(j != arr2.length){
        //     h.add(arr2[j]);
        //     j++;
        // }

        // System.out.println("the union count is " + h.size());
        // h.clear();
        // i = 0;
        // // to calculate intersection 

        // // first put all the elements of arr1 in  hashset
        // while (i != arr1.length ){
        //     h.add(arr1[i]);
        //     i++;
        // }

        // // now check that is if the elements in the hashset are same as the elemnts in arr2
        // // if true the increase count by 1
        // int count  = 0;

        // for(int y =0; y<arr2.length; y++){
        //     if(h.contains(arr2[y])){
        //         count = count+ 1;
        //         System.out.print(arr2[y]);
        //     }
        //        h.remove(arr2[y]);
            
        // }
        // System.out.print("the intersection count is "+ count );     
        
        // travel itenary problem
        HashMap <String, String> fromto = new HashMap<>();

        fromto.put("Chennai", "Bengaluru");
        fromto.put("Mumbai", "Delhi");
        fromto.put("Goa", "Chennai");
        fromto.put("Delhi", "Goa");

        String Start = findStart(fromto);
        // here we got start -> Mumbai
        System.out.print(Start );
        while(fromto.containsKey(Start)){
            System.out.print( "->"+fromto.get(Start));
            Start = fromto.get(Start);
        }
    }
}
