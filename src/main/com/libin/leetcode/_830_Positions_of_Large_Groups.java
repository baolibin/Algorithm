package libin.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (c) 2019/03/25. xixi Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose : 找出连续出现三个及以上的相同字符
 */
public class _830_Positions_of_Large_Groups {
    public static void main(String[] args) {
        List<List<Integer>> list = new _830_Positions_of_Large_Groups().largeGroupPositions("aaaa");
        System.out.println(list);
    }

    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        char[] chars = S.toCharArray();
        int length = chars.length;
        int start = 0;
        int end = 1;
        while (end < length) {
            while (end < length && chars[start] == chars[end]) {
                end++;
            }
            if (end - start > 2) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(start);
                list.add(end-1);
                res.add(list);
            }
            start = end;
            end = end + 1;
        }
        return res;
    }
}
