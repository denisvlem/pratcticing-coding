package com.denisvlem.pointers;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/partition-labels/"\>
 */
public class PartitionLabels {

  public List<Integer> partitionLabels(String s) {

    int[] map = new int[26];

    for (int i = 0; i < s.length(); ++i) {
      map[s.charAt(i) - 'a'] = i;
    }

    int last = 0;
    int first = 0;
    var resultList = new ArrayList<Integer>();
    for (int i = 0; i < s.length(); ++i) {
      last = Math.max(last, map[s.charAt(i) - 'a']);
      if (last == i) {
        resultList.add(last - first + 1);
        first = last + 1;
      }
    }

    return resultList;
  }
}
