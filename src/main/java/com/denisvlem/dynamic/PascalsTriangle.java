package com.denisvlem.dynamic;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; ++i) {
            var row = new ArrayList<Integer>();
            for (int j = 0; j < i + 1; ++j) {
                if (i == 0 || j == i || j == 0) {
                    row.add(1);
                } else {
                    int left = result.get(i - 1).get(j - 1);
                    int right = result.get(i - 1).get(j);
                    row.add(left + right);
                }
            }
            result.add(row);
        }
        return result;
    }
}
