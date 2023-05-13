package mypackage;
public class Arrays2D {
    public static void print2DArray(int Arr[][]) {
        for (int i = 0; i < Arr.length; i++) {
            for (int j = 0; j < Arr.length; j++) {
                System.out.print(Arr[i][j]);
            }
            System.out.println();
        }
    }
    // **IMP Spiral Matrix--

    // public static void SpiralMatrix(int Matrix[][]){
    // int startingRow = 0;
    // int startingColumn= 0;
    // int endingRow = Matrix.length-1;
    // int endingColumn = Matrix[0].length-1;

    // while(startingRow<=endingRow && startingColumn<=endingColumn ){
    // // traversing top
    // for (int i = startingColumn; i <= endingColumn; i++) {
    // System.out.println(Matrix[startingRow][i]);

    // }
    // // traversing right
    // for (int j = startingRow+1; j <= endingRow; j++) {
    // System.out.println(Matrix[j][endingColumn]);
    // }
    // //traversing bottom
    // for (int i = endingColumn-1; i >=startingColumn; i--) {
    // if (startingRow == endingRow) {
    // break;
    // }
    // System.out.println(Matrix[endingRow][i]);

    // }
    // //traversing left
    // for (int j = endingRow-1; j >=startingRow+1; j--) {
    // if (startingColumn == endingColumn) {
    // break;
    // }
    // System.out.println(Matrix[j][startingColumn]);

    // }
    // startingRow++;
    // startingColumn++;
    // endingRow--;
    // endingColumn--;
    // }

    // }

    // public static int DiagonalSum(int Matrix[][]){
    //     int sum =0;
    //     for (int i = 0; i < Matrix.length; i++) {
    //         sum += Matrix[i][Matrix.length-1-i];
    //         for (int j = 0; j <= Matrix[0].length-1; j++) {
    //             if (i == j) {
    //                 sum+= Matrix[i][j];  
    //             }
    //         }
    //     }
    //     return sum;
    // }


    // **IMP  SEARCH NUMBER IN MATRIX
    // public static boolean SearchNumber(int Matrix[][], int Key){
    //     int row = 0;
    //     int col= Matrix[0].length -1;
    //    while(row < Matrix.length && col>=0){
    //        if (Matrix[row][col]== Key) {
    //         System.out.println("Key found! at position" + "(" + row + "," + col + ")");
    //         return true;
    //        }
    //        else if (Matrix[row][col] > Key) {
    //             col--;
    //        }
    //        else{
    //         row++;
    //        }
    //    }
    //     System.out.println("!Key Not Found");
    //     return false;
    // }

    // public static int QUESTION1(int Matrix[][], int key){
    //     int row = 0;
    //     int col = Matrix[0].length-1;

    //     int repetation = 0;
    //     for (int i = row; i < Matrix.length; i++) {
    //         for (int j = 0; j <= col; j++) {
    //             if(Matrix[i][j] == key){
    //             repetation+=1;    
    //             }
    //         }
    //     }
    //     return repetation;
    // }

    // public static int rowSum(int Matrix[][], int Row){
    //     Row = Row-1;
    //     int Sum = 0;
    //     for (int i = 0; i <= Matrix[0].length-1; i++) {
    //         Sum+= Matrix[Row][i];
    //     }
    //     return Sum;
    // }

    // public static void Transpose(int Matrix[][]){
    //     int row = Matrix.length;
    //     int col = Matrix[0].length;
    //     int[][] DummyMatrix = new int[col][row]; 
    //     for (int i = 0; i < row ; i++) {
    //         for (int j = 0; j < col; j++) {
    //             DummyMatrix[j][i] = Matrix[i][j];
                
    //         }
    //     }
    //     for (int i = 0; i < DummyMatrix.length; i++) {for (int j = 0; j < DummyMatrix[0].length; j++) {
    //         System.out.print(DummyMatrix[i][j]);
    //     }
    //       System.out.println();  
    //     }
    // }

    public static void main(String args[]) {
        // int[][] Arr = {{1,2,3},{4,5,6},{7,8,9}};
        // print2DArray(Arr);

        // **IMP Spiral Matrix
        // int Matrix[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        // SpiralMatrix(Matrix);


        // **IMP sum of diagonals of a Matrix
        // int Matrix[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        // System.out.println( DiagonalSum(Matrix));
        
        // **IMP searching a number in a Matrix
        // int Matrix[][] = {{10,20,30,40},{15,21,31,45},{22,25,32,50},{33,35,46,55}};
        // int key = 35;
        // System.out.println( SearchNumber(Matrix, key));

        // 2D ARRAYS QUESTIONS

        // Question 1 :Print the number of 7’s that are inthe 2d array.Example :Input - int[][] array = { {4,7,8},{8,8,7} };Output - 2

        // int[][] array = { {4,7,8},{8,8,7} };
        // int key = 8;
        //  System.out.println(QUESTION1(array, key)
        //  );        

        // Question 2 :Print out the sum of the numbers inthe second row of the “nums” array.Example :Input - int[][] nums = { {1,4,9},{11,4,3},{2,2,3} };Output - 18

        // int[][] nums = { {1,4,9},{11,4,3},{2,2,3} };
        // int rowNum = 3;
        // System.out.println(rowSum(nums,rowNum)
        // );

        // Question 3 :Write a program to FindTransposeofa Matrix.What is Transpose?Transpose of a matrix is the process ofswapping therows to columns. For a 2x3 matrix,Matrix a11    a12    a13 a21    a22    a23 Transposed Matrix a11a21 a12a22 a13a23

        // int[][] Matrix = {{1,2,3},{3,4,5}};
        // Transpose(Matrix);

    }
}
