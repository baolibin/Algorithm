package libin.leetcode;

import java.util.PriorityQueue;

/**
 * Copyright (c) 2019/03/25. xixi Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose : 离原地欧氏距离最近的K个节点
 */
public class _973_K_Closest_Points_to_Origin {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>((a, b) -> b[0] * b[0] + b[1] * b[1] - a[0] * a[0] - a[1] * a[1]);
        for (int[] point : points) {
            priorityQueue.add(point);
            if (priorityQueue.size() > K) {
                priorityQueue.poll();
            }
        }
        int[][] ints = new int[K][2];
        for (int i = 0; i < K; i++) {
            ints[i] = priorityQueue.poll();
        }
        return ints;
    }
}
