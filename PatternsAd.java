
package mypackage;

public class PatternsAd {

    // public static void HollowRectangle(int a, int b){
    //    for (int i = 1; i <=a; i++) {
    //     for (int j = 1; j <=b; j++) {
    //         if (i==a || i==1 || j==b || j==1) {
    //             System.out.print("*");
                
    //         }
    //         else{
    //             System.out.print(" ");
    //         }
    //     }
    //     System.out.println();
    //    }
    // }

    // public static void invertedAndRotatedHalfPyramid(int a){

    //    for (int i = 0; i <a; i++) {
    //     int ch = 1;

    //     for (int j = 0; j <a-i; j++) {
    //         System.out.print(ch);
    //         ch++;
    //     }
    //     System.out.println();

    //    }
    // }


    // public static void FloydTriangle(int a){
    //     int ch = 1;
    //    for (int i = 1; i <=a; i++) {
    //     for (int j = 1; j <=i; j++) {
    //         System.out.print(ch);
    //         ch++;
    //     }
    //     System.out.println();

    //    }
    // }

    // public static void ZeroOneTriangle(int a){
        
    //     for(int i=1;i<=a;i++){
    //         int ch =1;
    //         for (int j = 1; j <=i; j++) {
    //            if ((i+j)%2 == 0) {
    //             System.out.print("1");
    //            } else {
    //             System.out.print("0");
    //            }
    //         }
    //         System.out.println();
    //     }
    // }

    // public static void ButterflyPattern(int a ){
    //     for (int i = 1; i <=a; i++) {
    //         for (int j = 1; j <=i; j++) {
    //             System.out.print("*"); 
    //         }
    //         for (int j = 1; j <=a-i; j++) {
    //             System.out.print("1");
    //         }
    //         for (int j = 1; j <=a-i; j++) {
    //             System.out.print("1"); 
    //         }
    //         for (int j = 1; j <=i; j++) {
    //             System.out.print("*");
    //         }
    //         System.out.println();
    //     }
    //     for (int i = a; i>=1; i--) {
    //         for (int j = 1; j <=i; j++) {
    //             System.out.print("*"); 
    //         }
    //         for (int j = 1; j <=a-i; j++) {
    //             System.out.print("1");
    //         }
    //         for (int j = 1; j <=a-i; j++) {
    //             System.out.print("1"); 
    //         }
    //         for (int j = 1; j <=i; j++) {
    //             System.out.print("*");
    //         }
    //         System.out.println();
    //     }
       
    // }


    public static void main(String[] args) {
        int a = 4;
        int b = 4;
        // HollowRectangle(a, b);
        // invertedAndRotatedHalfPyramid(a);
        // FloydTriangle(a);
        // ZeroOneTriangle(a);
        // ButterflyPattern( a );
    }
}
