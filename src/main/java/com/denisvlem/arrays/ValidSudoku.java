package com.denisvlem.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according
 * to the following rules:
 * <p>
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 * <p>
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        for (int row = 0; row < 9; ++row) {
            if (!isValidRow(board, row)) {
                return false;
            }
            if (!isValidColumn(board, row)) {
                return false;
            }
            if (!isValidSubSquare(board, row)) {
                return false;
            }

        }
        return true;
    }

    private boolean isValidRow(char[][] board, int row) {
        //check for duplicates
        Set<Character> distinct = new HashSet<>();
        for (int i = 0; i < 9; ++i) {
            var currentElement = board[row][i];
            if (currentElement == '0') return false;

            if(currentElement != '.') {
                if(distinct.contains(currentElement)) {
                    return false;
                } else {
                    distinct.add(currentElement);
                }
            }
        }
        return true;
    }

    private boolean isValidColumn(char[][] board, int column) {
        //check for duplicates
        Set<Character> distinct = new HashSet<>();
        for (int i = 0; i < 9; ++i) {
            var currentElement = board[i][column];
            if (currentElement == '0') return false;

            if(currentElement != '.') {
                if(distinct.contains(currentElement)) {
                    return false;
                } else {
                    distinct.add(currentElement);
                }
            }
        }
        return true;
    }

    private boolean isValidSubSquare(char[][] board, int squareNum) {
        Set<Character> distinct = new HashSet<>();

        int xStart = squareNum / 3 * 3;
        int xEnd = xStart + 3;
        int yStart = (squareNum % 3) * 3;
        int yEnd = yStart + 3;

        for (int row = xStart; row < xEnd; ++row) {
            for (int col = yStart; col < yEnd; ++col) {
                var currentElement = board[row][col];
                if (currentElement == '0') return false;

                if(currentElement != '.') {
                    if(distinct.contains(currentElement)) {
                        return false;
                    } else {
                        distinct.add(currentElement);
                    }
                }
            }
        }
        return true;
    }
}
