package com.denisvlem.yandex.coderun.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CohesionComponent {

  public static void main(String[] args) throws IOException {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

      var nmArray = reader.readLine().split(" ");
      var n = Integer.parseInt(nmArray[0]);
      var m = Integer.parseInt(nmArray[1]);

      var adjustmentList = new HashMap<Integer, List<Integer>>();

      for (int i = 0; i < n; ++i) {
        adjustmentList.put(i, new ArrayList<>());
      }

      for (int i = 0; i < m; i++) {
        var edgeArray = reader.readLine().split(" ");

        var from = Integer.parseInt(edgeArray[0]) - 1;
        var to = Integer.parseInt(edgeArray[1]) - 1;

        adjustmentList.get(from).add(to);
        adjustmentList.get(to).add(from);
      }

      var components = new int[n];
      Arrays.fill(components, -1);

      int componentCount = 1;
      for (int i = 0; i < components.length; ++i) {
        if (components[i] == -1) {
          dfs(adjustmentList, i, components, componentCount);
          componentCount += 1;
        }
      }

      System.out.println(componentCount-1);

      var componentsMap = new HashMap<Integer, List<Integer>>();
      for (int i = 1; i < componentCount; i++) {
        componentsMap.put(i, new ArrayList<>());
      }

      for (int i = 0; i < components.length; ++i) {
        componentsMap.get(components[i]).add(i + 1);
      }

      for (var component : componentsMap.entrySet()) {
        System.out.println(component.getValue().size());
        System.out.println(component.getValue()
            .stream().map(String::valueOf)
            .reduce((left, right) -> left + " " + right).orElse("")
        );
      }

    }
  }

  public static void dfs(
      Map<Integer, List<Integer>> adjustmentList,
      int vertex,
      int[] components,
      int componentCount) {

    var stack = new LinkedList<Integer>();
    stack.push(vertex);

    while (!stack.isEmpty()) {
      var next = stack.pop();
      if (components[next] == -1) {
        components[next] = componentCount;
        for (var adjVertex : adjustmentList.get(next)) {
          if (components[adjVertex] == -1) {
            stack.push(adjVertex);
          }
        }
      }
    }
  }
}
