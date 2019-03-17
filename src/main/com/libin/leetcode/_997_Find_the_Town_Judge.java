package libin.leetcode;

/**
 * Copyright (c) 2019/03/13. xixi Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose : 在一个小镇里有N个人，找出其中的小镇法官。
 * 小镇法官不相信任何人；
 * 每个人都相信小镇法官(除了法官自己)；
 * 只要一个人同时满足以上两点；
 */
public class _997_Find_the_Town_Judge {
    public static void main(String[] args) {
        // int[][] arr = {{1, 2}};
        int[][] arr = {{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}};
        _997_Find_the_Town_Judge judge = new _997_Find_the_Town_Judge();
        int judgeJudge = judge.findJudge(4, arr);
        System.out.println(judgeJudge);
    }

    public int findJudge(int N, int[][] trust) {
        int[] inDegree = new int[N];
        int[] outDegree = new int[N];

        for (int i = 0; i < trust.length; i++) {
            outDegree[trust[i][0] - 1]++;
            inDegree[trust[i][1] - 1]++;
        }
        for (int k = 0; k < N; k++) {
            if (inDegree[k] == N - 1 && outDegree[k] == 0)
                return k + 1;
        }
        return -1;
    }
}
