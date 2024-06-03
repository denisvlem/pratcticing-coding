package com.denisvlem.graphs;

import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeSet;

public class Graph {

    private static final int MAX_VERTS = 20;
    private final Vertex[] vertexList;
    private final int[][] adjMatrix;
    private int nVerts;


    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMatrix = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;

        var set = new TreeSet<ZonedDateTime>(Comparator.naturalOrder());
    }

    public void addVert(String value) {
        vertexList[nVerts++] = new Vertex(value);
    }

    public void addEdge(int start, int end) {
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }

    public boolean vertexIsAdjacent(int start, int end) {
        return adjMatrix[start][end] > 0;
    }

    public void printVertex(int v) {
        System.out.print(vertexList[v].getValue());
    }

    public void dfs() {
        if (nVerts < 1) {
            return;
        }

        var stack = new LinkedList<Integer>();
        vertexList[0].setVisited(true);
        printVertex(0);
        stack.push(0);

        while (!stack.isEmpty()) {
            var toVisit = getAdjustUnvisited(stack.peek());
            if (toVisit != -1) {
                vertexList[toVisit].setVisited(true);
                printVertex(toVisit);
                stack.push(toVisit);
            } else {
                stack.pop();
            }
        }
        resetVertexes();
    }

    public void wfs() {
        if (nVerts < 1) {
            return;
        }

        var queue = new LinkedList<Integer>();
        vertexList[0].setVisited(true);
        printVertex(0);
        queue.add(0);

        while (!queue.isEmpty()) {
            var v1 = queue.remove();
            int v2;
            while((v2 = getAdjustUnvisited(v1)) != -1) {
                vertexList[v2].setVisited(true);
                printVertex(v2);
                queue.add(v2);
            }
        }
    }

    public void minimalFrameTree() {

        if (nVerts < 1) {
            return;
        }

        var stack = new LinkedList<Integer>();
        stack.push(0);

        while (!stack.isEmpty()) {
            var currentVert = stack.peek();

            int nextVert = getAdjustUnvisited(currentVert);

            if (nextVert == -1) {
                stack.pop();
            } else {
                printVertex(currentVert);
                printVertex(nextVert);
                System.out.print(" ");
            }

        }
    }

    private void resetVertexes() {
        for (var vertex : vertexList) {
            vertex.setVisited(false);
        }
    }

    public int getAdjustUnvisited(int vert) {
        for (int i = 0; i < nVerts; ++i) {
            if (adjMatrix[vert][i] > 0 && !vertexList[i].visited) {
                return i;
            }
        }
        return -1;
    }

    @Getter
    private static class Vertex {
        private final String value;
        @Setter
        private boolean visited;

        public Vertex(String value) {
            this.value = value;
            this.visited = false;
        }

    }

}
