package com.denisvlem.yandex.coderun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LCS {

    final int firstLength;
    final int secondLength;

    final Integer[] firstSeq;
    final Integer[] secondSeq;

    final int[][] dp;
    final Pair[][] prev;

    public LCS(Integer[] seq1, Integer[] seq2) {
        this.firstLength = seq1.length;
        this.secondLength = seq2.length;
        this.firstSeq = seq1;
        this.secondSeq = seq2;
        dp = new int[firstLength + 1][secondLength + 1];
        prev = new Pair[firstLength + 1][secondLength + 1];
    }

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            int firstLength = Integer.parseInt(reader.readLine());
            var firsSeq = Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            int secondLength = Integer.parseInt(reader.readLine());
            var secondSec = Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

            List<Integer> integers = new LCS(firsSeq, secondSec).longestCommonSubsequence();
            System.out.println(integers.size());
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
        }

    }

    public List<Integer> longestCommonSubsequence() {
        for (int row = 1; row < firstSeq.length + 1; ++row) {
            for (int col = 1; col < secondSeq.length + 1; ++col) {
                if (firstSeq[row - 1].equals(secondSeq[col - 1])) {
                    dp[row][col] = dp[row - 1][col - 1] + 1;
                    //в prev сохраняем координату dp из которой пришли в dp[row][col]
                    prev[row][col] = new Pair(row - 1, col - 1);
                } else {
                    if (dp[row - 1][col] > dp[row][col - 1]) {
                        dp[row][col] = dp[row - 1][col];
                        prev[row][col] = new Pair(row - 1, col);
                    } else {
                        dp[row][col] = dp[row][col - 1];
                        prev[row][col] = new Pair(row, col - 1);
                    }
                }
            }
        }
        return path(firstLength, secondLength);
    }

    private List<Integer> path(int x, int y) {
        var lcs = new LinkedList<Integer>();
        int row = x;
        int col = y;
        while (row != 0 && col != 0) {
            //если пришли из x - 1, y - 1, то firstSeq[x - 1] == secondSeq[y - 1]
            if (prev[row][col].equals(new Pair(row - 1, col - 1))) {
                lcs.push(firstSeq[row - 1]);
                row--;
                col--;
            } else {
                if (prev[row][col].equals(new Pair(row - 1, col))) {
                    row--;
                } else {
                    col--;
                }
            }
        }
        return lcs;
    }

    public static class Pair {

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int x;
        public int y;


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (x != pair.x) return false;
            return y == pair.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}
