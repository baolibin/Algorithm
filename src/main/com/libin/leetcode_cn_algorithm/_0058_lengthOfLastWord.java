package libin.leetcode_cn_algorithm;

/**
 * Copyright (c) 2020/4/12. libin Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose : 58. 最后一个单词的长度
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 * 如果不存在最后一个单词，请返回 0 。
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 * <p>
 * 示例:
 * 输入: "Hello World"
 * 输出: 5
 */
public class _0058_lengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String[] str = s.trim().split("\\s++");
        return str.length == 0 ? 0 : str[str.length - 1].length();
    }
}
