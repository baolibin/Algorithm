package libin.leetcode_cn_algorithm._3_character;

import java.util.HashMap;

/**
 * Copyright (c) 2021/4/1. libin Inc. All Rights Reserved.
 * Authors: libin <libin>
 * Purpose : 205. 同构字符串
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 * 示例 1:
 * 输入：s = "egg", t = "add"
 * 输出：true
 * 示例 2：
 * 输入：s = "foo", t = "bar"
 * 输出：false
 * 示例 3：
 * 输入：s = "paper", t = "title"
 * 输出：true
 */
public class _0205_isIsomorphic {
    /**
     * 定义2个map各记录串的映射位置
     */
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Character> st = new HashMap<>();
        HashMap<Character, Character> ts = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i), y = t.charAt(i);
            if (st.containsKey(x) && st.get(x) != y || ts.containsKey(y) && ts.get(y) != x) {
                return false;
            }
            st.put(x, y);
            ts.put(y, x);
        }
        return true;
    }

    /**
     * 解题思路:
     * 使用数组记录字符串中每个字符出现的位置
     */
    public boolean isIsomorphic2(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] charss = s.toCharArray();
        char[] charst = t.toCharArray();
        int[] nums = new int[256]; // 存储字符串s中每个字符出现对应的位置
        int[] numt = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (nums[charss[i]] != numt[charst[i]])
                return false;
            nums[charss[i]] = i + 1;
            numt[charst[i]] = i + 1;
        }
        return true;
    }
}
