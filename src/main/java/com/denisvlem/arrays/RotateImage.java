package com.denisvlem.arrays;

/**
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 * <p>
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 * Example 2:
 * <p>
 * <p>
 * Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 */
public class RotateImage {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //outerStart - верхняя левая граница очередного квадратного "пояса" матрицы
        for (int outerStart = 0; outerStart < n / 2; ++outerStart) {

            final var outerFinish = n - outerStart - 1;

            for (int startCol = outerStart; startCol < outerFinish; ++startCol) {
                int currentRow = outerStart;
                int currentCol = startCol;

                int nextRow = currentCol;
                int nextCol = (n - 1) - currentRow;
                int current = matrix[currentRow][currentCol];
                int next = matrix[nextRow][nextCol];


                while (nextRow != outerStart || nextCol != startCol) {
                    matrix[nextRow][nextCol] = current;
                    current = next;
                    currentRow = nextRow;
                    currentCol = nextCol;
                    nextRow = currentCol;
                    nextCol = (n - 1) - currentRow;
                    next = matrix[nextRow][nextCol];
                }
                matrix[nextRow][nextCol] = current;
            }
        }
    }

}
