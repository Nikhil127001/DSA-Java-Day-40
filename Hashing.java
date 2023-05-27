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
    }
}
