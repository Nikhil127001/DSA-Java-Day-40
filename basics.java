package mypackage;
public class basics {
    public static void main(String args[]){
    //   System.out.println("hello");
    //   int a = 5;
    //   int b = --a;
    //   int sum  = a+b;
    //   System.out.println(sum);

       int reverse = 0;
       int n = 99801;
       while(n>0){
        int lastDigit = n%10;
        reverse = (reverse*10) + lastDigit;
        n = n/10;
       }
       System.out.println(reverse);
    }
}
