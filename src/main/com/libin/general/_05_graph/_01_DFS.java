package libin.general._05_graph;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Copyright (c) 2018/8/1. xixi Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose :
 */

public class _01_DFS {

    public static void main(String[] args) {
        // DFS
        Graph dfsGraph = new Graph();
        dfsGraph.addVertex(5);
        dfsGraph.addVertex(2);
        dfsGraph.addVertex(8);
        dfsGraph.addVertex(9);
        dfsGraph.addVertex(6);

        dfsGraph.addEdge(1, 0);
        dfsGraph.addEdge(1, 4);
        dfsGraph.addEdge(4, 2);
        dfsGraph.addEdge(0, 3);

        dfsGraph.dfs();
        System.out.println("===");
        dfsGraph.bfs();
    }
}

// 一个点类型
class Vertex {
    int val;
    boolean visited;

    Vertex(int val) {
        this.val = val;
        this.visited = false;
    }
}

// 图结构
class Graph {
    private final static int maxVertexNum = 10;
    private Vertex vertexList[];
    private int vertexCount;
    private Stack<Integer> stack;
    private int adjMatrix[][];
    private Queue<Integer> queue;

    Graph() {
        vertexList = new Vertex[maxVertexNum];
        vertexCount = 0;
        stack = new Stack<Integer>();
        adjMatrix = new int[maxVertexNum][maxVertexNum];
        for (int i = 0; i < maxVertexNum; i++)
            for (int j = 0; j < maxVertexNum; j++)
                adjMatrix[i][j] = 0;

        queue = new ArrayDeque<Integer>();
    }

    void addVertex(int val) {
        vertexList[vertexCount++] = new Vertex(val);
    }

    void addEdge(int start, int end) {
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }

    // 打印当前正在遍历的节点
    private void display(int index) {
        System.out.println(vertexList[index].val);
    }

    // 获取当前点关联未被遍历的下一个节点
    private int getAdjUnvisitedVertex(int index) {
        for (int i = 0; i < vertexCount; i++) {
            if (adjMatrix[index][i] == 1 && !vertexList[i].visited)
                return i;
        }
        return -1;
    }

    // 深度优先遍历
    void dfs() {
        vertexList[0].visited = true;
        display(0);
        stack.push(0);

        while (!stack.isEmpty()) {
            int index = getAdjUnvisitedVertex(stack.peek());
            if (index == -1) {
                stack.pop();
            } else {
                vertexList[index].visited = true;
                display(index);
                stack.push(index);
            }
        }
        reset();
    }

    // 重置遍历访问位
    private void reset() {
        for (int i = 0; i < vertexCount; i++)
            vertexList[i].visited = false;
    }

    // 广度优先遍历
    void bfs() {
        vertexList[0].visited = true;
        display(0);
        queue.add(0);
        while (!queue.isEmpty()) {
            int v1 = queue.poll();
            int v2 = getAdjUnvisitedVertex(v1);
            while (v2 != -1) {
                vertexList[v2].visited = true;
                display(v2);
                queue.add(v2);
                v2 = getAdjUnvisitedVertex(v1);
            }
        }
        reset();
    }
}
