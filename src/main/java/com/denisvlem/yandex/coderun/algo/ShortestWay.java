package com.denisvlem.yandex.coderun.algo;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShortestWay {

  public static void main(String[] args) throws IOException {

    try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
      var n = Integer.parseInt(reader.readLine());
      var adjList = new ArrayList<List<Integer>>();

      for (int i = 0; i < n; ++i) {
        var strLine = reader.readLine().trim();
        var array = Arrays.stream(strLine.split(" ")).map(Byte::parseByte).toArray(Byte[]::new);
        adjList.add(new ArrayList<>());
        for (int to = 0; to < array.length; to++) {
          if(array[to] == 1) {
            adjList.get(i).add(to);
          }
        }
      }

      var fromTo = Arrays.stream(reader.readLine().split(" "))
          .map(Integer::parseInt).toArray(Integer[]::new);

      shortestWay(n, adjList, fromTo[0] - 1, fromTo[1] - 1);
    }
  }

  public static void shortestWay(int n, List<List<Integer>> adjList, int start, int end) {
    var queue = new ArrayDeque<Integer>();

    queue.add(start);
    int[] pathWay = new int[n];
    int[] steps = new int[n];
    Arrays.fill(pathWay, -1);
    pathWay[start] = 0;

    while (!queue.isEmpty()) {
      int current = queue.removeFirst();
      for (int to : adjList.get(current)) {
        if (pathWay[to] == -1) {
          queue.add(to);
          pathWay[to] = pathWay[current] + 1;
          steps[to] = current;
        }
      }
    }
    System.out.println(pathWay[end]);

    var stack = new ArrayDeque<Integer>();
    stack.push(end);
    int current = end;
    while (current != start) {
      stack.push(steps[current]);
      current = steps[current];
    }
    var pathString = stack.stream().map(val -> val + 1).map(String::valueOf)
        .reduce((left, right) -> left + " " + right).orElse("");
    System.out.println(pathString);
  }

}
