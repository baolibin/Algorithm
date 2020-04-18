package libin.Cracking_the_Coding_Interview;

/**
 * Copyright (c) 2020/4/18. libin Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose : 面试题 01.03. URL化
 * URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
 * <p>
 * 示例1:
 * 输入："Mr John Smith    ", 13
 * 输出："Mr%20John%20Smith"
 * 示例2:
 * 输入："               ", 5
 * 输出："%20%20%20%20%20"
 * 提示：
 * <p>
 * 字符串长度在[0, 500000]范围内。
 */
public class _0103_replaceSpaces {
    public String replaceSpaces(String S, int length) {
        int len = length;
        char[] chars = S.toCharArray();
        for (int i = 0; i < length; i++) {
            if (chars[i] == ' ') {
                len += 3;
            }
        }
        char[] res = new char[len];
        for (int i = length - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                res[--len] = '0';
                res[--len] = '2';
                res[--len] = '%';
            } else {
                res[--len] = chars[i];
            }
        }
        return new String(res, len, res.length - len);  // "\u0000"
    }
}
