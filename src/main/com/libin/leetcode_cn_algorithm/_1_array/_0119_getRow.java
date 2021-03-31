package libin.leetcode_cn_algorithm._1_array;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (c) 2021/3/31. libin Inc. All Rights Reserved.
 * Authors: libin <libin>
 * <p>
 * Purpose : 119. 杨辉三角 II
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 示例:
 * 输入: 3
 * 输出: [1,3,3,1]
 */
public class _0119_getRow {

    public static void main(String[] args) {
        new _0119_getRow().getRow(3);
    }

    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> curList = new ArrayList<>();
        curList.add(1);
        ArrayList<Integer> preList = (ArrayList<Integer>) curList.clone();
        ;
        for (int i = 1; i < rowIndex + 1; i++) {
            curList.clear();
            curList.add(1);
            for (int j = 1; j < i; j++) {
                curList.add(preList.get(j) + preList.get(j - 1));
            }
            curList.add(1);
            preList = (ArrayList<Integer>) curList.clone();
        }
        return preList;
    }
}
