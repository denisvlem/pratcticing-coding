package com.denisvlem.yandex.coderun.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CohesionComponent {

  public static void main(String[] args) throws IOException {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

      var nmArray = reader.readLine().split(" ");
      var n = Integer.parseInt(nmArray[0]);
      var m = Integer.parseInt(nmArray[1]);

      var graph = new Graph(n);
      var vertexSet = new ArrayList<Integer>();
      for (int i = 0; i < n; ++i) {
        graph.addVertex(i + 1);
        vertexSet.add(i+1);
      }

      for (int i = 0; i < m; i++) {
        var edgeArray = reader.readLine().split(" ");
        graph.addEdge(
            Integer.parseInt(edgeArray[0]) - 1,
            Integer.parseInt(edgeArray[1]) - 1
        );
      }

      StringBuilder output = new StringBuilder();
      var count = 0;
      while (!vertexSet.isEmpty()) {
        var component = graph.getCohesionComponent(vertexSet.get(0) - 1);
        vertexSet.removeAll(component);
        output.append(component.size()).append("\n");
        output.append(component.stream().map(String::valueOf)
            .reduce((left, right) -> left + " " + right).orElse("").trim()).append("\n");
        count++;
      }

      System.out.print(count + "\n" + output);
    }
  }

  public static class Graph {
    List<Node> nodeList;
    boolean[][] adjMatrix;
    int size;

    public Graph(int size) {
      this.nodeList = new ArrayList<>();
      this.adjMatrix = new boolean[size][size];
      this.size = 0;
    }

    public void addVertex(int val) {
      nodeList.add(new Node(val));
      size++;
    }

    public void addEdge(int from, int to) {
      adjMatrix[from][to] = true;
      adjMatrix[to][from] = true;
    }

    public Set<Integer> getCohesionComponent(int vertex) {
      var result = new HashSet<Integer>();
      result.add(nodeList.get(vertex).val);
      nodeList.get(vertex).visited = true;

      var theStack = new LinkedList<Integer>();
      theStack.push(vertex);

      while(!theStack.isEmpty()) {
        var next = getNextAdjustUnvisited(theStack.peek());
        if (next != -1) {
          var nextVert = nodeList.get(next);
          nextVert.visited = true;
          result.add(nextVert.val);
          theStack.push(next);
        } else {
          theStack.pop();
        }
      }
      return result;
    }

    private int getNextAdjustUnvisited(int current) {

      for(int i = 0; i < size; ++i) {
        if (adjMatrix[current][i]
            && !nodeList.get(i).visited
            && i != current) {
          return i;
        }
      }
      return -1;
    }
  }

  public static class Node {
    public final int val;
    public boolean visited;

    public Node(int val) {
      this.val = val;
      this.visited = false;
    }
  }

}
