package mypackage;
public class bitnmanipulation {
    // public static void CheckOddOrEven(int num){
    // int x = num & 1;
    // if (x == 0) {
    // System.out.println("number is even");
    // }
    // else{
    // System.out.println("Number is Odd");
    // }
    // }

    // public static void GetIthBit(int num , int i){
    // int ls = 1<<i;
    // int and = ls&num;
    // if(and == 0){
    // System.out.println("bit at position"+i+" is 0" );
    // }else{
    // System.out.println("bit at position"+i+" is 1" );
    // }
    // }

    // public static int SetIthBit(int num , int i){
    // int x = 1<<i;
    // int setBit = num | x;
    // return setBit;
    // }

    // public static int ClearIthBit(int num , int i){
    // int bitMask = ~(1<<i);
    // int numAfterClear = num & bitMask;
    // return numAfterClear;
    // }

    // public static int UpdateIthBit(int num , int i, int newBit){
    // if (newBit
    // == 0) {
    // return ClearIthBit(num, i);
    // }
    // return SetIthBit(num, i);
    // }

    // public static int ClearLastIbits(int num, int i){
    // return num & ((-1)<<i);
    // }

    // public static int ClearBitsInRange(int num, int i, int j){
    // // for 111100000000
    // int a = (-1<<i+1);
    // // for 000000000011
    // int b = (1<<j)-1;
    // int BitMask = a|b;
    // System.out.println(BitMask);

    // // here we are clearning bits in the range
    // return num & BitMask;
    // }

    // public static Boolean CheckIfPowOfTwo(int n){
    // int x = n& (n-1);
    // if(x == 0){
    // return true;
    // }
    // return false;
    // }

    // public static int CountSetBits(int num){
    //     int count = 0;
    //     while (num > 0){
    //         if( (num & 1) == 0){
    //             num  = num>>1; 
    //         }
    //         else{
    //             count++;
    //             num  = num>>1;  
    //         }
    //     }
    //     return count;
    // }

    // ***IMP
    // public static int FastExponentiation(int a, int i){
    //     int ans = 1;
    //     while(i>0){
    //           if((i & 1<<0) != 0){
    //             ans = ans*a;
    //           }
    //             a = a*a;
    //             i = i>>1;
    //     }
    //     return ans;
    // }

    // BIT MANIPULATION QUESTIONS

    // Question 1 :What is the value of x^x for any valueof x?
    // ans - x^x always gives zero in answer

    // Question 2 :Swap two numbers without using any thirdvariable.

    // public static void SwapNumbers(int x, int y){
    //     System.out.println("Numbers before Swap x and y are" + x+ "," + y + "respectively");
    //     x=x^y;
    //     y=x^y;
    //     x=x^y;
    //     System.out.println("Numbers before Swap x and y are" + x+ "," + y + "respectively");
    // }
        
    // Question 3 :Add 1 to an integer using Bit Manipulation.(Hint: try using Bitwise NOT Operator)

    // public static int AddOne(int n){
    //     int i = 1;
    //     return ((-~i)|(-~n));
    // }

    // Question 4 :This question is based on a trick, pleasedirectly look at the solution.Convert uppercase characters to lowercase using bits.

    public static char ToLowercase(char a){
        
        return (char)(a|' ');
    }

    // Convert uppercase character to lowercasefor
    // for(char ch='A';ch<='Z';ch++) {System.out.println((char)(ch|' '));
    // prints abcdefghijklmnopqrstuvwxyz}}}kumarnikhil2111@gmail.com



    public static void main(String[] args) {
        // Check if Odd or Even
        // int num = 22;
        // CheckOddOrEven(num);

        // int num = 5;
        // int ithposition = 1;
        // GetIthBit(num, ithposition);

        // int num = 10;
        // int ithposition = 2;
        // System.out.println("number after setting the bit is "+ SetIthBit(num,
        // ithposition));

        // int num = 10;
        // int ithposition = 3;
        // System.out.println("number after setting the bit is "+ ClearIthBit(num,
        // ithposition));

        // int num = 10;
        // int ithposition = 3;
        // int newBit = 1;
        // System.out.println("number after setting the bit is "+ UpdateIthBit(num,
        // ithposition, newBit));

        // int num = 15;
        // int i=2;
        // System.out.println(ClearLastIbits(num,i));

        // int i = 7;
        // int j = 2;
        // int num = 2515;
        // // System.out.println(((-1)<<(j+1))| ((int)Math.pow(2, 2) -1) );

        // System.out.println(ClearBitsInRange(num, i, j));

        // int n = 32;
        // System.out.println(CheckIfPowOfTwo(n));

        // int num = 15;
        // System.out.println(CountSetBits(num));


        // int a = 3;
        // int i = 5;
        // System.out.println(FastExponentiation(a,i));

        // int n = 10;
        // System.out.println(AddOne(n));

        // int x = 3;
        // int y = 10;
        // SwapNumbers(x, y);
        
        char a = 'B';
        System.out.println(ToLowercase(a));
    }

}
