package mypackage;

import javax.print.event.PrintEvent;

public class Backtracking {

  // public static void ChangeArray(int Arr[], int idx, int val){
  // // Base
  // if (idx == Arr.length) {
  // printArray(Arr);
  // return;
  // }
  // // Kaam
  // Arr[idx] = val;
  // // recursion
  // ChangeArray(Arr, idx+1, val+1);

  // // Backtracking
  // Arr[idx] = Arr[idx]-2;
  // }

  // // T.C. = O(n)
  // // S.C. = O(1)

  // public static void printArray(int Arr[]){
  // for (int i = 0; i < Arr.length; i++) {
  // System.out.print(Arr[i]);
  // }
  // System.out.println();
  // }

  // public static void Subsets(String Str, int idx, String Ans){
  // // base Case
  // if (idx == Str.length()) {
  // if (Ans.length() == 0) {
  // System.out.println("null");
  // }
  // System.out.println(Ans);
  // return;
  // }

  // // recursion
  // Subsets(Str, idx+1, Ans+Str.charAt(idx));
  // // backtracking
  // Subsets(Str, idx+1, Ans);
  // }

  // public static void FindPermutations(String Str, String Ans ){
  // // Base Case
  // if(Str.length() == 0){
  // System.out.println(Ans);
  // return;
  // }
  // // recursion
  // for (int i = 0; i <Str.length(); i++) {
  // String NewStr = Str.substring(0, i) + Str.substring(i+1);
  // FindPermutations(NewStr, Ans+ Str.charAt(i));
  // }
  // }

  // public static void Nqueens(char arr[][], int row){
  // // base case
  // if(row == arr.length){
  // PrintBoard(arr);
  // return;
  // }
  // // recursion
  // for (int j = 0; j < arr.length; j++) {
  // if(isSafe(arr, row, j) == true){
  // arr[row][j] = "Q";
  // Nqueens(arr, row+1);
  // arr[row][j] = "X"; // backtracking
  // }
  // }
  // }

  // public static boolean isSafe(char arr[][], int row, int col){
  // // vertically up
  // for (int i = row-1; i >=0; i--) {
  // if (arr[i][col] == "Q") {
  // return false;
  // }
  // }

  // //left diagonal up
  // for (int i = row-1, j = col-1; i >=0 && j>=0; i--, j--) {
  // if (arr[i][j] == "Q") {
  // return false;
  // }
  // }

  // // right diagonal up
  // for (int i = row-1, j = col+1; i >=0 && j<arr.length; i--, j++) {
  // if (arr[i][j] == "Q") {
  // return false;
  // }
  // }

  // return true;
  // }

  // public static void PrintBoard(char arr[][]){
  // System.out.println("........Board........");
  // for (int i = 0; i < arr.length; i++) {
  // for (int j = 0; j < arr.length; j++) {
  // System.out.print(arr[i][j]);
  // }
  // System.out.println();
  // }

  // }

  // public static int GridWays(int i, int j , int n , int m){
  // // Base Case
  // if(i == n-1 && j == m-1){
  // return 1;
  // }
  // else if( i == n || j == m){
  // return 0;
  // }
  // int W1 = GridWays(i, j+1, n, m);
  // int W2 = GridWays(i+1, j, n, m);
  // return W1+W2;
  // }
  // //
  // ..........................................................................................................
  // public static Boolean SudokuSolver(int Sudoku[][], int row, int col){
  // // base case
  // if(row == 9){
  // return true;
  // }

  // // recursion
  // int nextrow = row; int nextCol = col+1;
  // if(col+1 == 9){
  // nextrow = row +1;
  // nextCol = 0;
  // }
  // // checking if the element is not equal to zero, if it is then call to the
  // next level
  // if (Sudoku[row][col] != 0) {
  // return SudokuSolver(Sudoku, nextrow, nextCol);
  // }

  // // if the element is equal to zero then
  // for (int digit = 1; digit <= 9; digit++) {
  // if(isSafe( Sudoku, row , col, digit )){ // checking if it is safe to place a
  // digit or not
  // Sudoku[row][col] = digit;
  // if (SudokuSolver(Sudoku, nextrow, nextCol)) { // solution exist
  // return true;
  // }
  // Sudoku[row][col] = 0;
  // }

  // }
  // return false;
  // }

  // public static Boolean isSafe(int Sudoku[][], int row, int col , int digit){
  // // check condition for row
  // for (int i = 0; i < 9; i++) {
  // if (Sudoku[i][col]== digit) {
  // return false;
  // }
  // }

  // // check condition for column
  // for (int i = 0; i < 9; i++) {
  // if (Sudoku[row][i]== digit) {
  // return false;
  // }
  // }
  // // checking condition for the small 3X3 Matrix

  // int x = (row/3)*3; // finding x coordinate for the matrix related to the num
  // at (row,column)
  // int y = (col/3)*3; // finding y coordinate for the matrix related to the num
  // at (row,column)
  // for (int i = x; i < x+3; i++) {
  // for (int j = y; j < y+3; j++) {
  // if (Sudoku[i][j] == digit) {
  // return false;
  // }

  // }

  // }
  // return true;
  // }

  // public static void printSudoku( int Sudoku[][]){
  // for (int i = 0; i < Sudoku.length; i++) {
  // for (int j = 0; j < Sudoku.length; j++) {
  // System.out.print(Sudoku[i][j]);
  // }
  // System.out.println();
  // }
  // }
  // //
  // ..........................................................................................................

  // // //
  // ..........................................................................................................

  // public static void printSolution(int Sol[][]){
  // for (int i = 0; i < Sol.length; i++) {
  // for (int j = 0; j < Sol.length; j++) {
  // System.out.print(Sol[i][j]);
  // }
  // System.out.println();
  // }
  // }

  // public static boolean RatInMaze(int maze[][]){
  // int n = maze.length;
  // int Sol[][] = new int[n][n];
  // if (!solveMaze(maze,0,0, Sol)) {
  // System.out.println("solution doesn"t exists");
  // return false;
  // }
  // printSolution(Sol);
  // return true;
  // }

  // public static boolean isSafe(int maze[][], int x, int y){
  // return (x>=0 && x<maze.length && y>=0 && y<maze.length && maze[x][y] == 1 );
  // }

  // public static boolean solveMaze(int maze[][],int x, int y, int Sol[][]){
  // // base case
  // if(x == maze.length-1 && y == maze.length-1 && maze[x][y] == 1){
  // Sol[x][y] = 1;
  // return true;
  // }

  // // recursion
  // // checking if it is safe to take the path , if it is safe then update the
  // position in Sol matrix
  // if (isSafe( maze,x, y )) {
  // Sol[x][y] = 1;
  // // the check recursively for further positions
  // if (solveMaze(maze, x+1, y, Sol)) {
  // return true;
  // }
  // if (solveMaze(maze, x, y+1, Sol)) {
  // return true;
  // }
  // // if the boundary condition failed or path is blocked then it will give
  // false
  // // then backtrack
  // Sol[x][y] = 0; // backtrack
  // return false;
  // }

  // return false;
  // }

  // // //
  // ..........................................................................................................

  // final static char L[][] =
  // {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};

  // public static void letterCombinations(String D){
  // int len = D.length();
  // int pos = 0;
  // if(len==0) {System.out.println("");return;}
  // FindAllCombinations(pos,len,new StringBuilder(),D );

  // }

  // public static void FindAllCombinations(int pos , int len, StringBuilder sc
  // ,String D ){
  // // base case
  // if (pos == len) {
  // System.out.println(sc.toString());
  // } else {
  // char[] letters = L[Character.getNumericValue(D.charAt(pos))];
  // // recursion
  // for (int i = 0; i < letters.length; i++) {
  // FindAllCombinations(pos+1, len, new StringBuilder(sc).append(letters[i]), D);
  // }

  // }
  // }

  // ..............................................
  public static void printSolution(int sol[][]) {
    for (int i = 0; i < sol.length; i++) {
      for (int j = 0; j < sol.length; j++) {
        System.out.print(" "+ sol[i][j]+ " ");
      }
      System.out.println();
    }
  }

  public static boolean isSafe(int x, int y, int sol[][]) {
    return (x >= 0 && x < 8 && y >= 0 && y < 8 && sol[x][y] == -1);
  }

  public static boolean SolveKnightChess(int n) {

    int sol[][] = new int[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        sol[i][j] = -1;
      }
    }
    int x_moves[] = {2,1, -1, -2, -2, -1,1,2};
    int y_moves[] = {1,2,2,1, -1, -2, -2, -1};
    
    sol[0][0] = 0;

    if (!SolveKtUtils(0, 0, x_moves, y_moves, sol, 1)) {
      System.out.println("Solution Doesn't exists");
      return false;
    } else {
      printSolution(sol);
    }
    return true;
  }

  public static boolean SolveKtUtils(int x, int y, int x_moves[], int y_moves[], int sol[][], int moves1) {
    if (moves1 == 64) {
      return true;
    }

    for (int k = 0; k < 8; k++) {
      int next_xmove = x + x_moves[k];
      int next_ymove = y + y_moves[k];

      

      if (isSafe(next_xmove, next_ymove, sol)) {
        sol[next_xmove][next_ymove] = moves1;
        if ( SolveKtUtils(next_xmove, next_ymove, x_moves, y_moves, sol, moves1 + 1)) { 
          return true;
        }else{
          sol[next_xmove][next_ymove] = -1; // backtracking
        }
      }
    }
    return false;
  }

  // .............................................
  public static void main(String[] args) {
    // // Backtracking on arrays
    // int[] Arr = new int[5];
    // ChangeArray(Arr,0,1);
    // printArray(Arr);

    // // find Substrings of a String
    // String Str = "abc";
    // int idx = 0;
    // String Ans = "";
    // Subsets(Str, idx, Ans);

    // // find all permutations of a string
    // String Str ="abc";
    // String Ans = "";
    // FindPermutations(Str, Ans);

    // // ** IMP N Queens
    // int n = 3;
    // char arr[][] = new char[n][n];
    // for (int i = 0; i < arr.length; i++) {
    // for (int j = 0; j < arr.length; j++) {
    // arr[i][j] = "X";
    // }
    // }

    // Nqueens(arr, 0);

    //// Grid Ways
    // int n = 3;
    // int m = 3;
    // System.out.println(GridWays(0,0,n,m));

    //// **IMP
    // int Sudoku[][] = {
    // {0,0,8,0,0,0,0,0,0},
    // {4,9,0,1,5,7,0,0,2},
    // {0,0,3,0,0,4,1,9,0},
    // {1,8,5,0,6,0,0,2,0},
    // {0,0,0,0,2,0,0,6,0},
    // {9,6,0,4,0,5,3,0,0},
    // {0,3,0,0,7,2,0,0,4},
    // {0,4,9,0,3,0,0,5,7},
    // {8,2,7,0,0,9,0,1,3}};

    // SudokuSolver(Sudoku, 0, 0);
    // printSudoku(Sudoku);

    // BACKTRACKING QUESTIONS
    // Q.1)Question 1 :Rat in a
    // MazeYouaregivenastartingpositionforaratwhichisstuckinamazeataninitialpoint(0,0)(themazecanbethoughtofasa2-dimensionalplane).ThemazewouldbegivenintheformofasquarematrixoforderN*Nwherethecellswithvalue0representthemaze’sblockedlocationswhilevalue1istheopen/availablepaththattheratcantaketoreachitsdestination.The
    // rat"s destination is at (N - 1, N -
    // 1).Yourtaskistofindallthepossiblepathsthattheratcantaketoreachfromsourcetodestination
    // in the
    // maze.Thepossibledirectionsthatitcantaketomoveinthemazeare"U"(up)i.e.(x,y-1),"D"(down)i.e.
    // (x, y + 1) , "L" (left) i.e. (x - 1, y), "R" (right) i.e. (x + 1, y).(This
    // problem is similar to Grid ways.

    // Sample Input: int maze[][] = {
    // { 1, 0, 0, 0 },
    // { 1, 1, 0, 1 },
    // { 0, 1, 0, 0 },
    // { 1, 1, 1, 1 } };

    // Sample Output:
    // 1 0 0 0
    // 1 1 0 0
    // 0 1 0 0
    // 0 1 1 1

    // int maze[][] = {
    // { 1, 0, 0, 0 },
    // { 1, 1, 0, 1 },
    // { 0, 1, 0, 0 },
    // { 1, 1, 1, 1 } };

    // RatInMaze(maze);

    // Question 2 :Keypad
    // CombinationsGivenastringcontainingdigitsfrom2-9inclusive,printallpossiblelettercombinationsthatthe
    // number could represent. You can print the answer in any
    // order.Amappingofdigitstoletters(justlikeonthetelephonebuttons)isgivenbelow.Notethat1does
    // not map to any letters.

    // Sample Input 1: digits = "23"Sample Output 1: "ad", "ae", "af", "bd", "be",
    // "bf","cd", "ce", "cf"Sample Input 2: digits = "2"Sample Output 2: "a", "b",
    // "c"Sample Input 3: digits = ""Sample Output 3: ””
    //// Keypad Combinations

    // letterCombinations("0");

    int n = 8;
    SolveKnightChess(n);
  }
}
