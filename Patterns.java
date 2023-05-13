package mypackage;
public class Patterns {
    public static void main(String[] args) {
        char ch = 'A';
        int b= (int)ch;
        int n = 5;

        for(int i=1;i<=n; i++){
            for(int j=1;j<=i;j++){
                System.out.print((char)b);
                b++;
            }
            System.out.println(" ");
          
        }
        
    }
    
}
