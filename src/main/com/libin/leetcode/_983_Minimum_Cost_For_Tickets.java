package libin.leetcode;

/**
 * Copyright (c) 2019/03/26. xixi Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose : 三种火车票(2,7,15)，求旅行天数选择对应车票，总花费最小。
 */
public class _983_Minimum_Cost_For_Tickets {
    public static void main(String[] args) {
        int[] days = {1, 2, 3, 4, 6, 8, 9, 10, 13, 14, 16, 17, 19, 21, 24, 26, 27, 28, 29};
        int[] costs = {3, 14, 50};
        System.out.println(new _983_Minimum_Cost_For_Tickets().mincostTickets(days, costs));
    }

    public int mincostTickets(int[] days, int[] costs) {
        int dp[] = new int[366];
        int trip[] = new int[366]; // 0-364
        for (int day : days) {
            trip[day] = 1;
        }
        for (int j = 1; j <= 365; j++) {
            if (trip[j] == 0)
                dp[j] = dp[j - 1];
            else
                dp[j] = Math.min(Math.min(dp[j - 1] + costs[0], dp[Math.max(j - 7, 0)] + costs[1]), dp[Math.max(j - 30, 0)] + costs[2]);
        }
        return dp[365];
    }
}
