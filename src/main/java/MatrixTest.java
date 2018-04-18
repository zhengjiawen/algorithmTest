package main.java;

import java.util.ArrayList;

public class MatrixTest {
    public static void printMatrix(int[][] matrix){
//        int rowLim = matrix.length;
//        int colLim = matrix[0].length;
//
//        int row = 0;
//        int col = 0;
//
//        while(rowLim > 1){
//            while(col < colLim){
//                System.out.println(matrix[row][col]);
//                col++;
//            }
//            col--;
//            colLim--;
//
//            while(row < rowLim-1){
//                row++;
//                System.out.println(matrix[row][col]);
//
//            }
//            rowLim--;
//            col--;
//            while (col >= matrix[0].length - colLim-1){
//
//                System.out.println(matrix[row][col]);
//                col--;
//
//            }
//            col++;
//            colLim--;
//
//            while (row >  matrix.length - rowLim){
//                row--;
//                System.out.println(matrix[row][col]);
//            }
//
//            col++;
//            colLim++;
//
//        }


    }

    public static void printOne(int[][] matrix , int start,ArrayList<Integer> list)
    {
        int endX = matrix[0].length - start;
        int endY = matrix.length - start;

//        int curX = start;
//        int curY = start;

        for(int i = start;i<endX;i++){
            list.add(matrix[start][i]);
        }

        if(endY-1 > start) {

            for (int j = start + 1; j < endY; j++) {
                list.add(matrix[j][endX - 1]);
            }
            if(endX-1 > start ){

                for(int i = endX-1-1;i>start;i--){
                    list.add(matrix[endY-1][i]);
                }
                for(int j = endY-1;j>start;j--){
                    list.add(matrix[j][start]);
                }
            }
        }



    }
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        int[][] matrix = {  {1,2,3,4}
//                            {5,6,7,8},
//                            {9,10,11,12},
//                            {13,14,15,16}
                            };
        int start = 0;
        while(matrix.length>2*start && matrix[0].length>2*start){
            printOne(matrix,start,list);
            start++;
        }
        System.out.println(list);
    }
}
