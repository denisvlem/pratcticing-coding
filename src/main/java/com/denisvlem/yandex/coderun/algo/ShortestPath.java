package com.denisvlem.yandex.coderun.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ShortestPath {

  public static void main(String[] args) throws IOException {

    try (var reader = new BufferedReader(new InputStreamReader(System.in))) {

      var n = Integer.parseInt(reader.readLine());
      var adjList = new ArrayList<List<Integer>>();
      for (int from = 0; from < n; from++) {
        adjList.add(new ArrayList<>());
        var matrixRow = Arrays.stream(reader.readLine().trim().split(" "))
            .map(Integer::parseInt)
            .toArray(Integer[]::new);

        for (int to = 0; to < matrixRow.length; to++) {
          if (matrixRow[to] == 1) {
            adjList.get(from).add(to);
          }
        }
      }

      var fromToArray = Arrays.stream(reader.readLine().split(" "))
          .map(Integer::parseInt).toArray(Integer[]::new);
      var start = fromToArray[0] - 1;
      var finish = fromToArray[1] - 1;

      int[] path = new int[n];
      Arrays.fill(path, -1);
      path[start] = 0;

      var queue = new LinkedList<Integer>();
      queue.push(start);

      while (!queue.isEmpty()) {
        var current = queue.removeFirst();

        for (int to : adjList.get(current)) {
          if (path[to] == -1) {
            queue.add(to);
            path[to] = path[current] + 1;
          }
        }
      }

      System.out.println(path[finish]);
    }
  }
}
