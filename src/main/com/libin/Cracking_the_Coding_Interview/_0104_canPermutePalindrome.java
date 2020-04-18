package libin.Cracking_the_Coding_Interview;

/**
 * Copyright (c) 2020/4/18. libin Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose : 面试题 01.04. 回文排列
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 * 回文串不一定是字典当中的单词。
 * <p>
 * 示例1：
 * 输入："tactcoa"
 * 输出：true（排列有"tacocat"、"atcocta"，等等）
 */
public class _0104_canPermutePalindrome {
    public boolean canPermutePalindrome(String s) {
        int count = 0;
        char[] chars = s.toCharArray();
        int[] dic = new int[128];
        for (int i = 0; i < chars.length; i++) {
            if ((dic[chars[i]]++ & 1) == 1) { // 判断当前元素是否出现偶数个
                dic[chars[i]] = 0;
                count--;
            } else {
                count++;
            }
        }
        return count <= 1;
    }
}
