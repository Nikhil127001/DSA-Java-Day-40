package mypackage;
import java.util.Arrays;
public class Strings {


    // public static Boolean CheckPalindrome(String str){
    //     int n = str.length()-1;
    //     for (int i = 0; i <= n/2; i++) {
    //         if(str.charAt(i) != str.charAt(n-i)){
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    // Question
    // given a route containing 4 directions (E<W<N<S), find the shortest path to reach destination. "WNEENESENNN"

    // public static double ShortestPAth(String str){
    //     int x = 0;
    //     int y = 0;
    //     for (int i = 0; i < str.length(); i++) {
    //         if (str.charAt(i) == 'E') {
    //             x++;
    //         }
    //         if (str.charAt(i) == 'W') {
    //             x--;
    //         }
    //         if (str.charAt(i) == 'N') {
    //             y++;
    //         }
    //         if (str.charAt(i) == 'S') {
    //             y--;
    //         }
            
    //     }
    //     int result = x*x + y*y;
    //     return Math.sqrt(result);
    // }

    // public static String LargestString(String str[]){
    //     String Largest = str[0];
    //     for (int i = 0; i < str.length; i++) {
    //         if (Largest.compareTo(str[i])<0) {
    //             Largest = str[i];
    //         }
    //     }
    //     return Largest;
    // }

     // public static String ConvertLattersToUpperCase( String str){
    //     StringBuilder sc = new StringBuilder("");
    //     char ch = Character.toUpperCase(str.charAt(0));
    //     sc.append(ch);
    //     for (int i = 1; i < str.length(); i++) {
    //         if (str.charAt(i) == ' ' && i<str.length()-1) {
    //              sc.append(str.charAt(i));
    //             i++;
    //             sc.append(Character.toUpperCase(str.charAt(i)));
    //         }else{
    //             sc.append(str.charAt(i));
                
    //         }
    //     }
    //     return sc.toString();
    // }; 

    // ***IMP

    // public static String StringCompression( String str){
        
    //     StringBuilder sb = new StringBuilder("");
    //     sb.append(str.charAt(0));
    //     int count = 1;
    //     for (int i = 0; i < str.length()-1; i++) {
           
    //         if ( str.charAt(i) == str.charAt(i+1)) {
    //             count++;

    //             if (i == str.length()-2) {
    //                 sb.append(count);
    //             }
    //         }
    //         else{
    //             sb.append(count);
                
               
    //                 sb.append(str.charAt(i+1));
    //             count = 1;
    //             }
                    

    //             }
                
            
        
    //     return sb.toString();
    // }


    // STRINGS QUESTIONS
    // Question1:CounthowmanytimeslowercasevowelsoccurredinaStringenteredbytheuser

    // public static int countVowel(String str){
    //     int count = 0;
    //     for (int i = 0; i <str.length(); i++) {
    //         if(str.charAt(i) == 'a'|| str.charAt(i)=='e'|| str.charAt(i)=='i'|| str.charAt(i)=='o'|| str.charAt(i)=='u'){
    //             count+=1;
    //         }
    //     }
    //   return count;
    // }

    // Question 4 :Determine if 2 Strings areanagramsof each other.What are anagrams?Iftwostringscontainthesamecharactersbutinadifferentorder,theycanbesaidtobeanagrams.Considerraceandcare.Inthiscase,race'scharacterscanbeformedintoastudy,orcare'scharacterscanbeformedintorace.Belowisajavaprogramtocheckiftwostringsare anagrams or not
    

    //** IMP
    //    public static Boolean IsAnagram(String a, String b){
    //     char[] acharArray = a.toCharArray();
    //     char[] bcharArray = b.toCharArray();
    //     Arrays.sort(acharArray);
    //     Arrays.sort(bcharArray);
    //     if (Arrays.equals(acharArray,bcharArray) ) {
    //         return true;
    //     }
    
    //     return false;
    // }

   

    

    
    public static void main(String[] args) {


        // String str = new String("racecar");
        // System.out.println(CheckPalindrome(str));

        // String str = "abeioucdfdgd";
        // System.out.println(countVowel(str)
        // );

        
        // String a = "care";
        // String b = "race";
        // System.out.println(IsAnagram(a,b));

        // String str = "WNEENESENNN";
        // System.out.println(ShortestPAth(str));
        
        // String[] str = {"mango","apple","banana"}; 
        // System.out.println(LargestString(str));
        
        // String str = "hiii my name is nikhil";
        // System.out.println(ConvertLattersToUpperCase(str));
       

        // String sb = "aaabbbccccddeeeeeffgghhii";
        // System.out.println(StringCompression(sb));
        

    }
}
