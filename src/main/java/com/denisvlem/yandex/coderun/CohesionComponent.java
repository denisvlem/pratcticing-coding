package com.denisvlem.yandex.coderun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class CohesionComponent {

    public static void main(String[] args) throws IOException {
        try(
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ) {
            String graphSizeInput = reader.readLine();
            var vertNum = Integer.parseInt(graphSizeInput.split(" ")[0]);
            var edgeNum = Integer.parseInt(graphSizeInput.split(" ")[1]);
            var graph = new Graph();

            for (int i = 0; i < vertNum; ++i) {
                graph.addVert(i+1);
            }

            for (int i = 0; i < edgeNum; ++i) {
                var edgeInput = reader.readLine();
                var from = Integer.parseInt(edgeInput.split(" ")[0]);
                var towards = Integer.parseInt(edgeInput.split(" ")[1]);
                graph.addEdge(from - 1, towards - 1);
            }

            List<Integer> integers = graph.cohesionComponent(1);

            System.out.println(integers.size());
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
        }
    }

    public static class Graph {
        private static final int MAX_VERTEXES = 1000;
        private int size;
        private final Node[] vertList;
        private final int[][] adjMatrix;

        public Graph() {
            this.vertList = new Node[MAX_VERTEXES];
            this.adjMatrix = new int[MAX_VERTEXES][MAX_VERTEXES];
            this.size = 0;
        }

        public void addVert(int val) {
            vertList[size++] = new Node(val);
        }

        public void addEdge(int from, int to) {
            adjMatrix[from][to] = 1;
            adjMatrix[to][from] = 1;
        }

        public List<Integer> cohesionComponent(int startVertexValue) {
            var result = new ArrayList<Integer>();
            var theStack = new LinkedList<Node>();
            int startNode = startVertexValue - 1;
            theStack.push(vertList[startNode]);
            vertList[startNode].visited = true;
            result.add(vertList[startNode].value);

            while (!theStack.isEmpty()) {

                var unvisited = getNextAdjUnvisited(theStack.peek().value - 1);
                if (unvisited != -1) {
                    vertList[unvisited].visited = true;
                    result.add(vertList[unvisited].value);
                    theStack.push(vertList[unvisited]);
                } else {
                    theStack.pop();
                }
            }
            resetVertexes();
            result.sort(Comparator.naturalOrder());
            return result;
        }

        private int getNextAdjUnvisited(int vertex) {

            for (int i = 0; i < size; ++i) {
                if (adjMatrix[vertex][i] == 1 && !vertList[i].visited && i != vertex) {
                    return i;
                }
            }
            return -1;
        }

        private void resetVertexes() {
            for (int i = 0; i < size; ++i) {
                vertList[i].visited = false;
            }
        }

    }

    private static class Node {
        int value;
        boolean visited;

        public Node(int value, boolean visited) {
            this.value = value;
            this.visited = visited;
        }

        public Node(int value) {
            this(value, false);
        }
    }
}
