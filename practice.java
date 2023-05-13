package mypackage;

public class practice {
    public static void Nqueens(char arr[][], int row){
        // base case 
        if(row == arr.length){
            PrintBoard(arr);
          return;
        }
        // recursion
        for (int j = 0; j < arr.length; j++) {
          if(isSafe(arr, row, j) == true){
            arr[row][j] = 'Q';
            Nqueens(arr, row+1);
            arr[row][j] = 'X'; // backtracking
          } 
        }
    }


    public static boolean isSafe(char arr[][], int row, int col){
      // vertically up
      for (int i = row-1; i >=0; i--) {
        if (arr[i][col] == 'Q') {
          return false;
        }
      }
       
      //left diagonal up
      for (int i = row-1, j = col-1; i >=0 && j>=0; i--, j--) {
        if (arr[i][j] == 'Q') {
          return false;
        }
      }
    
      // right diagonal up
      for (int i = row-1, j = col+1; i >=0 && j<arr.length; i--, j++) {
        if (arr[i][j] == 'Q') {
          return false;
        }
      }
       
       return true;
    }


    public static void PrintBoard(char arr[][]){
        System.out.println("........Board........");
        for (int i = 0; i < arr.length; i++) {
          for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[i][j]);
          }
          System.out.println();
        }
        
  
      }
    public static void main(String[] args) {
        // ** IMP N Queens
    int n = 3;
    char arr[][] = new char[n][n];
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length; j++) {
        arr[i][j] = 'X';
      }
    }
   
    Nqueens(arr, 0);
    }
}
