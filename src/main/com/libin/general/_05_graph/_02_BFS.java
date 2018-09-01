package libin.general._05_graph;

/**
 * Copyright (c) 2018/8/1. xixi Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose :
 */

public class _02_BFS {

    public static void main(String[] args){

        // BFS
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

        dfsGraph.bfs();
    }
}
