package libin.general._01_array;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Copyright (c) 2018/7/8. xixi Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose : 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */

public class _01_maxInWindows {
    public static void main(String[] args) {
        int[] ints = {2, 3, 4, 2, 6, 2, 5, 1};

        ArrayList<Integer> list = new _01_maxInWindows().findMaxInWindows(ints, 3);
        for (int max : list) {
            System.out.println(max);
        }
    }
    public ArrayList<Integer> findMaxInWindows(int[] num, int size) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if (num == null || num.length == 0 || size == 0 || size > num.length) {
            return arrayList;
        }
        LinkedList<Integer> list = new LinkedList<Integer>();  // 存储着num数组的下标值
        for (int i = 0; i < size; i++) {  // 处理第一个子数组
            while (!list.isEmpty() && num[i] >= num[list.getLast()])
                list.removeLast();
            list.addLast(i);
        }
        for (int i = size; i < num.length; i++) {  // 处理之后的窗口
            arrayList.add(num[list.getFirst()]);
            while (!list.isEmpty() && num[i] >= num[list.getLast()])
                list.removeLast();
            if (!list.isEmpty() && list.getFirst() <= (i - size))
                list.removeFirst();
            list.addLast(i);
        }
        arrayList.add(num[list.getFirst()]);
        return arrayList;
    }
}
