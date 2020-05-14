package libin.leetcode_cn_algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (c) 2020/5/14. 小彬科技 Inc. All Rights Reserved.
 * Authors: libin <小彬科技>
 * <p>
 * Purpose :
 */
public class _0118_generate {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (numRows <= 0) {
            return lists;
        }
        List<Integer> tmp = new ArrayList<>();
        tmp.add(1);
        lists.add(tmp);
        for (int i = 1; i < numRows; i++) {
            List<Integer> curList = new ArrayList<>();
            List<Integer> preList = lists.get(i - 1);
            curList.add(1);
            for (int j = 1; j < i; j++) {
                curList.add(preList.get(j) + preList.get(j - 1));
            }
            curList.add(1);
            lists.add(curList);
        }
        return lists;
    }
}
