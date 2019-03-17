package libin.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Copyright (c) 2019/03/13. xixi Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose : 给一个表格，每个表格有3种情况，空的、清新的橘子、腐烂的橘子。
 * 每过一分钟，腐烂的橘子都会把周围的橘子变腐烂，求至少多久所有橘子都变腐烂，否则返回-1
 */
public class _994_Rotting_Oranges {

    public static void main(String[] args) {
        // int[][] arr = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        // int[][] arr = {{1, 2}};
        int[][] arr = {{0}};
        _994_Rotting_Oranges oranges = new _994_Rotting_Oranges();
        System.out.println(oranges.orangesRotting(arr));
    }

    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        int rotten = 0;
        int all = 0;
        int minMinute = 0;

        int length = grid.length;
        int width = grid[0].length;

        Queue<cell> queue = new LinkedList<cell>();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == 1) {
                    fresh += 1;
                    all += 1;
                }
                if (grid[i][j] == 2) {
                    rotten += 1;
                    all += 1;
                    queue.add(new cell(i, j));
                }
            }
        }
        if (rotten == 0 && fresh == 0)
            return minMinute;
        if (rotten == 0 && fresh > 0)
            return -1;
        while (!queue.isEmpty() && fresh > 0) {
            int tmp = fresh;
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                cell cur = queue.poll();
                if (cur.x - 1 >= 0 && grid[cur.x - 1][cur.y] == 1) {
                    grid[cur.x - 1][cur.y] = 2;
                    fresh -= 1;
                    rotten += 1;
                    queue.add(new cell(cur.x - 1, cur.y));
                }
                if (cur.x + 1 < length && grid[cur.x + 1][cur.y] == 1) {
                    System.out.println(cur.x + 1);
                    grid[cur.x + 1][cur.y] = 2;
                    fresh -= 1;
                    rotten += 1;
                    queue.add(new cell(cur.x + 1, cur.y));
                }
                if (cur.y - 1 >= 0 && grid[cur.x][cur.y - 1] == 1) {
                    grid[cur.x][cur.y - 1] = 2;
                    fresh -= 1;
                    rotten += 1;
                    queue.add(new cell(cur.x, cur.y - 1));
                }
                if (cur.y + 1 < width && grid[cur.x][cur.y + 1] == 1) {
                    grid[cur.x][cur.y + 1] = 2;
                    fresh -= 1;
                    rotten += 1;
                    queue.add(new cell(cur.x, cur.y + 1));
                }
            }
            if (tmp > fresh)
                minMinute += 1;
        }
        if (rotten == all && fresh == 0)
            return minMinute;
        else
            return -1;
    }
}

class cell {
    int x;
    int y;

    cell(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
